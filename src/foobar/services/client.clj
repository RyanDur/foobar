(ns foobar.services.client
  (:require [clj-http.client :as client]
            [cheshire.core :as cheshire]))


(defn parse [body]
  (cheshire/parse-string body true))

(defn post
  ""
  [name]
  (let [response (client/post "http://localhost:8080/describe/me" {:body name})]
    (parse (:body response))))
