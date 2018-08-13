(ns reverse-string)

(defn reverse-sequence [sequence]
  (loop [sequence sequence result-so-far '()]
    (cond (= (count sequence) 0) result-so-far
          :else (recur (rest sequence) (cons (first sequence) result-so-far)))))

(defn reverse-string [s]
  (apply str (reverse-sequence s)))
