(ns urlshortener.core
  (:use
     [ring.adapter.jetty :only (run-jetty)]
     [urlshortener.routes :only (app)]
   )
)


(defn -main [& args]
  (run-jetty #'app {:port 8080 :join? false})
)
