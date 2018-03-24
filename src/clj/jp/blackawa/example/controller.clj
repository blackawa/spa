(ns jp.blackawa.example.controller
  (:require [com.stuartsierra.component :as component]
            [jp.blackawa.example.util.response :as res]
            [jp.blackawa.example.view
             [category :as category]
             [item :as item]
             [layout :refer [layout]]
             [top :as top]]
            [jp.blackawa.example.model
             [item :as item-model]]))

(defrecord SiteTopIndexController []
  component/Lifecycle
  (start [component]
    (assoc component :controller (fn [req] (res/rum-ok (layout (top/index))))))
  (stop [component] (dissoc component :controller)))

(defrecord SiteCategoryShowController []
  component/Lifecycle
  (start [component]
    (assoc component :controller (fn [req]
                                           (let [category (get-in req [:params :category])]
                                             (res/rum-ok
                                              (category/show
                                               {:category category
                                                :items (item-model/find-by-category category)}))))))
  (stop [component] (dissoc component :controller)))

(defrecord SiteItemShowController []
  component/Lifecycle
  (start [component]
    (assoc component :controller (fn [req]
                                       (let [item-id (read-string (get-in req [:params :item-id]))
                                             item (item-model/find-by-id item-id)]
                                         (res/rum-ok (item/show {:item item}))))))
  (stop [component] (dissoc component :controller)))

(defrecord ApiBookIndexController []
  component/Lifecycle
  (start [component]
    (assoc component :controller (fn [req] {:status 200 :body [{:title "hoge" :author "fuga"}]})))
  (stop [component] (dissoc component :controller)))
