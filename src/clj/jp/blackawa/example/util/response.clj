(ns jp.blackawa.example.util.response
  (:require [ring.util.response :as res]
            [rum.core :as rum]))

(defn- html-response [resp]
  (assoc-in resp [:headers "Content-Type"] "text/html;charset=utf-8"))

(defn rum-ok [coll]
  (-> (res/response (rum/render-static-markup coll))
      html-response))
