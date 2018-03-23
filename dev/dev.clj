(ns dev
  (:require
   [clojure.java.io :as io]
   [clojure.java.javadoc :refer [javadoc]]
   [clojure.pprint :refer [pprint]]
   [clojure.reflect :refer [reflect]]
   [clojure.repl :refer [apropos dir doc find-doc pst source]]
   [clojure.set :as set]
   [clojure.string :as string]
   [clojure.test :as test]
   [clojure.tools.namespace.repl :refer [refresh refresh-all clear]]
   [com.stuartsierra.component :as component]
   [com.stuartsierra.component.repl :refer [reset set-init start stop system]]
   [figwheel-sidecar.system :refer [create-figwheel-system]]
   [jp.blackawa.example.spa :as main]))

;; Do not try to load source code from 'resources' directory
(clojure.tools.namespace.repl/set-refresh-dirs "dev" "src" "test")

(defn dev-system
  "Constructs a system map suitable for interactive development."
  []
  (-> (main/system)
      (assoc :figwheel
             (create-figwheel-system
              {:figwheel-options {}
               :build-ids ["dev"]
               :all-builds
               [{:id "dev"
                 :figwheel true
                 :source-paths ["src/cljs" "src/cljc"]
                 :compiler {:main "jp.blackawa.example.client"
                            :asset-path "/js/out"
                            :output-to "resources/public/js/main.js"
                            :output-dir "resources/public/js/out"
                            :closure-defines {'goog.DEBUG true}
                            :verbose false
                            :optimizations :none}}]}))))

(set-init (fn [_] (dev-system)))
