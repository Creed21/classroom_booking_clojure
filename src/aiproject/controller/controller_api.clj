(ns aiproject.controller.controller_api
  (:require
    [clojure.java.io]
    [aiproject.model.classroom :as classroom]
    [aiproject.model.classroom_type :as classroom_type]
    [aiproject.model.user_app :as user_app]
    [aiproject.model.reservation :as reservation]
    [aiproject.model.reservation_type :as reservation_type]
    [aiproject.model.reservation_status :as reservation_status]
    ))

; classroom
(defn all-classrooms []
  (classroom/read-data ))
(defn new-classroom [data]
  ( (classroom/insert-data data )))
(defn update-classroom [id data]
  ((classroom/update-data id data )))
(defn classroom-filtered [condition]
  ((classroom/read-data-with-conditions condition )))
(defn delete-classroom [id]
  ( (classroom/delete-data id )))

; user
(defn get-user [username]
  ((user_app/find-user-by-username username )))
(defn get-user-filtered [condition]
  (user_app/read-data-with-conditions condition))
(defn new-user [data]
  ( (user_app/insert-data data )))
(defn update-user [username data]
  ( (user_app/update-data username data )))
(defn delete-user [username]
  ((user_app/delete-data username )))

; reservation
(defn all-reservations []
  ( (reservation/read-data )))
(defn reservations-filtered [condition]
  ( (reservation/read-data-with-conditions condition )))
(defn new-reservation [data]
  ( (reservation/insert-data data )))
(defn update-reservations [id data]
  ( (reservation/update-data id data )))
(defn delete-reservations [id]
  ((reservation/delete-data id )))

; reservation_status
(defn all-reservation_status []
  ((reservation_status/read-data )))
(defn new-reservation_status [data]
  ( (reservation_status/insert-data data )))
(defn update-reservation_status [id data]
  ((reservation_status/update-data id data )))
(defn delete-reservation_status [id]
  ( (reservation_status/delete-data id )))

; reservation_type
(defn all-reservation_type []
  ((reservation_type/read-data )))
(defn new-reservation_type [data]
  ((reservation_type/insert-data data )))
(defn update-reservation_type [id data]
  ((reservation_type/update-data id data )))
(defn delete-reservation_type [id]
  ( (reservation_type/delete-data id )))

; classroom_type
(defn all-classroom_type []
  ( (classroom_type/read-data )))
(defn all-classroom_type_filtered [conditions]
  ( (classroom_type/read-data-with-conditions conditions )))
(defn new-classroom_type [data]
  ( (classroom_type/insert-data data )))
(defn update-classroom_type [id data]
  ((classroom_type/update-data id data )))
(defn delete-classroom_type [id]
  ((classroom_type/delete-data id )))






