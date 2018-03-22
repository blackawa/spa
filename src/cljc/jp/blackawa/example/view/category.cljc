(ns jp.blackawa.example.view.category
  (:require [rum.core :as rum]
            [jp.blackawa.example.view.layout :refer [layout]]))

(rum/defc list-item [item]
  [:a {:href (:uri item)}
   [:div.card
   [:div.card-image
    [:figure.image.is-300x300
     [:img {:src (:image-url item)}]]]
   [:div.card-content
    [:div.content
     [:p.title.is-5 (:title item)]
     [:p.subtitle.is-6 [:span {:dangerouslySetInnerHTML {:__html "&yen;"}}] [:span (:price item)]]]]]])

(defn show [{:keys [category items]}]
  (layout
   [:h1.title (format "Items for %s" category)]
   [:div.columns.is-multiline
    (map (fn [item] [:div.column.is-one-fifth (list-item item)]) items)]))
