(ns leap)

(defn leap-year? [year]
  (defn year-is-divisible-by [n]
    (== (mod year n) 0))
  (cond (year-is-divisible-by 400) true
        (year-is-divisible-by 100) false
        (year-is-divisible-by 4) true
        :else false))
