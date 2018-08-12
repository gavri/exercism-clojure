(ns armstrong-numbers)

(defn expt [base exponent]
  (defn expt-recur [base exponent result-so-far]
    (if (= exponent 0) result-so-far
      (recur base (- exponent 1) (* base result-so-far))))
  (expt-recur base exponent 1))

(defn digits [num]
  (defn digits-recur [num result-so-far]
    (cond (= num 0) result-so-far
          :else (let [r (rem num 10)
                      q (quot num 10)]
                  (recur q (cons r result-so-far)))))
  (digits-recur num '()))

(defn armstrong? [num]
  (let [ds (digits num)
        c (count ds)]
    (= num (apply + (map #(expt % c) ds)))))
