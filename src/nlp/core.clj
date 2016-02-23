(ns nlp.core
  (:require [clojure.string :refer [blank? split]]))

(defn read-file [f]
  (slurp f))

(defn word-count-raw [s]
  (->> (remove blank? (split s #"\s"))
       (group-by identity )
       (map (fn [[k v]] [k (count v)]))
       (sort-by last)
       (reverse)))
(def word-count (memoize word-count-raw))

(defn word-frequency [s]
  (->> (word-count s)
      (group-by last)
      (map (fn [[occurrences words]]
             {:occurrences occurrences
              :num-words (count words)}))))

(defn zipfs-law [s]
  (->> (word-count s)
       (map-indexed (fn [idx [word freq]]
                      (let [rank (inc idx)]
                        {:word word
                         :freq freq
                         :rank rank
                         :score (* freq rank)})))))

(defn collocations [f]

  )

(defn bigrams [f]
  )

(defn kwic [f word]

  )
  
