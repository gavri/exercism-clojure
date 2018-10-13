(ns space-age)

(def orbital-period-in-earth-years
  {:mercury 0.2408467
   :venus 0.61519726
   :earth 1.0
   :mars 1.8808158
   :jupiter 11.862615
   :saturn 29.447498
   :uranus 84.016846
   :neptune 164.79132})

(def earth-orbital-period-in-seconds 31557600)

(defn orbital-period-in-seconds [planet]
  (* (orbital-period-in-earth-years planet) earth-orbital-period-in-seconds))

(defn on-planet [planet seconds]
  (/ seconds (orbital-period-in-seconds planet)))

(def on-mercury (partial on-planet :mercury))
(def on-venus (partial on-planet :venus))
(def on-earth (partial on-planet :earth))
(def on-mars (partial on-planet :mars))
(def on-jupiter (partial on-planet :jupiter))
(def on-saturn (partial on-planet :saturn))
(def on-neptune (partial on-planet :neptune))
(def on-uranus (partial on-planet :uranus))
