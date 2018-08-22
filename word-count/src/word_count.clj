(ns word-count
  (:require [clojure.string :as string]))

(defn word-count [s]
  (letfn [(remove-punctation [s] (string/replace s #"[^a-zA-Z0-9]" " "))
          (split-into-words [s] (string/split s #" +"))]
    (->> s remove-punctation string/lower-case split-into-words frequencies)))
