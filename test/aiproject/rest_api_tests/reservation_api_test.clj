(ns aiproject.rest_api_tests.reservation_api_test
  (:require [clojure.test :refer :all]
            [cheshire.core :as json]
            [clojure.test :refer :all]
            [compojure.core :refer [DELETE GET POST PUT]]
            :use [midje.sweet])
  (:import (java.sql Timestamp)))

(midje.sweet/facts "Test inserting reservation data"
                   (.fact "Insert classroom type for classroom"
                     (let [response (POST "http://localhost:4003/api/classroomTypes" [{:id 1
                                                                                  :dsc "Classroom Type"
                                                                                  }])]
                     (json/parse-string (:body response) true)
                     (:status response) => 200
                     (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "Insert classroom for the reservation"
                     (let [response (POST "http://localhost:4003/api/classRooms" [{:id 100
                                                                                    :dsc "Classroom 100"
                                                                                    :peopleCapacity 30
                                                                                    :hasComputers true
                                                                                    :computerCapacity 20
                                                                                    :classRoom_type 1
                                                                                    }])]
                       (json/parse-string (:body response) true)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "insert user for the reservation"
                      (let [response (POST "http://localhost:4003/api/user_app" [{:first_name "user123" :last_name "user123"
                                                                                  :email "user123@yahoo.com"
                                                                                  :telephone "060/59-11-xxx"
                                                                                  :username "user123"
                                                                                  :pass "1"
                                                                                  :active true
                                                                                  :role_id "A"}])]
                        (json/parse-string (:body response) true)
                        (:status response) => 200
                        (:headers response) => {"Content-Type" "application/json"}
                      )
                   )


                   (.fact "insert reservation"
                     (let [response (POST "http://localhost:4003/api/reservation" [{:id 500
                                                                                    :classroom 500
                                                                                    :dsc "Classroom 500"
                                                                                    :reservation_type 1
                                                                                    :beginning_asked (Timestamp. (System/currentTimeMillis))
                                                                                    :end_asked (Timestamp. (+ (System/currentTimeMillis) 3600000)) ; One hour later
                                                                                    :reservation_for_user "user123"
                                                                                    :status_id 1
                                                                                    :status_changed_by "user123"
                                                                                    :beginning_approved (Timestamp. (+ (System/currentTimeMillis) 7200000)) ; Two hours later
                                                                                    :end_approved (Timestamp. (+ (System/currentTimeMillis) 10800000))}])]
                       (json/parse-string (:body response) true)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "find reservation"
                    (let [response (GET "http://localhost:4003/api/reservations/filtered" [{:id 500
                                                                                :dsc "Classroom 500"}])]
                       (json/parse-string (:body response) true) => {:id 500
                                                                     :classroom 500
                                                                     :dsc "Classroom 500"
                                                                     :reservation_type 1
                                                                     :reservation_for_user "user123"
                                                                     :status_id 1
                                                                     :status_changed_by "user123"
                                                                     }
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

)

(midje.sweet/facts "Test Find reservation"
                   (.fact
                     (let [response (POST "http://localhost:4003/api/reservations/filtered" [{:id 500
                                                                                 :dsc "Classroom 500"}])]
                       (json/parse-string (:body response) true) => {:id 500
                                                                     :classroom 500
                                                                     :dsc "Classroom 500"
                                                                     :reservation_type 1
                                                                     :reservation_for_user "user123"
                                                                     :status_id 1
                                                                     :status_changed_by "user123"}
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                       )
                     )
)


(midje.sweet/facts "Test updating reservation data"
                   (.fact "Insert classroom type for classroom"
                          (let [response (POST "http://localhost:4003/api/classroomTypes" [{:id 44
                                                                                            :dsc "Office"
                                                                                            }])]
                            (json/parse-string (:body response) true)
                            (:status response) => 200
                            (:headers response) => {"Content-Type" "application/json"}
                            )
                          )

                   (.fact "Insert classroom for the reservation"
                          (let [response (POST "http://localhost:4003/api/classRooms" [{:id 44
                                                                                        :dsc "Classroom 44"
                                                                                        :peopleCapacity 30
                                                                                        :hasComputers true
                                                                                        :computerCapacity 20
                                                                                        :classRoom_type 44
                                                                                        }])]
                            (json/parse-string (:body response) true)
                            (:status response) => 200
                            (:headers response) => {"Content-Type" "application/json"}
                            )
                          )

                   (.fact "insert user for the reservation"
                          (let [response (POST "http://localhost:4003/api/user_app" [{:first_name "reserv_update" :last_name "reserv_update"
                                                                                      :email "reserv_update@yahoo.com"
                                                                                      :telephone "060/59-11-xxx"
                                                                                      :username "reserv_update"
                                                                                      :pass "1"
                                                                                      :active true
                                                                                      :role_id "A"}])]
                            (json/parse-string (:body response) true)
                            (:status response) => 200
                            (:headers response) => {"Content-Type" "application/json"}
                            )
                          )


                   (.fact "insert reservation"
                          (let [response (POST "http://localhost:4003/api/reservation" [{:id 400
                                                                                         :classroom 44
                                                                                         :dsc "Classroom 44"
                                                                                         :reservation_type 1
                                                                                         :beginning_asked (Timestamp. (System/currentTimeMillis))
                                                                                         :end_asked (Timestamp. (+ (System/currentTimeMillis) 3600000)) ; One hour later
                                                                                         :reservation_for_user "reserv_update"
                                                                                         :status_id 1
                                                                                         :status_changed_by "reserv_update"
                                                                                         :beginning_approved (Timestamp. (+ (System/currentTimeMillis) 7200000)) ; Two hours later
                                                                                         :end_approved (Timestamp. (+ (System/currentTimeMillis) 10800000))}])]
                            (json/parse-string (:body response) true)
                            (:status response) => 200
                            (:headers response) => {"Content-Type" "application/json"}
                            )
                          )

                   (.fact "update reservation"
                          (let [response (PUT "http://localhost:4003/api/reservation" [{:id 400 }
                                                                                       { :classroom 44
                                                                                         :dsc "RESERVATION DSC UPDATED"
                                                                                         }])]
                            (json/parse-string (:body response) true)
                            (:status response) => (or 200 202)
                            (:headers response) => {"Content-Type" "application/json"}
                            )
                    )
                   (.fact "find updated reservation"
                          (let [response (PUT "http://localhost:4003/api/reservation" [{:id 400 }
                                                                                       { :classroom 44
                                                                                        :dsc "RESERVATION DSC UPDATED"
                                                                                        }])]
                            (json/parse-string (:body response) true) => {:id 400
                                                                          :classroom 44
                                                                          :dsc "Classroom 44"
                                                                          :reservation_type 1
                                                                          :reservation_for_user "reserv_update"
                                                                          :status_id 1
                                                                          :status_changed_by "reserv_update"
                                                                          }
                            (:status response) => 200
                            (:headers response) => {"Content-Type" "application/json"}
                            )
                          )

                   )

(midje.sweet/facts "Test Delete reservation"
                   (.fact "Insert classroom type for classroom"
                          (let [response (POST "http://localhost:4003/api/classroomTypes" [{:id 99
                                                                                            :dsc "Classroom Type"
                                                                                            }])]
                            (json/parse-string (:body response) true)
                            (:status response) => 200
                            (:headers response) => {"Content-Type" "application/json"}
                            )
                          )

                   (.fact "Insert classroom for the reservation"
                          (let [response (POST "http://localhost:4003/api/classRooms" [{:id 99
                                                                                        :dsc "Classroom 99"
                                                                                        :peopleCapacity 30
                                                                                        :hasComputers true
                                                                                        :computerCapacity 20
                                                                                        :classRoom_type 99
                                                                                        }])]
                            (json/parse-string (:body response) true)
                            (:status response) => 200
                            (:headers response) => {"Content-Type" "application/json"}
                            )
                          )

                   (.fact "insert user for the reservation"
                          (let [response (POST "http://localhost:4003/api/user_app" [{:first_name "reserv_delete" :last_name "reserv_delete"
                                                                                      :email "reserv_delete@yahoo.com"
                                                                                      :telephone "060/59-11-xxx"
                                                                                      :username "reserv_delete"
                                                                                      :pass "1"
                                                                                      :active true
                                                                                      :role_id "A"}])]
                            (json/parse-string (:body response) true)
                            (:status response) => 200
                            (:headers response) => {"Content-Type" "application/json"}
                            )
                          )


                   (.fact "insert reservation"
                          (let [response (POST "http://localhost:4003/api/reservation" [{:id 500
                                                                                         :classroom 99
                                                                                         :dsc "Classroom 99"
                                                                                         :reservation_type 1
                                                                                         :beginning_asked (Timestamp. (System/currentTimeMillis))
                                                                                         :end_asked (Timestamp. (+ (System/currentTimeMillis) 3600000)) ; One hour later
                                                                                         :reservation_for_user "reserv_delete"
                                                                                         :status_id 1
                                                                                         :status_changed_by "reserv_delete"
                                                                                         :beginning_approved (Timestamp. (+ (System/currentTimeMillis) 7200000)) ; Two hours later
                                                                                         :end_approved (Timestamp. (+ (System/currentTimeMillis) 10800000))}])]
                            (json/parse-string (:body response) true)
                            (:status response) => 200
                            (:headers response) => {"Content-Type" "application/json"}
                            )
                          )

                   (.fact "delete reservation"
                     (let [response (DELETE "http://localhost:4003/api/user_app/reservations"
                                            {:id 500})]
                       (json/parse-string (:body response) true)
                       (:status response) => (or 200 204)
                       (:headers response) => {"Content-Type" "application/json"})
                     )
                   )