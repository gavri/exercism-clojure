(ns anagram
  (:require [clojure.string :as string]))

(defn anagrams-for [word prospect-list]
  (letfn [(anagram-equivalence [s] (sort (string/lower-case s)))
          (case-insensitive-equal? [comparee comparand] (= (string/lower-case comparee) (string/lower-case comparand)))]
    (let [anagram-equivalence-for-input (anagram-equivalence word)
          prospect-list-without-input-word (remove #(case-insensitive-equal? % word) prospect-list)]
      (filter #(= (anagram-equivalence %) anagram-equivalence-for-input) prospect-list-without-input-word))))
