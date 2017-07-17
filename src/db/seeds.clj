(ns db.seeds
  (:use [clojure.core] :reload)
  (require [clojure.core.async :refer (<!!)]
           [datomic.client :as client]))

(require 'db.connection)

(def first-movies [{:movie/title "The Goonies"
                    :movie/genre "action/adventure"
                    :movie/release-year 1985}
                   {:movie/title "Commando"
                    :movie/genre "action/adventure"
                    :movie/release-year 1985}
                   {:movie/title "Repo Man"
                    :movie/genre "punk dystopia"
                    :movie/release-year 1984}])

(<!! (client/transact db.connection/connect {:tx-data first-movies}))
