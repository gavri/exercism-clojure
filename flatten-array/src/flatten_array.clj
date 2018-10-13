(ns flatten-array)

(defn flatten [arr]
  (cond (vector? arr) (into [] (apply concat (map flatten arr)))
        (nil? arr) []
        :else [arr]))

