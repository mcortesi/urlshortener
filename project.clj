(defproject urlshortener "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [org.clojure/clojure "1.6.0"]
                 [javax.servlet/servlet-api "2.5"]
                 [ring "1.4.0-RC2"]
                 [compojure "1.3.4"]
                 ]
  :main urlshortener.core)
