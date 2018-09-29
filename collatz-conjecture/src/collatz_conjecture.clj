(ns collatz-conjecture)

(defn collatzStep [n]
  (if (even? n) (quot n 2) (+ (* 3 n) 1)))

(defn collatz [n]
  (cond (< n 1) (throw "n should be greater than 0")
        :else (count (take-while #(not= 1 %) (iterate collatzStep n)))))
