(ns run-length-encoding)

(defn re-seq-inner-groups [re s]
  (map rest (re-seq re s)))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]

  (defn run-length-encode-a-partition [part]
    (if (= (count part) 1) part (list (count part) (first part))))

  (apply str (mapcat run-length-encode-a-partition (partition-by identity plain-text))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]

  (defn parts [cipher-text]
    (map #(hash-map :count (first %) :character (second %)) (re-seq-inner-groups #"(\d*)([^\d])" cipher-text)))

  (defn counts-and-parts [parts]

    (defn count-string-to-count-integer [count-string]
      (if (empty? count-string) 1 (Integer. count-string)))

    (map #(update % :count count-string-to-count-integer) parts))

  (apply str (mapcat #(repeat (:count %) (:character %)) (counts-and-parts (parts cipher-text)))))
