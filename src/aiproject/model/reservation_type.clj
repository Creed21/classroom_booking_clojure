(ns aiproject.model.reservation_type
  (:require [clojure.java.jdbc :as jdbc]
            [aiproject.dbConfig.db :as db]))

(defn read-data []
  (jdbc/with-db-connection [conn db/db-spec]
                           (jdbc/query conn
                                       ["SELECT * FROM classroom_booking.reservation_type"])))

(defn insert-data [data]
  (jdbc/insert! db/db-spec
                :classroom_booking.reservation_type
                data))

(defn update-data [id data]
  (jdbc/update! db/db-spec
                :classroom_booking.reservation_type
                data
                ["id = ?" id ]))

(defn delete-data [id]
  (jdbc/delete! db/db-spec
                :classroom_booking.reservation_type
                ["id = ?" id ]))