(ns jp.blackawa.example.flow
  (:require [cljs.core.async :refer [chan put! <!]]
            [jp.blackawa.example.view.top :as top])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

;; FIXME: Use stuartsierra's component to manage stateful objects.
(defonce state (atom {}))
(defonce actions (chan))

(defn dispatch
  ([type] (dispatch type nil))
  ([type data] (put! actions [type data])))

(defmulti transform
  (fn [state data dispatch action-type] action-type))

(go-loop []
  (when-let [a (<! actions)]
    (let [[type data] a]
      (swap! state transform data dispatch type))
    (recur)))

(defmethod transform :view
  [state {k :handler}]
  (let [view-map {:site.top/index top/index}]
    (assoc state :view (or (k view-map) top/index))))

(defmethod transform :change-name
  [state value]
  (assoc state :name value))
