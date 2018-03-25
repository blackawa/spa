(ns jp.blackawa.example.client
  (:require [accountant.core :as accountant]
            [bidi.bidi :refer [match-route]]
            [rum.core :as rum]
            [jp.blackawa.example.flow :as flow]
            [jp.blackawa.example.route :refer [route]]
            [jp.blackawa.example.view.layout :as layout]))

(enable-console-print!)

(if goog.DEBUG
  (println "Start debug mode :)"))

(when-let [app (js/document.getElementById "app")]
  (rum/mount (layout/app flow/state) app))

(defn on-js-reload []
  (swap! flow/state update-in [:__figwheel_counter] inc))
