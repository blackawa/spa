(ns jp.blackawa.example.view.layout
  (:require [jp.blackawa.example.view.partial :as partial]))

(defn layout [& body]
  [:html
   (partial/html-headers)
   [:body
    (partial/header {})
    [:section.section
     [:div.container
      body]]
    (partial/javascripts)]])
