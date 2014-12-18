(ns peterscraper.scraper
  (:require [net.cgrand.enlive-html :as html]
            [clj-http.client :as client]
            [aprint.core :refer :all]))

(defn slurp-url [url]
  (html/html-snippet (:body (client/get url))))

(def post-params {:simostrar       "no"
                  :codaut          "00"
                  :tipoOperacion   nil
                  :codprov         "00"
                  :codcen          "04000018"
                  :codcen2         "04000018"
                  :denomiespe      nil
                  :ssel_natur      "0"
                  :sconcerta       "0"
                  :tipocentro      "0"
                  :combosub        nil
                  :combomuni       nil
                  :comboloc        nil
                  :comboniv        "131"
                  :combogra        nil
                  :comboens        "-1"
                  :combofam        nil
                  :combopais       nil
                  :comboislas      nil
                  :comboprovin     nil
                  :nombreaut       nil
                  :nombrepro       nil
                  :modalidad       "0"
                  :textotipocentro "Todos"
                  :textosub        nil
                  :textomunicipio  nil
                  :textolocalidad  nil
                  :textonivel      "Educaci%F3n+Secundaria+Obligatoria"
                  :textogrado      nil
                  :textoensenanza  "Todos"
                  :textofamilia    "Todos"
                  :textopais       nil
                  :textonaturaleza "Todos"
                  :textoconcertado "Todos"
                  :textomodalidad  "Todas"
                  })

(defn post-params-test
  (client/post "https://www.educacion.gob.es/centros/saccen.do"
                                    {:insecure?   true
                                     :form-params post-params}))

(def test-snippet (post-params-test))

(html/select testsnippet [:li])
