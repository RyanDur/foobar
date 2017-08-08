(ns foobar.services.service-test
  (:require [foobar.services.service :as sut]
            [midje.sweet :refer :all]
            [foobar.services.client :as client]))

(facts "Service test"

       (fact "should be able to take a request with a name and return a description"
             (sut/describe {:body {:name "Ryan"}}) => {:name "Ryan" :desc "Hello Ryan"}
             (provided (client/post "Ryan") => {:name "Ryan" :desc "Hello Ryan"}))

       (fact "should have a sensible default if an empty request is passed in"
             (sut/describe {}) => {:name "John Doe" :desc "Hello John Doe"}
             (provided (client/post "John Doe") => {:name "John Doe" :desc "Hello John Doe"})))
