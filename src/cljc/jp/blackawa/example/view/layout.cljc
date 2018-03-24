(ns jp.blackawa.example.view.layout
  (:require [rum.core :as rum]
            [jp.blackawa.example.view.partial :as partial]))

(rum/defc app [state]
  [:div
   (partial/header {})
   [:section.section
    [:div.container
     ;; bodyをルーティングに応じて変える.
     [:h1.title "change me"]]]])

(defn layout [& body]
  [:html
   (partial/html-headers)
   [:body
    [:div#app
     (partial/header {})
     [:section.section
      [:div.container
       body]]]
    (partial/javascripts)]])
