(ns aiproject.integration_tests.classroom_test
  (:require [clojure.test :refer :all]
            [aiproject.core :refer :all]
            [aiproject.model.classroom :refer :all :as classroom]
            :use [midje.sweet]  ))

(midje.sweet/facts "Test inserting classroom data"
                   (.fact "insert classroom 1"
                     (classroom/insert-data {:id 1
                                             :dsc "Classroom A"
                                             :peopleCapacity 30
                                             :hasComputers true
                                             :computerCapacity 20
                                             :classRoom_type nil}) => true
                     )
)

(midje.sweet/facts "Test read classroom with conditions data"
                   (.fact "insert classroom 2"
                     (classroom/insert-data {:id 2
                                             :dsc "109"
                                             :peopleCapacity 30
                                             :hasComputers true
                                             :computerCapacity 20
                                             :classRoom_type nil}) => true
                   )

                   (.fact "find inserted classroom with conditions dsc and people capacity"
                     (classroom/read-data-with-conditions {:dsc "109"
                                                         :peopleCapacity 30
                                                         })
                     => (.contains {:id 2
                                   :dsc "109"
                                   :peopleCapacity 30
                                   :hasComputers true
                                   :computerCapacity 20
                                   :classRoom_type nil})
                   )
)


(midje.sweet/facts "Test Find classroom"
                   (.fact "check that classroom table has rows after inserting"
                     (let [result (classroom/read-data)]
                       result => ( (seq result)))
                   ) => true
)


(midje.sweet/facts "Test Delete classroom"
                   (.fact "delete classroom 1"
                     (classroom/delete-data 1 ) => true
                     )
)