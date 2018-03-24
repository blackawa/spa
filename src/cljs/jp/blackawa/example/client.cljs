(ns jp.blackawa.example.client
  (:require [accountant.core :as accountant]
            [bidi.bidi :refer [match-route]]
            [rum.core :as rum]
            [jp.blackawa.example.flow :refer [dispatch]]
            [jp.blackawa.example.route :refer [route]]
            [jp.blackawa.example.view.layout :as layout]))

(enable-console-print!)

(if goog.DEBUG
  (println "Start debug mode :)"))

(when-let [app (.getElementById js/document "app")]
  (accountant/configure-navigation!
   {:nav-handler
    (fn [path]
      (dispatch :view (match-route route path)))
    :path-exists?
    (fn [path]
      (some? (match-route route path)))})
  (accountant/dispatch-current!)
  (rum/mount (layout/app) app))
