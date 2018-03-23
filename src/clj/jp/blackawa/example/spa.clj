(ns jp.blackawa.example.spa
  (:gen-class)
  (:require [bidi.ring]
            [com.stuartsierra.component :as component]
            [system.components.endpoint :refer [new-endpoint]]
            [system.components.handler :refer [new-handler]]
            [system.components.jetty :refer [new-jetty]]
            [system.components.middleware :refer [new-middleware]]
            [jp.blackawa.example.endpoint :refer [endpoint]]
            [jp.blackawa.example.middleware :refer [wrap]]
            [jp.blackawa.example.util.bidi])
  (:import [jp.blackawa.example.controller SiteTopIndexController SiteCategoryShowController SiteItemShowController]))

(defn system []
  (component/system-map
   :http (component/using (new-jetty :port 3000) [:handler])
   :handler (component/using (new-handler :router :bidi) [:endpoint :middleware])
   :middleware (new-middleware {:middleware [wrap]})
   :endpoint (component/using (new-endpoint endpoint) [:site.top/index :site.category/show :site.item/show])
   :site.top/index (SiteTopIndexController.)
   :site.category/show (SiteCategoryShowController.)
   :site.item/show (SiteItemShowController.)))
