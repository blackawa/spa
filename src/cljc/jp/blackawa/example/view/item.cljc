(ns jp.blackawa.example.view.item
  (:require [jp.blackawa.example.view.layout :refer [layout]]))

(defn show []
  (layout [:h1.title "Hello from item"]))
