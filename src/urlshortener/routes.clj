(ns urlshortener.routes
  (:use
     [compojure.core :only (GET PUT POST defroutes)]
     [urlshortener.model :only (shorten! url-for mappings)]
   )
  (:require (compojure handler route) [ring.util.response :as response])
  )



(defn retain
  [& [url id :as args]]
  (if-let [id (apply shorten! args)]
    {:status 201
     :headers {"Location" id}
     :body (list "URL " url " assigned the short identifier " id)}
    {:status 409 :body (format "Short URL %s is already taken" id)}))

(defn redirect [id]
  (if-let [url (url-for id)]
    (response/redirect url)
    {:status 404 :body (str "No such short URL: " id)}))

(defroutes app*
  (GET "/" request "Welcome!")
  (PUT "/:id" [id url] (retain url id))
  (POST "/" [url] (if (empty? url)
                    {:status 400 :body "No `url` parameter provided"}
                    (retain url)))
  (GET "/:id" [id] (redirect id))
  (GET "/list/" [] (interpose "\n" (keys @mappings)))
  (compojure.route/not-found "Sorry, there's nothing here.")
)

(def app (compojure.handler/api app*))
