(ns aiproject.core
  (:require
    [compojure.core :refer [defroutes GET POST DELETE PUT]]
    [aiproject.controller.controller :as controller]
    [compojure.route :as route]
    [ring.adapter.jetty :refer [run-jetty] :as jetty]
    [ring.util.response :as resp]
    ))

(defroutes public-routes
           ; / home
           (GET "/" [] (controller/home))
           (route/resources "/")

           (GET "/home" [] (controller/home))
           (route/resources "/")

           ; classroom
           (GET "/classRooms" [] (controller/all-classrooms))
           (route/resources "/")

           (GET "/createClassRoom" [] (controller/get-new-classroom ))
           (route/resources "/")

           (POST "/createClassRoom" [& data]
           (do (controller/new-classroom1 data)
                (resp/redirect "/classRooms")))

           (PUT "/updateClassRoom" [id & data]
           (do (controller/update-classroom id data)
                 (resp/redirect "/classRooms")))

           ; user
           (GET "/user/:username" [username] (controller/get-user username))
           (route/resources "/")

           (POST "/user/newUser" [& data] (controller/new-user data))
           (route/resources "/")

           (PUT "/user/:username" [username & data] (controller/update-user username data))
           (route/resources "/")

           (DELETE "/user/:username" [username] (controller/delete-user username))
           (route/resources "/")

           ; reservation
           (GET "/reservations" [] (controller/all-reservations))
           (route/resources "/")

           (POST "/makeReservation" [& data] (controller/new-reservation data))
           (route/resources "/")

           (PUT "/reservations" [id & data] (controller/update-reservations id data))
           (route/resources "/")

           (DELETE "/reservations" [id] (controller/delete-reservations id))
           (route/resources "/")

           ; classroom_type
           (GET "/classroomTypes" [] (controller/all-classroom_type))
           (route/resources "/")

           (POST "/classroomType" [& data] (controller/new-classroom_type data))
           (route/resources "/")

           (PUT "/classroomType" [id & data] (controller/update-classroom_type id data))
           (route/resources "/")

           (DELETE "/classroomType" [id] (controller/delete-classroom_type id))
           (route/resources "/")

           ; reservation_type
           (GET "/reservationType" [] (controller/all-reservation_type))
           (route/resources "/")

           (POST "/reservationType" [& data] (controller/new-reservation_type data))
           (route/resources "/")

           (PUT "/reservationType" [id & data] (controller/update-reservation_type id data))
           (route/resources "/")

           (DELETE "/reservationType" [id] (controller/delete-reservation_type id))
           (route/resources "/")

           ; reservation_status
           (GET "/reservation_status" [] (controller/all-reservation_status))
           (route/resources "/")

           (POST "/reservation_status" [& data] (controller/new-reservation_status data))
           (route/resources "/")

           (PUT "/reservation_status" [id & data] (controller/update-reservation_status id data))
           (route/resources "/")

           (DELETE "/reservation_status" [id] (controller/delete-reservation_status id))
           (route/resources "/")


           ; Classroom Type Analytics
           (GET "/classroom_type/analytics" [] (controller/classroom-type-analytics))
           (route/resources "/")

           ; Reservation Type Analytics
           (GET "/reservation_type/analytics" [] (controller/reservation-type-analytics))
           (route/resources "/")

           ; Reservation Status Analytics
           (GET "/reservation_status/analytics" [] (controller/reservation-status-analytics))
           (route/resources "/")

           ; User Analytics
           (GET "/user/analytics" [] (controller/user-analytics))
           (route/resources "/")


           )



(jetty/run-jetty (fn [req] (public-routes req)) {:port 4003 :join? false})
