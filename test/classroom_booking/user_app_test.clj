(ns classroom-booking.user_app_test
  (:require [clojure.test :refer :all]
            [aiproject.core :refer :all]
            [aiproject.model.user_app :refer :all :as user_app]
            :use [midje.sweet]  ))

(midje.sweet/facts "Test inserting user data"
      (user_app/insert-data {:first_name "Aleksandar" :last_name "Janković"
                    :email "aleksandar.jankovic95@yahoo.com"
                    :telephone "060/59-xx-xxx"
                    :username "janko_aca"
                    :pass "1"
                    :active true
                    :role_id "A"}) => true

     (user_app/insert-data {:first_name "Milan" :last_name "Danković"
                            :email "milan.dank@yahoo.com"
                            :telephone "060/59-xx-xxx"
                            :username "milan"
                            :pass "1"
                            :active true
                            :role_id "A"}) => true

)

(midje.sweet/facts "Test Find user"
     (user_app/find-user-by-username "janko_aca") => {:first_name "Aleksandar" :last_name "Janković"
                            :email "aleksandar.jankovic95@yahoo.com"
                            :telephone "060/59-xx-xxx"
                            :username "janko_aca"
                            :pass "1"
                            :active true
                            :role_id "A"}

     (user_app/find-user-by-username "milan") => {:first_name "Milan" :last_name "Danković"
                                                      :email "milan.dank@yahoo.com"
                                                      :telephone "060/59-xx-xxx"
                                                      :username "milan"
                                                      :pass "1"
                                                      :active true
                                                      :role_id "A"}

)


(midje.sweet/facts "Test Update user"
                   (user_app/update-data "milan" {:telephone "123"}) => {:first_name "Milan" :last_name "Danković"
                                                                    :email "milan.dank@yahoo.com"
                                                                    :telephone "123"
                                                                    :username "milan"
                                                                    :pass "1"
                                                                    :active true
                                                                    :role_id "A"}

 )

(midje.sweet/facts "Test Delete user"
                   (user_app/delete-data "milan" ) => true
)