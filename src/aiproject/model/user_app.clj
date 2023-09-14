(ns aiproject.model.user_app
  (:require [clojure.java.jdbc :as jdbc]
            [aiproject.dbConfig.db :as db]))

(defn read-data []
  (jdbc/with-db-connection [conn db/db-spec]
                           (jdbc/query conn
                                       ["SELECT * FROM classroom_booking.user_app"])))

(defn process-data [data]
  (doseq [row data]
    (println (str "user: :first_name: " (:first_name row) ", :last_name: " (:last_name row) ", :email: " (:email row) )
             ", telephone: " (:telephone row) ", role: " (:role row)
             )))

(defn find-user-by-username [username]
  (jdbc/query db/db-spec
              ["SELECT * FROM user_table WHERE username = ?" username]))

(defn insert-data [data]
  (jdbc/insert! db/db-spec
                :classroom_booking.user_app
                data))

(defn update-data [username data]
  (jdbc/update! db/db-spec
                :classroom_booking.user_app
                data
                ["username = ?" username ]))

(defn delete-data [username]
  (jdbc/delete! db/db-spec
                :classroom_booking.user_app
                ["username = ?" username ]))