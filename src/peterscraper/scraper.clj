(ns peterscraper.scraper
  (:import (java.net URL))
  (:require [net.cgrand.enlive-html :as html]
            [clj-http.client :as client]
            [aprint.core :refer :all]))

(defn fetch-url [url]
  (html/html-resource (URL. url)))

