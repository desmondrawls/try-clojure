(ns db.connection
  (:use [clojure.core] :reload)
  (require [clojure.core.async :refer (<!!)]
           [datomic.client :as client]))

(def connect
  (<!! (client/connect
         {:db-name "hello"
          :account-id client/PRO_ACCOUNT
          :secret "izLMDpeKtRzc4AY2"
          :region "none"
          :endpoint "localhost:8998"
          :service "peer-server"
          :access-key "smackouch"})))

(def db (client/db connect))

(def all-movies-q '[:find ?movie-title
                    :where [_ :movie/title ?movie-title]])

(<!! (client/q connect {:query all-movies-q :args [db]}))
