(ns aiproject.controller.controller
  (:require
    [clostache.parser :as clostache]
    [clojure.java.io]
    [aiproject.model.classroom :as classroom]
    [aiproject.model.classroom_type :as classroom_type]
    [aiproject.model.user_app :as user_app]
    [aiproject.model.reservation :as reservation]
    [aiproject.model.reservation_type :as reservation_type]
    [aiproject.model.reservation_status :as reservation_status]
    [aiproject.analytics.analytics :as analytics]
    ))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "pages/" template-name ".mustache"))))


(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn home []
  (render-template "home" {}))

; classroom
(defn all-classrooms []
  (render-template "classRooms" {:classRooms (classroom/read-data )}))

(defn new-classroom1 [data]
  (render-template "createClassRoom" {:createClassRoom (classroom/insert-data data )}))

(defn get-new-classroom []
  (render-template "createClassRoom" {:createClassRoom (classroom/read-data )}))

(defn update-classroom [id data]
  (render-template "classrooms" {:classrooms (classroom/update-data id data )}))

(defn classroom-filtered [condition]
  (render-template "reservations" {:reservations (reservation/read-data-with-conditions condition )}))

(defn delete-classroom [id]
  (render-template "classrooms" {:classrooms (classroom/delete-data id )}))

; user
(defn get-user [username]
  (render-template "user" {:user (user_app/find-user-by-username username )}))

(defn new-user [data]
  (render-template "userCreate" {:user (user_app/insert-data data )}))

(defn update-user [username data]
  (render-template "userCreate" {:user (user_app/update-data username data )}))

(defn delete-user [username]
  (render-template "user" {:user (user_app/delete-data username )}))

; reservation
(defn all-reservations []
  (render-template "reservations" {:reservations (reservation/read-data )}))

(defn reservations-filtered [condition]
  (render-template "reservations" {:reservations (reservation/read-data-with-conditions condition )}))

(defn new-reservation [data]
  (render-template "makeReservation" {:reservation (reservation/insert-data data )}))

(defn update-reservations [id data]
  (render-template "reservations" {:reservations (reservation/update-data id data )}))

(defn delete-reservations [id]
  (render-template "reservations" {:reservations (reservation/delete-data id )}))

; reservation_status
(defn all-reservation_status []
  (render-template "reservation_status" {:reservation_status (reservation_status/read-data )}))

(defn new-reservation_status [data]
  (render-template "reservation_status" {:reservation_status (reservation_status/insert-data data )}))

(defn update-reservation_status [id data]
  (render-template "reservation_status" {:reservation_status (reservation_status/update-data id data )}))

(defn delete-reservation_status [id]
  (render-template "reservation_status" {:reservation_status (reservation_status/delete-data id )}))

; reservation_type
(defn all-reservation_type []
  (render-template "reservation_status" {:reservation_type (reservation_type/read-data )}))

(defn new-reservation_type [data]
  (render-template "reservation_status" {:reservation_type (reservation_type/insert-data data )}))

(defn update-reservation_type [id data]
  (render-template "reservation_status" {:reservation_type (reservation_type/update-data id data )}))

(defn delete-reservation_type [id]
  (render-template "reservation_status" {:reservation_type (reservation_type/delete-data id )}))

; classroom_type
(defn all-classroom_type []
  (render-template ":classroom_type" {:classroom_type (classroom_type/read-data )}))

(defn new-classroom_type [data]
  (render-template ":classroom_type" {:classroom_type (classroom_type/insert-data data )}))

(defn update-classroom_type [id data]
  (render-template ":classroom_type" {:classroom_type (classroom_type/update-data id data )}))

(defn delete-classroom_type [id]
  (render-template ":classroom_type" {:classroom_type (classroom_type/delete-data id )}))


; Classroom Type Analytics
(defn classroom-type-analytics []
  (render-template "classroom_type_analytics" {:classroom_type_analytics (analytics/classroom-type-utilization)}))

; Reservation Type Analytics
(defn reservation-type-analytics []
  (render-template "reservation_type_analytics" {:reservation_type_analytics (analytics/reservation-type-favorites)}))

; Reservation Status Analytics
(defn reservation-status-analytics []
  (render-template "reservation_status_analytics" {:reservation_status_analytics (analytics/reservation-status-success-rate)}))

; User Analytics
(defn user-analytics []
  (render-template "user_analytics" {:user_analytics (analytics/users-by-reservation-count)}))




