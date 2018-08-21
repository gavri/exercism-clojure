(ns isbn-verifier)

(defn is-digit? [c] (Character/isDigit c))

(defn remove-hyphens [isbn]
  (clojure.string/replace isbn "-" ""))

(defn special-check-digit? [c] (= \X c))

(defn valid-check-digit? [c]
  ((some-fn is-digit? special-check-digit?) c))

(defn all-valid-isbn-characters? [isbn]
  (let [check-digit (last isbn)
        first-9-digits (butlast isbn)]
    (and (every? is-digit? first-9-digits) (valid-check-digit? check-digit))))

(defn character-to-number [c]
  (if (special-check-digit? c) 10 (Integer/parseInt (str c))))

(defn valid-isbn-numbers? [isbn-numbers]
  (let [scales (range 10 0 -1)
        isbn-numbers-scaled (map * scales isbn-numbers)
        sum-of-isbn-numbers-scaled (apply + isbn-numbers-scaled)]
    (= (mod sum-of-isbn-numbers-scaled 11) 0)))

(defn valid-isbn-checksum? [normalized-isbn]
  (let [isbn-numbers (map character-to-number normalized-isbn)]
    (valid-isbn-numbers? isbn-numbers)))

(defn valid-isbn-length? [isbn]
  (= (count isbn) 10))

(defn isbn? [isbn]
  (let [normalized-isbn (remove-hyphens isbn)]
    ((every-pred valid-isbn-length?  all-valid-isbn-characters? valid-isbn-checksum?) normalized-isbn)))
