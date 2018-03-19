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
    (let [wrap-debug
          (fn [handler]
            (let [_ (println "req:" req)
                  res (handler req)
                  _ (println "res:" res)]
              res))
          wrapped-handler
          (if (clojure.string/starts-with? (:uri req) "/api")
            ;; api
            (-> handler
                wrap-format
                (wrap-defaults api-defaults))
            ;; site
            (-> handler
                (wrap-defaults site-defaults)))]
      (handler req))))

(defn- endpoint [component]
  ["/" {"index.html"
        (fn [req] (res/response (str req)))
        "api/"
        {"books"
         (fn [req]
           (res/response [{:title "ダンジョン飯" :author "九井諒子"}
                          {:title "鋼の錬金術師" :author "荒川弘"}]))}}])

(defn system []
  (component/system-map
   :http (component/using (new-jetty :port 3000) [:handler])
   :handler (component/using (new-handler :router :bidi) [:endpoint :middleware])
   :middleware (new-middleware {:middleware [wrap]})
   :endpoint (new-endpoint endpoint)))
