(ns jp.blackawa.example.endpoint
  (:require [jp.blackawa.example.util.response :as res]
            [jp.blackawa.example.view
             [category :as category]
             [item :as item]
             [top :as top]]
            [jp.blackawa.example.model
             [item :as item-model]]))

(defn- ^{:ring-handler :site.top/index} top [req]
  (res/rum-ok (top/index)))

(defn- ^{:ring-handler :site.category/show} category [req]
  (let [category (get-in req [:params :category])]
    (res/rum-ok
     (category/show
      {:category category
       :items (item-model/find-by-category category)}))))

(defn- ^{:ring-handler :site.item/show} item [req]
  (let [item (item-model/find-by-id (read-string (get-in req [:params :item-id])))]
    (res/rum-ok (item/show {:item item}))))

(defn site-endpoint [component]
  {"/" :site.top/index
   "/categories" {["/" :category] :site.category/show}
   "/items" {["/" :item-id] :site.item/show}})

(defn- ^{:ring-handler :api.books/index} books [req])

(defn api-endpoint [component]
  {"/api"
   {"/books" :api.books/index}})

(defn endpoint [{{site-routes :routes} :site-endpoint {api-routes :routes} :api-endpoint}]
  ["" (merge site-routes api-routes)])
