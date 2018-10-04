(ns clock)

(defn clock-number-str [n]
  (format "%02d" n))

(defn div [m n]
  (int (Math/floor (/ m n))))

(defn clock->string [clock]
  (str (clock-number-str (clock :hours)) ":" (clock-number-str (clock :minutes))))

(defn clock [hours minutes]
  (let [all-minutes (+ (* hours 60) minutes)
        normalized-hours (div all-minutes 60)
        clock-minutes (mod all-minutes 60)
        clock-hours (mod normalized-hours 24)
        ]
    {:hours clock-hours :minutes clock-minutes}))

(defn add-time [c time]
  (clock (c :hours) (+ time (c :minutes))))

