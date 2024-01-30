(ns aiproject.integration_tests.reservation_test
  (:require [clojure.test :refer :all]
            [aiproject.core :refer :all]
            [aiproject.model.reservation :refer :all :as reservation]
            [aiproject.model.reservation_type :refer :all :as reservation_type]
            [aiproject.model.user_app :refer :all :as user_app]
            :use [midje.sweet])
  (:import (java.sql Timestamp)))

(midje.sweet/facts "Test inserting reservation data"
                   (.fact "insert reservation type for reservation"
                     (reservation_type/insert-data {:id 1
                                                    :dsc "Meeting"
                                                    }) => true
                   )

                   (.fact "insert user for reservation"
                     (user_app/insert-data {:first_name "user123" :last_name "user123"
                                            :email "user123@yahoo.com"
                                            :telephone "060/59-11-xxx"
                                            :username "user123"
                                            :pass "1"
                                            :active true
                                            :role_id "A"}) => true
                  )

                   (.fact "insert reservation for user123"
                    (reservation/insert-data {:id 1
                                             :classroom 1
                                             :dsc "Meeting Room 1"
                                             :reservation_type 1
                                             :beginning_asked (Timestamp. (System/currentTimeMillis))
                                             :end_asked (Timestamp. (+ (System/currentTimeMillis) 3600000)) ; One hour later
                                             :reservation_for_user "user123"
                                             :status_id 1
                                             :status_changed_by "user123"
                                             :beginning_approved (Timestamp. (+ (System/currentTimeMillis) 7200000)) ; Two hours later
                                             :end_approved (Timestamp. (+ (System/currentTimeMillis) 10800000))}) ; Three hours later
                   )
)

(midje.sweet/facts "Test Find reservation"
                   (.fact "check that the reservation table has rows after inserting"
                     (let [result (reservation/read-data)]
                       result => ( not-empty (seq result)))
                     ) => true
                   )


(midje.sweet/facts "Test updating reservation data"
                   (.fact "insert reservation_type for reservation"
                          (reservation_type/insert-data {:id 2
                                                         :dsc "Class Room"
                                                         }) => true


                   (.fact "insert user for reservation"
                     (user_app/insert-data {:first_name "user123" :last_name "user123"
                                            :email "user123@yahoo.com"
                                            :telephone nil
                                            :username "user123"
                                            :pass "1"
                                            :active true
                                            :role_id "A"}) => true)

                  (.fact "insert reservation, update the same reservation
                          , and find reservation using updated value as search parameter"
                    (let [initial-data {:classroom 101
                                        :dsc "Class Room 1 - Class"
                                        :reservation_type 2
                                        :beginning_asked (Timestamp. (System/currentTimeMillis))
                                        :end_asked (Timestamp. (+ (System/currentTimeMillis) 3600000))
                                        :reservation_for_user "user123"
                                        :status_id 1
                                        :status_changed_by "user123"
                                        :beginning_approved (Timestamp. (+ (System/currentTimeMillis) 7200000))
                                        :end_approved (Timestamp. (+ (System/currentTimeMillis) 10800000))}]
                      (let [reservation-id (-> (reservation/insert-data initial-data)
                                               :generated-key
                                               :keys
                                               :id)]
                        (-> (reservation/update-data reservation-id {:dsc "Updated Meeting Room"})
                            (=>  true))
                        (-> (reservation/read-data-with-conditions {:dsc "Updated Meeting Room"})
                            (=> true))))))
)



(midje.sweet/facts "Test Delete reservation"
                   (.fact "delete reservation with id 1"
                    (reservation/delete-data 1 ) => true
                   )
)