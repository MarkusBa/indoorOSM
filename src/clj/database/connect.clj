(ns database.connect
  (:require [config.parse :as cf]
            [korma.core :as k]
            [korma.db :refer [defdb postgres]]))

;;(def db-spec (cf/load-props "resources/db.properties"))
(def db-spec {:db "indoor"
              :user "markus"
              :password "xxxx"} )

(defdb db (postgres db-spec))

(k/defentity item)

(defn get-items []
 (k/select item))
