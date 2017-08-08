(ns foobar.core
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]
            [foobar.services.service :as service]))

(defroutes app-routes
  (GET "/bop" [] {:body {:hello "world"}})

  (POST "/" request
        {:status 200 :body (service/describe request)})

  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-body {:keywords? true})
      middleware/wrap-json-response))
