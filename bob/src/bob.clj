(ns bob)

(defn isQuestion [s] (= (last s) \?))
(defn isYelledOut [s] (and (not (some #(Character/isLowerCase %) s)) (some #(Character/isUpperCase %) s)))
(defn isYelledOutQuestion [s] (and (isQuestion s) (isYelledOut s)))
(defn isSilence [s] (clojure.string/blank? s))

(defn response-for [s]
  (cond (isSilence s) "Fine. Be that way!"
        (isYelledOutQuestion s) "Calm down, I know what I'm doing!"
        (isYelledOut s) "Whoa, chill out!"
        (isQuestion s) "Sure."
        :else "Whatever."))
