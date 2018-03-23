(ns jp.blackawa.example.endpoint
  (:require [jp.blackawa.example.util.bidi :refer [keyword->handler]]))

(defn endpoint [component]
  (keyword->handler component) ;; FIXME: Second responsibility for this function...
  [""
   ;; site
   {"/" :site.top/index
    "/categories" {["/" :category] :site.category/show}
    "/items" {["/" :item-id] :site.item/show}}
   ;; api
   {"/api"
    {"/books" (fn [req] {:status 200 :body [{:a 1} {:b 2}]})}}])
