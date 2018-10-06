(ns binary)

(defn digit-to-number [digit]
  (- (int digit) (int \0)))

(defn is-binary-digit? [c]
  (or (= c \1) (= c \0)))

(defn valid-binary-representation? [bin]
  (every? is-binary-digit? bin))

(defn to-decimal [bin]
  (let [place-values (iterate (partial * 2) 1)
        numbers-at-places (map digit-to-number (reverse (seq bin)))]
    (if (valid-binary-representation? bin)
      (apply + (map * numbers-at-places place-values))
      0)))
