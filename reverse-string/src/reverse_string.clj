(ns reverse-string)

(defn reverse-seq [sequence]
  (reduce conj '() sequence))

(defn reverse-string [s]
  (apply str (reverse-seq s)))
