(ns jp.blackawa.example.route)

(def route
  [""
   {;; site
    "/" :site.top/index
    "/categories" {["/" :category] :site.category/show}
    "/items" {["/" :item-id] :site.item/show}
    ;; api
    "/api"
    {"/books" :api.book/index}}])
