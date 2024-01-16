(ns aiproject.core
  (:require
    [compojure.core :refer [defroutes GET POST DELETE PUT]]
    [aiproject.controller.controller :as controller]
    [aiproject.controller.controller_api :as controller_api]
    [compojure.route :as route]
    [ring.adapter.jetty :refer [run-jetty] :as jetty]
    [ring.util.response :as resp]
    [ring.util.response :refer [response json-response]]
    [cheshire.core :as json]
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


           ; REST API
           ; classroom rest api
           (GET "/api/classRooms" [] (json-response (controller_api/all-classrooms)))
           (GET "/api/classRooms/filtered" [condition] (json-response (controller_api/classroom-filtered condition)))
           (POST "/api/classRooms" [& data]
             (json-response (controller_api/new-classroom data)))
           (PUT "/api/classRooms" [id & data]
             (json-response (controller_api/update-classroom id data)))
           (DELETE "/api/classRooms" [id]
             (json-response (controller_api/delete-classroom id)))

           ; reservation rest api
           (GET "/api/reservations" [] (json-response (controller_api/all-reservations)))
           (GET "/api/reservations/filtered" [condition] (json-response (controller_api/reservations-filtered condition)))
           (POST "/api/reservations" [& data]
             (json-response (controller_api/new-reservation data)))
           (PUT "/api/reservations" [id & data]
             (json-response (controller_api/update-reservations id data)))
           (DELETE "/api/reservations" [id]
             (json-response (controller_api/delete-reservations id)))

           ; reservation_status rest api
           (GET "/api/reservationStatus" [] (json-response (controller_api/all-reservation_status)))
           (POST "/api/reservationStatus" [& data]
             (json-response (controller_api/new-reservation_status data)))
           (PUT "/api/reservationStatus" [id & data]
             (json-response (controller_api/update-reservation_status id data)))
           (DELETE "/api/reservationStatus" [id]
             (json-response (controller_api/delete-reservation_status id)))

           ; reservation_type rest api
           (GET "/api/reservationType" [] (json-response (controller_api/all-reservation_type)))
           (POST "/api/reservationType" [& data]
             (json-response (controller_api/new-reservation_type data)))
           (PUT "/api/reservationType" [id & data]
             (json-response (controller_api/update-reservation_type id data)))
           (DELETE "/api/reservationType" [id]
             (json-response (controller_api/delete-reservation_type id)))

           ; user rest api
           (GET "/api/user_app" [username] (json-response (controller_api/get-user username)))
           (GET "/api/user_app/filtered" [condition] (json-response (controller_api/get-user-filtered condition)))
           (POST "/api/user_app" [& data]
             (json-response (controller_api/new-user data)))
           (PUT "/api/user_app" [username & data]
             (json-response (controller_api/update-user username data)))
           (DELETE "/api/user_app" [username]
             (json-response (controller_api/delete-user username)))

           ; classroom type rest api
           (GET "/api/classroomTypes" [] (json-response (controller_api/all-classroom_type)))
           (GET "/api/classroomTypes/filtered" [condition] (json-response (controller_api/all-classroom_type_filtered condition)))
           (POST "/api/classroomTypes" [& data]
             (json-response (controller_api/new-classroom_type data)))
           (PUT "/api/classroomTypes" [id & data]
             (json-response (controller_api/update-classroom_type id data)))
           (DELETE "/api/classroomTypes" [id]
             (json-response (controller_api/delete-classroom_type id)))
           )

(defn json-response [data]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})


(jetty/run-jetty (fn [req] (public-routes req)) {:port 4003 :join? false})
