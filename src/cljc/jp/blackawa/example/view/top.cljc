(ns jp.blackawa.example.view.top
  (:require [jp.blackawa.example.view.layout :refer [layout]]))

(defn index []
  (layout [:h1.title "Hello from root."]))
