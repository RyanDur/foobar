(ns foobar.helpers
  (:require
   [cheshire.core :as cheshire]
   [clj-wiremock.core :refer :all]
   [midje.sweet :as midje]))

(defn to-map
  "parse body from json string to Map"
  [body]
  (cheshire/parse-string body true))

(defn to-json
  "parse Map to json string"
  [body]
  (cheshire/generate-string body))
