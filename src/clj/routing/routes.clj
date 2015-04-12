(ns routing.routes
  (:require [ring.util.response :refer [file-response]]
            [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer [defroutes GET PUT DELETE POST]]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [clojure.tools.logging :as log]
            [database.connect :as db]))

(defn index []
  (file-response "public/html/index.html" {:root "resources"}))

(defn generate-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (pr-str data)})

(defroutes routes
  (GET "/" [] (index))
  (route/files "/" {:root "resources/public"}))

(def app
  (-> routes))

(defonce server
  (run-jetty #'app {:port 8080 :join? false}))
