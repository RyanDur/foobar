(ns foobar.services.service
  (:require [foobar.services.client :as client]))

(defn describe
  "takes a request with a name and returns a response with
  the name and description "
  [request]
  (let [name (or (get-in request [:body :name]) "John Doe")]
    (client/post name)))
