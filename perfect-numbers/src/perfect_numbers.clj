(ns perfect-numbers)

(defn factors [n]
  (letfn [(is-n-divisible-by [m] (== (mod n m) 0))]
    (filter is-n-divisible-by (range 1 n))))

(defn classify [n]
  (let [sum-of-factors (apply + (factors n))]
    (cond (< n 0) (throw (IllegalArgumentException. "Number shouldn't be negative"))
          (> sum-of-factors n) :abundant
          (< sum-of-factors n) :deficient
          :else :perfect)))
