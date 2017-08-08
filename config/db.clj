(ns db
  (:require [migratus.core :as migratus]))

(let [db-host "localhost"
      db-port 3306
      db-name "a_database"]
  (def config {:store                :database
               :migration-dir        "migrations/"
               :init-script          "init.sql"
               ;;defaults to true, some databases do not support
               ;;schema initialization in a transaction
               :init-in-transaction? false
               :migration-table-name "foo_bar"
               :db {:classname   "com.mysql.jdbc.Driver"
                    :subprotocol "mysql"
                    :subname     (str "//" db-host ":" db-port "/" db-name)
                    :user        "root"
                    :password    ""}}))
