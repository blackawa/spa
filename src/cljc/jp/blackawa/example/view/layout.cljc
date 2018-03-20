(ns jp.blackawa.example.view.layout
  (:require [jp.blackawa.example.view.partial :as partial]))

(defn layout [& body]
  [:html
   (partial/html-headers)
   [:body
    [:section.section
     [:div.container
      body]]
    (partial/javascripts)]])
