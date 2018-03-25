(ns jp.blackawa.example.view.layout
  (:require [rum.core :as rum]
            [jp.blackawa.example.view.partial :as partial]
            #?(:cljs [jp.blackawa.example.flow :refer [dispatch]])))

(rum/defc current-view < rum/reactive [state]
  [:div
   [:p "View:" (:view state)]
   [:div {:on-click #?(:cljs #(dispatch :sample 1)
                       :clj nil)} "Sample:" (rum/react (:sample state))]])

(rum/defc form [state]
  [:.app
   [:h1 (str "Hello, " (:name state))]
   [:input {:type "input"
            :value (or (:name state) "")
            :on-change #?(:clj nil :cljs #(dispatch :change-name (.. % -target -value)))}]])

(rum/defc app < rum/reactive [state]
  [:div
   (partial/header)
   [:.section
    [:.container
     (form (rum/react state))]]])

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
