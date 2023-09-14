(ns aiproject.classroom_test
  (:require [clojure.test :refer :all]
            [aiproject.core :refer :all]
            [aiproject.model.classroom :refer :all :as classroom]
            :use [midje.sweet]  ))

(midje.sweet/facts "Test inserting classroom data"
                   (classroom/insert-data {:id 1
                                           :dsc "Classroom A"
                                           :peopleCapacity 30
                                           :hasComputers true
                                           :computerCapacity 20
                                           :classRoom_type 1}) => true


                   )

(midje.sweet/facts "Test Find classroom"
                   (let [result (classroom/read-data)]
                     result => ( (seq result)))
                   ) => true


(midje.sweet/facts "Test Delete classroom"
                   (classroom/delete-data 1 ) => true
                   )