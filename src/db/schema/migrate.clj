(ns db.schema.migrate
  (:use [clojure.core] :reload)
  (require [clojure.core.async :refer (<!!)]
           [datomic.client :as client]))

(require 'db.connection)

(def movie-schema [{:db/ident :movie/title
                    :db/valueType :db.type/string
                    :db/cardinality :db.cardinality/one
                    :db/doc "The title of the movie"}

                   {:db/ident :movie/genre
                    :db/valueType :db.type/string
                    :db/cardinality :db.cardinality/one
                    :db/doc "The genre of the movie"}

                   {:db/ident :movie/release-year
                    :db/valueType :db.type/long
                    :db/cardinality :db.cardinality/one
                    :db/doc "The year the movie was released in theaters"}])

(defn migrate-movie-schema
  []
  (<!! (client/transact db.connection/connect {:tx-data movie-schema})))
