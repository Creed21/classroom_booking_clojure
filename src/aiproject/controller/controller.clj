(ns aiproject.controller.controller
  (:require
    [clostache.parser :as clostache]
    [clojure.java.io]
    [aiproject.model.classroom :as classroom]
    [aiproject.model.user_app :as user_app]
    [aiproject.model.reservation :as reservation]
    ))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "pages/" template-name ".mustache"))))


(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn home []
  (render-template "home" {}))

(defn all-classrooms []
  (render-template "classRooms" {:classRooms (classroom/read-data)}))

(defn new-classroom1 [data]
  (render-template "createClassRoom" {:createClassRoom (classroom/insert-data data)}))

(defn new-classroom []
  (render-template "createClassRoom" {:createClassRoom (classroom/read-data)}))

(defn update-classroom [id data]
  (render-template "classrooms" {:classrooms (classroom/update-data id data)}))

(defn delete-classroom [id]
  (render-template "classrooms" {:classrooms (classroom/delete-data id)}))

(defn get-user [username]
  (render-template "user" {:user (user_app/find username )}))

(defn all-reservations []
  (render-template "reservations" {:reservations (reservation/read-data )}))

