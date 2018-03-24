(ns jp.blackawa.example.view.layout
  (:require [rum.core :as rum]
            [jp.blackawa.example.view.partial :as partial]
            #?(:cljs [jp.blackawa.example.flow :refer [dispatch]])))

(rum/defc current-view [state]
  [:div
   [:p "View:" (:view state)]
   [:div {:on-click #?(:cljs #(dispatch :sample 1)
                       :clj nil)} "Sample:" (:sample state)]])

(rum/defc app < rum/reactive [state]
  [:div
   (partial/header {})
   [:section.section
    [:div.container
     ;; bodyをルーティングに応じて変える.]
     (current-view state)]]])

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
