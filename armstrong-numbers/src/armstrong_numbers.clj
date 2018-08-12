(ns armstrong-numbers)

(defn expt [base exponent]
  (if (= exponent 0) 1
    (* base (expt base (- exponent 1)))))

(defn digits [num]
  (cond (= num 0) '()
        :else (let [r (rem num 10)
                    q (quot num 10)]
                (cons r (digits q)))))

(defn armstrong? [num]
  (let [ds (digits num)
        c (count ds)]
    (= num (apply + (map #(expt % c) ds)))))
