(defproject jp.blackawa.example/spa "0.1.0-SNAPSHOT"
  :description "Example application for: stuartsierra's component / rum / bidi / server side rendering"
  :url "https://github.com/blackawa/spa"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.stuartsierra/component "0.3.2"]
                 [org.danielsz/system "0.4.1"]
                 [ring "1.6.3"]
                 [ring/ring-defaults "0.3.1"]
                 [rum "0.11.2"]
                 [bidi "2.1.3"]
                 [metosin/muuntaja "0.5.0"]]
  :source-paths ["src/clj" "src/cljc"]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [com.stuartsierra/component.repl "0.2.0"]
                                  [figwheel-sidecar "0.5.15"]]
                   :source-paths ["dev"]}}
  :cljsbuild {:builds [{:source-paths ["src/cljs" "src/cljc"]
                        :compiler {:main "front.web.client"
                                   :asset-path "/js/out"
                                   :closure-defines {"goog.DEBUG" false}
                                   :verbose true
                                   :output-to "resources/public/js/main.js"
                                   :optimizations :advanced
                                   :pretty-print false}}]})
