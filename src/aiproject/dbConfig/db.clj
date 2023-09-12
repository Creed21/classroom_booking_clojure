(ns aiproject.dbConfig.db)

(def db-spec
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "//localhost:5432/final_p"
   :user "postgres"
   :password "$@postgres$@"})
