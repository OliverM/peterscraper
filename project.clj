(defproject peterscraper "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [enlive "1.1.5"]
                 [aprint "0.1.1"]
                 [clj-http "1.0.1"]
                 [aprint "0.1.1"]
                 ]
  :main ^:skip-aot peterscraper.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
