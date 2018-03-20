(ns jp.blackawa.example.spa
  (:gen-class)
  (:require [bidi.ring]
            [com.stuartsierra.component :as component]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults api-defaults]]
            [ring.util.response :as res]
            [muuntaja.middleware :refer [wrap-format]]
            [system.components.endpoint :refer [new-endpoint]]
            [system.components.handler :refer [new-handler]]
            [system.components.jetty :refer [new-jetty]]
            [system.components.middleware :refer [new-middleware]]))

(defn- wrap [handler]
  (fn [req]
    (let [wrapped-handler
          (if (clojure.string/starts-with? (:uri req) "/api")
            ;; api
            (-> handler wrap-format (wrap-defaults api-defaults))
            ;; site
            (-> handler (wrap-defaults site-defaults)))]
      (wrapped-handler req))))

(defn- site-endpoint [component]
  {"/index.html" (fn [req] (res/response (str req)))})

(defn- api-endpoint [component]
  {"/api"
   {"/books"
    (fn [req]
      (res/response [{:title "ダンジョン飯" :author "九井諒子"}
                     {:title "鋼の錬金術師" :author "荒川弘"}]))}})

(defn- endpoint [{{site-routes :routes} :site-endpoint {api-routes :routes} :api-endpoint}]
  ["" (merge site-routes api-routes)])

(defn system []
  (component/system-map
   :http (component/using (new-jetty :port 3000) [:handler])
   :handler (component/using (new-handler :router :bidi) [:endpoint :middleware])
   :middleware (new-middleware {:middleware [wrap]})
   :endpoint (component/using (new-endpoint endpoint) [:site-endpoint :api-endpoint])
   :site-endpoint (new-endpoint site-endpoint)
   :api-endpoint (new-endpoint api-endpoint)))
