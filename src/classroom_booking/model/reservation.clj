(ns classroom_booking.model.reservation
  (:require [clojure.java.jdbc :as jdbc]
            [classroom_booking.dbConfig.db :as db]))

(defn read-data []
  (jdbc/with-db-connection [conn db/db-spec]
                           (jdbc/query conn
                                       ["SELECT * FROM classroom_booking.reservation"])))

(defn insert-data [data]
  (jdbc/insert! db/db-spec
                :classroom_booking.reservation
                data))

(defn update-data [id data]
  (jdbc/update! db/db-spec
                :classroom_booking.reservation
                data
                ["id = ?" id ]))

(defn delete-data [id]
  (jdbc/delete! db/db-spec
                :classroom_booking.reservation
                ["id = ?" id ]))