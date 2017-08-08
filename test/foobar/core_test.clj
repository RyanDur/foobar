(ns foobar.core-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [foobar.mock-server :as mock-server]
            [foobar.helpers :as help]
            [foobar.core :refer :all]))

(facts "Component api tests"
       (def expected {:name "World" :desc "Hello World"})
       (def expected-default {:name "John Doe" :desc "Hello John Doe"})
       (def describe-me-path "/describe/me")

       (background
        (before :contents (mock-server/start))
        (after :contents (mock-server/stop))
        (before :facts (mock-server/reset)))

       (fact "A POST request to '/' with a name will return a name and a description"
             (mock-server/stub-post :to describe-me-path :with expected)
             (let [response (app (-> (mock/request :post "/")
                                     (mock/content-type "application/json")
                                     (mock/body (help/to-json {:name "World"}))))]
               (:status response) => 200
               (help/to-map (:body response))  => expected))

       (fact "A POST request to '/' without a name will return a name and a description with
              the default"
             (mock-server/stub-post :to describe-me-path :with expected-default)
             (let [response (app (-> (mock/request :post "/")))]
               (:status response) => 200
               (help/to-map (:body response))  => expected-default)))
