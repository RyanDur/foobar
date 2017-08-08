(ns foobar.services.client-test
  (:require [clj-http.client :as client]
            [foobar.helpers :as help]
            [foobar.services.client :as sut]
            [midje.sweet :refer :all]))

(facts "about the client service"
       (def thing "Ryan")
       (def expected {:name thing})

       (fact "post should return the contents of the body"
             (sut/post thing) => expected
             (provided (client/post "http://localhost:8080/describe/me" {:body thing}) =>
                       {:body (help/to-json expected)})))
