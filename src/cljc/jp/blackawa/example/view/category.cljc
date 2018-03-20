(ns jp.blackawa.example.view.category
  (:require [jp.blackawa.example.view.layout :refer [layout]]))

(defn show [{:keys [category]}]
  (layout [:h1.title (format "Hello from category[%s]" category)]))
