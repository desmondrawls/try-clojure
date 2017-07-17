(ns try-clojure.core
  (:gen-class))

(:require 'db.schema.migrate)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (db.schema.migrate/migrate))
