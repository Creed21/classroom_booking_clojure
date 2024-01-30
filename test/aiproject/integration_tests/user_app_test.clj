(ns aiproject.integration_tests.user_app_test
  (:require [clojure.test :refer :all]
            [aiproject.core :refer :all]
            [aiproject.model.user_app :refer :all :as user_app]
            :use [midje.sweet]  ))

(midje.sweet/facts "Test inserting user data"
                   (.fact "insert user aleksandar"
                      (user_app/insert-data {:first_name "Aleksandar" :last_name "Janković"
                                    :email "aleksandar.jankovic95@yahoo.com"
                                    :telephone "060/59-xx-xxx"
                                    :username "janko_aca"
                                    :pass "1"
                                    :active true
                                    :role_id "A"}) => true
                  )

                  (.fact "insert user milan"
                     (user_app/insert-data {:first_name "Milan" :last_name "Danković"
                                            :email "milan.dank@yahoo.com"
                                            :telephone "060/59-xx-xxx"
                                            :username "milan"
                                            :pass "1"
                                            :active true
                                            :role_id "A"}) => true
                 )

)

(midje.sweet/facts "Test Find user"
                 (.fact "find user aleksandar"
                   (user_app/find-user-by-username "janko_aca") => {:first_name "Aleksandar" :last_name "Janković"
                                          :email "aleksandar.jankovic95@yahoo.com"
                                          :telephone "060/59-xx-xxx"
                                          :username "janko_aca"
                                          :pass "1"
                                          :active true
                                          :role_id "A"}
                 )

                 (.fact "find user milan"
                   (user_app/find-user-by-username "milan") => {:first_name "Milan" :last_name "Danković"
                                                                    :email "milan.dank@yahoo.com"
                                                                    :telephone "060/59-xx-xxx"
                                                                    :username "milan"
                                                                    :pass "1"
                                                                    :active true
                                                                    :role_id "A"}
                 )

)


(midje.sweet/facts "Test Update user"
                   (.fact "update user milan"
                    (user_app/update-data "milan" {:telephone "123"}) => {:first_name "Milan" :last_name "Danković"
                                                                    :email "milan.dank@yahoo.com"
                                                                    :telephone "123"
                                                                    :username "milan"
                                                                    :pass "1"
                                                                    :active true
                                                                    :role_id "A"}
                    )
                  )

(midje.sweet/facts "Test Delete user"
                   (.fact "deleting user milan"
                    (user_app/delete-data "milan" ) => true
                    ) => true
)


(midje.sweet/facts "Test find user with email"
                   (.fact "find user milan with email calling read-data-with-conditions"
                     (user_app/read-data-with-conditions  {:email "milan.dank@yahoo.com"})
                     => {:first_name "Milan" :last_name "Danković"
                         :email "milan.dank@yahoo.com"
                         :telephone "060/59-xx-xxx"
                         :username "milan"
                         :pass "1"
                         :active true
                         :role_id "A"})
                   )

(midje.sweet/facts "Test find user with first_name and active fields"
                   (.fact "find user milan with first_name and active fields"
                     (user_app/read-data-with-conditions-data {:first_name "Milan" :active false})
                     => {:first_name "Milan" :last_name "Danković"
                         :email "new.email@gmail.com"
                         :telephone "123"
                         :username "milan"

                         :pass "1"
                         :active false
                         :role_id "A"})
                   )

(midje.sweet/facts "Test find user with email and password"
                   (.fact "find user milan with email and password fields"
                     (user_app/read-data-with-conditions {:email "new.email@gmail.com" :pass "1"})
                     => {:first_name "Milan" :last_name "Danković"
                         :email "new.email@gmail.com"
                         :telephone "123"
                         :username "milan"
                         :pass "1"
                         :active false
                         :role_id "A"})
                   )
