(ns jp.blackawa.example.transformer.view
  (:require [jp.blackawa.example.flow :as f]
            [jp.blackawa.example.view.top :as top]))

(def ^:private view-map
  {:site.top/index top/index})

(defmethod f/transform :view
  [state {k :handler}]
  (println "state:" state)
  (assoc state :view (k view-map)))
