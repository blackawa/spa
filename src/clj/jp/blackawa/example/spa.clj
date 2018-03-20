(ns jp.blackawa.example.spa
  (:gen-class)
  (:require [bidi.ring]
            [com.stuartsierra.component :as component]
            [system.components.endpoint :refer [new-endpoint]]
            [system.components.handler :refer [new-handler]]
            [system.components.jetty :refer [new-jetty]]
            [system.components.middleware :refer [new-middleware]]
            [jp.blackawa.example.endpoint :refer [site-endpoint api-endpoint endpoint]]
            [jp.blackawa.example.middleware :refer [wrap]]))

(defn system []
  (component/system-map
   :http (component/using (new-jetty :port 3000) [:handler])
   :handler (component/using (new-handler :router :bidi) [:endpoint :middleware])
   :middleware (new-middleware {:middleware [wrap]})
   :endpoint (component/using (new-endpoint endpoint) [:site-endpoint :api-endpoint])
   :site-endpoint (new-endpoint site-endpoint)
   :api-endpoint (new-endpoint api-endpoint)))
