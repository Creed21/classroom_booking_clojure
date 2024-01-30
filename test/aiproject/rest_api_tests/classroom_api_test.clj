(ns aiproject.rest_api_tests.classroom_api_test
  (:require [aiproject.core :refer :all]
            [cheshire.core :as json]
            [clojure.test :refer :all]
            [compojure.core :refer [DELETE GET POST PUT]]
            :use [midje.sweet]))

(def expected-classrooms
  [{:id 100
    :dsc "Classroom 100"
    :peopleCapacity 30
    :hasComputers true
    :computerCapacity 20
    :classRoom_type nil
    },
   {:id 101
    :dsc "Classroom 101"
    :capacity 30
    :computerCapacity 20
    :classRoom_type nil
    }] )



(midje.sweet/facts "GET /api/classRooms"
                   (.fact "insert classroomType for classroom"
                     (let [response (POST "http://localhost:4003/api/classroomTypes" [{:id 100
                                                                                      :dsc "Classroom"
                                                                                      }])]
                       (json/parse-string (:body response) true)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                       )
                   )

                   (.fact "insert classroom 100"
                     (let [response (POST "http://localhost:4003/api/classRooms" [{:id 100
                                                                                   :dsc "Classroom 100"
                                                                                   :peopleCapacity 30
                                                                                   :hasComputers true
                                                                                   :computerCapacity 20
                                                                                   :classRoom_type 100
                                                                                   }])]
                       (json/parse-string (:body response) true) => (first expected-classrooms)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                       )
                   )

                   (.fact "insert classroom 101"
                     (let [response (POST "http://localhost:4003/api/classRooms" [{:id 101
                                                                                   :dsc "Classroom 101"
                                                                                   :capacity 30
                                                                                   :computerCapacity 20
                                                                                   :classRoom_type 100
                                                                                   }])]
                       (json/parse-string (:body response) true) => (first expected-classrooms)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "find classroom 100"
                     (let [response (GET "http://localhost:4003/api/classRooms/filtered" {:dsc "Classroom 100"})]
                       (json/parse-string (:body response) true) => (first expected-classrooms)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"})
                   )

                   (.fact "find classroom 101"
                     (let [response (GET "http://localhost:4003/api/classRooms/filtered" {:dsc "Classroom 101"})]
                       (json/parse-string (:body response) true) => (second expected-classrooms)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"})
                   )
)

(midje.sweet/facts "Test read classroom with conditions data"
                   (.fact "find classroom 100"
                     (let [response (GET "http://localhost:4003/api/classRooms/filtered" {:dsc "Classroom 100"})]
                       (json/parse-string (:body response) true) => (first expected-classrooms)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"})
                  )
)


(midje.sweet/facts "Test Update classroom"
                   (.fact "insert classroom 200 for update"
                     (let [response (POST "http://localhost:4003/api/classRooms" [{:id 200
                                                                                   :dsc "Classroom 200"
                                                                                   :hasComputers false
                                                                                   :computerCapacity 20
                                                                                   :classRoom_type nil
                                                                                   }])]
                       (json/parse-string (:body response) true) => {:id 200
                                                                     :dsc "Classroom 200"
                                                                     :peopleCapacity nil
                                                                     :hasComputers false
                                                                     :computerCapacity 20
                                                                     :classRoom_type nil
                                                                     }
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "update classroom 200"
                     (let [response (PUT "http://localhost:4003/api/classRooms" [{:id 200}
                                                                                 {:dsc "Classroom UPDATED"}])]
                       (json/parse-string (:body response) true)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "find updated classroom 200"
                     (let [response (GET "http://localhost:4003/api/classRooms/filtered" {:dsc "Classroom UPDATED"})]
                       (json/parse-string (:body response) true) => {:id 200
                                                                     :dsc "Classroom 200"
                                                                     :peopleCapacity nil
                                                                     :hasComputers false
                                                                     :computerCapacity 20
                                                                     :classRoom_type nil}
                       (:status response) => (or 200 202)
                       (:headers response) => {"Content-Type" "application/json"})
                   )

)


(midje.sweet/facts "Test Delete classroom"
                   (.fact "insert classroom 300 for delete"
                     (let [response (POST "http://localhost:4003/api/classRooms" [{:id 300
                                                                                   :dsc "Classroom 300"
                                                                                   :hasComputers false
                                                                                   :computerCapacity 20
                                                                                   :classRoom_type nil
                                                                                   }])]
                       (json/parse-string (:body response) true) => {:id 300
                                                                     :dsc "Classroom 300"
                                                                     :peopleCapacity nil
                                                                     :hasComputers false
                                                                     :computerCapacity 20
                                                                     :classRoom_type nil
                                                                     }
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "delete classroom 300"
                     (let [response (DELETE "http://localhost:4003/api/classRooms/filtered" {:id 300})]
                       (json/parse-string (:body response) true)
                       (:status response) => (or 200 204)
                       (:headers response) => {"Content-Type" "application/json"})
                  )
)
