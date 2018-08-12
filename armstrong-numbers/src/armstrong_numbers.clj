(ns armstrong-numbers)

(defn expt [base exponent]
  (loop [exponent exponent
         result-so-far 1]
    (if (= exponent 0) result-so-far
      (recur (- exponent 1) (* base result-so-far)))))

(defn digits [num]
  (loop [num num
         result-so-far '()]
    (cond (= num 0) result-so-far
          :else (let [r (rem num 10)
                      q (quot num 10)]
                  (recur q (cons r result-so-far))))))

(defn armstrong? [num]
  (let [ds (digits num)
        c (count ds)]
    (= num (apply + (map #(expt % c) ds)))))
