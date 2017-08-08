(ns foobar.services.client-test
  (:require [clj-http.client :as client]
            [foobar.helpers :as help]
            [foobar.services.client :as sut]
            [midje.sweet :refer :all]))

(facts "about the client service"

       (fact "post should return the contents of the body"
             (sut/post "Ryan") => {:name "Ryan"}
             (provided (client/post "http://localhost:8080/describe/me" {:body "Ryan"}) =>
                       {:body (help/to-json {:name "Ryan"})})))
