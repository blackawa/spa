(ns jp.blackawa.example.endpoint
  (:require [jp.blackawa.example.route :refer [route]]
            [jp.blackawa.example.util.bidi :refer [keyword->handler]]))

(defn endpoint [component]
  (keyword->handler component) ;; FIXME: Second responsibility for this function...
  route)
