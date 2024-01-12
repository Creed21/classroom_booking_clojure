(ns aiproject.integration_tests.classroom_type_test
  (:require [clojure.test :refer :all]
            [aiproject.core :refer :all]
            [aiproject.model.classroom_type :refer :all :as classroom_type]
            :use [midje.sweet]  ))

(midje.sweet/facts "Test inserting classroom_type data"
                   (classroom_type/insert-data {:id 1 :dsc "type-1"}) => true

                   (classroom_type/insert-data {:id 2 :dsc "type-2"}) => true

                   )

(midje.sweet/facts "Test Find classroom_type"
                   (let [result (classroom_type/read-data)]
                     result => ( (seq result)))
                   ) => true


(midje.sweet/facts "Test Update classroom_type"
                   (classroom_type/update-data 2 { :dsc "123"}) => {:id 2 :dsc "type-2"}

                   )

(midje.sweet/facts "Test Delete user"
                   (classroom_type/delete-data 2 ) => true
                   )