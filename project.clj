(defproject foobar "0.0.1-SNAPSHOT"
  :description "Cool new project to do things and stuff"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.6.0"]
                 [clj-http "3.6.1"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-defaults "0.3.1"]]
  :plugins [[lein-ring "0.12.0"]]
  :ring {:handler foobar.core/app}
  :profiles {:dev {:dependencies [[midje "1.8.3"]
                                  [javax.servlet/servlet-api "2.5"]
                                  [clj-wiremock "0.3.0"]
                                  [ring/ring-mock "0.3.0"]]}
             ;; You can add dependencies that apply to `lein midje` below.
             ;; An example would be changing the logging destination for test runs.
             :midje {}}
  :repl-options {:nrepl-middleware
                 [cider.nrepl.middleware.apropos/wrap-apropos
                  cider.nrepl.middleware.classpath/wrap-classpath
                  cider.nrepl.middleware.complete/wrap-complete
                  cider.nrepl.middleware.info/wrap-info
                  cider.nrepl.middleware.inspect/wrap-inspect
                  cider.nrepl.middleware.macroexpand/wrap-macroexpand
                  cider.nrepl.middleware.ns/wrap-ns
                  cider.nrepl.middleware.resource/wrap-resource
                  cider.nrepl.middleware.stacktrace/wrap-stacktrace
                  cider.nrepl.middleware.test/wrap-test
                  cider.nrepl.middleware.trace/wrap-trace
                  cider.nrepl.middleware.undef/wrap-undef]})
;; Note that Midje itself is in the `dev` profile to support
;; running autotest in the repl.
