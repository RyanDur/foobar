(ns foobar.mock-server
  (:require
   [foobar.helpers :refer :all]
   [clj-wiremock.core :as wiremock]
   [midje.sweet :as midje]))

(def mock-server (wiremock/server))
(def start (fn [] (wiremock/start mock-server)))
(def stop (fn [] (wiremock/stop mock-server)))
(def reset (fn [] (wiremock/reset mock-server)))

(defn stub-post
  "stub a post to the '/describe/me' endpoint with a status of 'OK''"
  [& {:keys [to with code] :or {code 200}}]
  (wiremock/stub {:request {:method "POST" :url to}
                  :response {:status code :body (to-json with)}}))
