(ns aiproject.analytics.analytics
  (:require
    [aiproject.dbConfig.db :as db]
    [clojure.java.jdbc :as jdbc]))


(defn calculate-classroom-utilization []
  (let [query "SELECT classroom_type, COUNT(*) AS count
               FROM classroom_booking.reservation
               GROUP BY classroom_type"]
    (jdbc/query db/db-spec query)))

(defn favorite-classroom-types []
  (let [query "SELECT classroom_type, COUNT(*) AS count
               FROM classroom_booking.reservation
               GROUP BY classroom_type
               ORDER BY count DESC"]
    (jdbc/query db/db-spec query)))

(defn favorite-reservation-types []
  (let [query "SELECT reservation_type, COUNT(*) AS count
               FROM classroom_booking.reservation
               GROUP BY reservation_type
               ORDER BY count DESC"]
    (jdbc/query db/db-spec query)))

(defn successful-reservation-percentage []
  (let [total (jdbc/query db/db-spec "SELECT COUNT(*) FROM classroom_booking.reservation")
        successful (jdbc/query db/db-spec "SELECT COUNT(*) FROM classroom_booking.reservation WHERE status_id = 'successful'")]
    (/ (* 100 (get (first successful) :count))
       (get (first total) :count))))

(defn failed-reservation-percentage []
  (let [total (jdbc/query db/db-spec "SELECT COUNT(*) FROM classroom_booking.reservation")
        successful (jdbc/query db/db-spec "SELECT COUNT(*) FROM classroom_booking.reservation WHERE status_id = 'fail'")]
    (/ (* 100 (get (first successful) :count))
       (get (first total) :count))))

(defn users-ordered-by-reservations []
  (let [query "SELECT user_app.username, user_app.first_name, user_app.last_name, COUNT(reservation.id) AS reservation_count
               FROM classroom_booking.user_app
               LEFT JOIN classroom_booking.reservation ON user_app.username = reservation.reservation_for_user
               GROUP BY user_app.username, user_app.first_name, user_app.last_name
               ORDER BY reservation_count DESC"]
    (jdbc/query db/db-spec query)))
