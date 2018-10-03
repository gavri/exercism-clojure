(ns hamming)

(defn distance [strand1 strand2]
  (cond (= (count strand1) (count strand2)) (count (filter #(apply not= %) (map vector strand1 strand2)))
        :else nil))
