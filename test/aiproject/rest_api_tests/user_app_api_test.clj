(ns aiproject.rest_api_tests.user_app_api_test
  (:require [aiproject.core :refer :all]
            [cheshire.core :as json]
            [clojure.test :refer :all]
            [compojure.core :refer [DELETE GET POST PUT]]
            :use [midje.sweet]))

(midje.sweet/facts "GET /api/user_app"
                   (.fact "Insert user Test1"
                     (let [response (POST "http://localhost:4003/api/user_app" [{:first_name "Test1" :last_name "user1"
                                                                                 :email "test1.user1@yahoo.com"
                                                                                 :telephone "060/59-11-xxx"
                                                                                 :username "test1.user1@yahoo.com"
                                                                                 :pass "1"
                                                                                 :active true
                                                                                 :role_id "A"}])]
                       (json/parse-string (:body response) true)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                       )
                   )

                   (.fact "Insert user Test2"
                     (let [response (POST "http://localhost:4003/api/user_app" [{:first_name "Test2" :last_name "user2"
                                                                                 :email "test2.user2@yahoo.com"
                                                                                 :telephone "060/59-22-xxx"
                                                                                 :username "test2.user2@yahoo.com"
                                                                                 :pass "1"
                                                                                 :active true
                                                                                 :role_id "A"}])]
                       (json/parse-string (:body response) true)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "find user Test1"
                     (let [response (GET "http://localhost:4003/api/user_app/filtered" {:email "test1.user1@yahoo.com"})]
                       (json/parse-string (:body response) true) => {:first_name "Test1" :last_name "user1"
                                                                     :email "test1.user1@yahoo.com"
                                                                     :telephone "060/59-11-xxx"
                                                                     :username "test1.user1@yahoo.com"
                                                                     :pass "1"
                                                                     :active true
                                                                     :role_id "A"})
                   )

                   (.fact "find user Test2"
                     (let [response (GET "http://localhost:4003/api/user_app/filtered" {:email "test2.user2@yahoo.com"})]
                       (json/parse-string (:body response) true) => {:first_name "Test2" :last_name "user2"
                                                                     :email "test2.user2@yahoo.com"
                                                                     :telephone "060/59-22-xxx"
                                                                     :username "test2.user2@yahoo.com"
                                                                     :pass "1"
                                                                     :active true
                                                                     :role_id "A"})
                   )
)

(midje.sweet/facts "Test find user filtered "
                   (.fact "find user filtered"
                     (let [response (GET "http://localhost:4003/api/user_app/filtered" {:email "test1.user1@yahoo.com"})]
                       (json/parse-string (:body response) true) => {:first_name "Test1" :last_name "user1"
                                                                     :email "test1.user1@yahoo.com"
                                                                     :telephone "060/59-11-xxx"
                                                                     :username "test1.user1@yahoo.com"
                                                                     :pass "1"
                                                                     :active true
                                                                     :role_id "A"}
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"})
                  )
)


(midje.sweet/facts "Test Update user "
                   (.fact "Insert user for update"
                     (let [response (POST "http://localhost:4003/api/user_app" [{:first_name "update" :last_name "user"
                                                                                 :email "update.user@yahoo.com"
                                                                                 :telephone "060/59-00-xxx"
                                                                                 :username "update.user@yahoo.com"
                                                                                 :pass "1"
                                                                                 :active true
                                                                                 :role_id "A"}])]
                       (json/parse-string (:body response) true)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "Update the user"
                     (let [response (PUT "http://localhost:4003/api/user_app" [{:username "update.user@yahoo.com"}
                                                                                 {:first_name "UPDATED_FirstName"}])]
                       (json/parse-string (:body response) true)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "find the updated user"
                     (let [response (GET "http://localhost:4003/api/user_app/filtered" {:first_name "UPDATED_FirstName"})]
                       (json/parse-string (:body response) true) => {:first_name "UPDATED_FirstName" :last_name "user"
                                                                     :email "update.user@yahoo.com"
                                                                     :telephone "060/59-00-xxx"
                                                                     :username "update.user@yahoo.com"
                                                                     :pass "1"
                                                                     :active true
                                                                     :role_id "A"}
                       (:status response) => (or 200 202)
                       (:headers response) => {"Content-Type" "application/json"})
                  )
)


(midje.sweet/facts "Test Delete user"
                   (.fact "Insert user for delete"
                     (let [response (POST "http://localhost:4003/api/user_app" [{:first_name "userForDeleting" :last_name nil
                                                                                 :email "user.delete@yahoo.com"
                                                                                 :telephone nil
                                                                                 :username "user.delete@yahoo.com"
                                                                                 :pass "1"
                                                                                 :active true
                                                                                 :role_id "A"}])]
                       (json/parse-string (:body response) true)
                       (:status response) => 200
                       (:headers response) => {"Content-Type" "application/json"}
                     )
                   )

                   (.fact "Delete user"
                     (let [response (DELETE "http://localhost:4003/api/user_app" {:username "user.delete@yahoo.com"})]
                       (json/parse-string (:body response) true)
                       (:status response) => (or 200 204)
                       (:headers response) => {"Content-Type" "application/json"})
                   )
)
