(ns classroom-booking.reservation_test
  (:require [clojure.test :refer :all]
            [aiproject.core :refer :all]
            [aiproject.model.reservation :refer :all :as reservation]
            :use [midje.sweet]  ))

(midje.sweet/facts "Test inserting reservation data"
                   (reservation/insert-data {:id 1
                                             :classroom 101
                                             :dsc "Meeting Room 1"
                                             :reservation_type 1
                                             :beginning_asked (java.sql.Timestamp. (System/currentTimeMillis))
                                             :end_asked (java.sql.Timestamp. (+ (System/currentTimeMillis) 3600000)) ; One hour later
                                             :reservation_for_user "user123"
                                             :status_id 1
                                             :status_changed_by "admin"
                                             :beginning_approved (java.sql.Timestamp. (+ (System/currentTimeMillis) 7200000)) ; Two hours later
                                             :end_approved (java.sql.Timestamp. (+ (System/currentTimeMillis) 10800000))}) => true


                   )

(midje.sweet/facts "Test Find reservation"
                   (let [result (reservation/read-data)]
                     result => ( (seq result)))
                   ) => true


(midje.sweet/facts "Test Delete reservation"
                   (reservation/delete-data 1 ) => true
                   )