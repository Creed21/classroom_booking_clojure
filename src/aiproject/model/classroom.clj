(ns aiproject.model.classroom
  (:require [clojure.java.jdbc :as jdbc]
            [aiproject.dbConfig.db :as db]))

(defn read-data []
  (jdbc/with-db-connection [conn db/db-spec]
                           (jdbc/query conn
                                       ["SELECT * FROM classroom_booking.classroom"])))

(defn insert-data [data]
  (jdbc/insert! db/db-spec
                :classroom_booking.classroom
                data))

(defn update-data [id data]
  (jdbc/update! db/db-spec
                :classroom_booking.classroom
                data
                ["id = ?" id ]))

(defn delete-data [id]
  (jdbc/delete! db/db-spec
                :classroom_booking.classroom
                ["id = ?" id ]))