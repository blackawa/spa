(ns jp.blackawa.example.endpoint
  (:require [jp.blackawa.example.util.response :as res]
            [jp.blackawa.example.view.top :as view]))

(defn site-endpoint [component]
  {"/" (fn [req] (res/rum-ok (view/index)))})

(defn api-endpoint [component]
  {"/api"
   {"/books"
    (fn [req]
      {:status 200
       :body [{:title "ダンジョン飯" :author "九井諒子"}
              {:title "鋼の錬金術師" :author "荒川弘"}]})}})

(defn endpoint [{{site-routes :routes} :site-endpoint {api-routes :routes} :api-endpoint}]
  ["" (merge site-routes api-routes)])
