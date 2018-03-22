(ns jp.blackawa.example.endpoint
  (:require [jp.blackawa.example.util.response :as res]
            [jp.blackawa.example.view
             [category :as category]
             [item :as item]
             [top :as top]]
            [jp.blackawa.example.model
             [item :as item-model]]))

(defn site-endpoint [component]
  {"/" (fn [req] (res/rum-ok (top/index)))
   "/categories" {["/" :category]
                  (fn [req]
                    (let [category (get-in req [:params :category])]
                      (res/rum-ok
                       (category/show
                        {:category category
                         :items (item-model/find-by-category category)}))))}
   "/items" {["/" :item-id]
             (fn [req] (res/rum-ok (item/show {:item (item-model/find-by-id (read-string (get-in req [:params :item-id])))})))}})

(defn api-endpoint [component]
  {"/api"
   {"/books"
    (fn [req]
      {:status 200
       :body [{:title "ダンジョン飯" :author "九井諒子"}
              {:title "鋼の錬金術師" :author "荒川弘"}]})}})

(defn endpoint [{{site-routes :routes} :site-endpoint {api-routes :routes} :api-endpoint}]
  ["" (merge site-routes api-routes)])
