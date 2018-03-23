(ns jp.blackawa.example.view.item
  (:require [jp.blackawa.example.view.layout :refer [layout]]
            [jp.blackawa.example.view.partial :as partial]))

(defn show [{:keys [item]}]
  (layout
   [:div.columns
    [:div.column
     [:figure.image.is-300x300
      [:img {:src (:image-url item)}]]]
    [:div.column
     [:h1.title (:title item)]
     [:div.is-6 (partial/price (:price item))]
     [:div.content (:description item)]
     [:div.field.is-grouped
      [:div.control
       [:button.button.is-success
        [:span.icon [:i.fas.fa-shopping-cart]]
        [:span "Add to Cart"]]]
      [:div.control
       [:button.button
        [:span.icon [:i.fas.fa-star]]
        [:span "Add to Favorite"]]]]]]))
