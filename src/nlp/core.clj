(ns nlp.core
  (:require [clojure.string :refer [blank? split]]))

(defn read-file [f]
  (slurp f))

(defn word-count [s]
  (->> (remove blank? (split s #"\s"))
       (group-by identity )
       (map (fn [[k v]] [k (count v)]))
       (sort-by last)
       (reverse)))

(defn word-frequency [s]

  )

(defn zipfs-law [f]

  )

(defn collocations [f]

  )

(defn bigrams [f]
  )

(defn kwic [f word]

  )
  
