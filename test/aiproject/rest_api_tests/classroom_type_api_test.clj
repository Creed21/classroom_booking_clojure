(ns aiproject.rest_api_tests.classroom_type_api_test
  (:require [aiproject.core :refer :all]
            [cheshire.core :as json]
            [clojure.test :refer :all]
            [compojure.core :refer [DELETE GET POST PUT]]
            :use
            [midje.sweet]))




(midje.sweet/facts "GET /api/classroomTypes"
                   (.fact "Insert classroomType 1"
                      (let [response (POST "http://localhost:4003/api/classroomTypes" [{:id 1
                                                                                   :dsc "Classroom Type"
                                                                                   }])]
                       (json/parse-string (:body response) true) => {:id 1
                                                                     :dsc "Classroom Type"
                                                                     }
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                       )
                   )

                   (.fact "Insert classroomType 2"
                     (let [response (POST "http://localhost:4003/api/classroomTypes" [{:id 2
                                                                                   :name "Meeting Room"
                                                                                   }])]
                       (json/parse-string (:body response) true) => {:id 2
                                                                     :name "Meeting Room"
                                                                     }
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                  )

                   (.fact "find classroomType 1"
                     (let [response (GET "http://localhost:4003/api/classroomTypes/filtered" {:dsc "Classroom Type"})]
                       (json/parse-string (:body response) true) => {:id 1
                                                                     :dsc "Classroom Type"
                                                                     }
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"})
                  )

                   (.fact "find classroomType 2"
                   (let [response (GET "http://localhost:4003/api/classroomTypes/filtered" {:dsc "Meeting Room"})]
                     (json/parse-string (:body response) true) => {:id 2
                                                                   :name "Meeting Room"
                                                                   }
                     (:status response) => 200
                     (:headers response) => {"Content-Type" "application/json"})
                  )

)

(midje.sweet/facts "Test read classroom with conditions data"
                   (.fact "find classroomType 1"
                     (let [response (GET "http://localhost:4003/api/classroomTypes/filtered" {:dsc "Classroom Type"})]
                       (json/parse-string (:body response) true) => {:id 1
                                                                     :dsc "Classroom Type"
                                                                     }
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"})
                  )
)


(midje.sweet/facts "Test Update classroom"
                   (.fact "insert classroomType for update"
                     (let [response (POST "http://localhost:4003/api/classroomTypes" {:id 100
                                                                                  :dsc "cls_room_type_to_update"} )]
                       (json/parse-string (:body response) true) => {:id 100
                                                                     :dsc "cls_room_type_to_update"
                                                                     }
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                  )

                   (.fact "update inserted classroomType for update"
                     (let [response (PUT "http://localhost:4003/api/classroomTypes" [{:id 100}
                                                                                 {:dsc "Classroom UPDATED"}])]
                       (json/parse-string (:body response) true)
                       (:status response) => (or 200 204)
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                  )

                   (.fact "find updated classroomType for update"
                     (let [response (GET "http://localhost:4003/api/classroomTypes/filtered" {:dsc "Classroom UPDATED"})]
                       (json/parse-string (:body response) true) => {:id 100
                                                                     :dsc "Classroom UPDATED"
                                                                     }
                       (:status response) => (or 200 202)
                       (:headers response) => {"Content-Type" "application/json"})
                  )

)


(midje.sweet/facts "Test Delete classroom"
                   (.fact "insert classroomType for delete"
                     (let [response (POST "http://localhost:4003/api/classroomTypes" [{:id 500
                                                                                   :dsc "Classroom Type for delete"
                                                                                   }])]
                       (json/parse-string (:body response) true) => {:id 500
                                                                     :dsc "Classroom Type for delete"
                                                                     }
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                  )

                   (.fact "delete classroomType for delete"
                     (let [response (DELETE "http://localhost:4003/api/classroomTypes/filtered" {:id 500})]
                       (json/parse-string (:body response) true)
                       (:status response) => (or 200 204)
                       (:headers response) => {"Content-Type" "application/json"})
                  )
)
