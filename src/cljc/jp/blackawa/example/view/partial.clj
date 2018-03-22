(ns jp.blackawa.example.view.partial
  (:require [rum.core :as rum]))

(defn html-headers []
  [:head
   [:title "Sample Application with stuartsierra's component / rum / bidi / server-side rendering"]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
   [:link {:rel "stylesheet" :href "https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css"}]])

(defn javascripts []
  [:div
   [:script {:src "https://use.fontawesome.com/releases/v5.0.8/js/all.js"
             :defer true
             :integrity "sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
             :crossorigin "anonymous"}]])

(rum/defc price [n]
  [:span [:span {:dangerouslySetInnerHTML {:__html "&yen;"}}] [:span n]])
