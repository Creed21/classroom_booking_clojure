(ns aiproject.core
  (:require
    [aiproject.model.classroom :as classroom]
    ;[aifinal.model.user_app :as user_app]
    [aiproject.controller.controller :as controller]
    [compojure.core :refer [defroutes GET POST]]
    [compojure.route :as route]
    [ring.adapter.jetty :refer [run-jetty] :as jetty]
    [ring.util.response :as resp]
    ))

(defroutes public-routes
           (GET "/" [] (controller/home))
           (route/resources "/")

           (GET "/home" [] (controller/home))
           (route/resources "/")

           (GET "/classRooms" [] (controller/all-classrooms))
           (route/resources "/")

            (GET "/createClassRoom" [] (controller/new-classroom ))
            (route/resources "/")

            (POST "/createClassRoom" [& data]
            (do (controller/new-classroom1 data)
                (resp/redirect "/classRooms")))

            (GET "/user/:username" [username] (controller/get-user username))
            (route/resources "/")

            (GET "/reservations" [] (controller/all-reservations))
            (route/resources "/")

 )



(jetty/run-jetty (fn [req] (public-routes req)) {:port 4003 :join? false})
