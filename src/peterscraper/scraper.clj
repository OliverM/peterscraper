(ns peterscraper.scraper
  (:require [net.cgrand.enlive-html :as html]
            [clj-http.client :as client]
            [aprint.core :refer :all]))

(defn slurp-url [url]
  (html/html-snippet (:body (client/get url))))

