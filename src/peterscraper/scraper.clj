(ns peterscraper.scraper
  (:require [peterscraper.ids :as i]
            [net.cgrand.enlive-html :as html]
            [clj-http.client :as client]
            [aprint.core :refer :all]))

(def post-params {:simostrar       "no"
                  :codaut          "00"
                  :tipoOperacion   nil
                  :codprov         "00"
                  :codcen          "04000021"
                  :codcen2         "04000021"
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

(defn get-centre-html
  "Returns the webpage of the centre with the supplied ID"
  [id]
  (:body (client/post "https://www.educacion.gob.es/centros/saccen.do"
                      {:insecure?   true
                       :form-params (merge post-params
                                           {:codecen  id
                                            :codecen2 id})})))

(defn get-centre-info
  "Parses a centre's webpage to extract the desired fields"
  [centre-html]
  (let [f (comp second :content)
        li (-> (html/html-snippet centre-html)
               (html/select [:li]))
        li (filter f li)
        captions (apply concat (map (comp :content first :content) li))
        values (map f li)]
    (zipmap captions values)))

