(ns nucleotide-count)

(def nucleotides #{\A \G \C \T})

(defn nucleotide-counts [strand]
  (let [nucleotide-init-counts (zipmap nucleotides (repeat 0))]
    (merge nucleotide-init-counts (frequencies strand))))

(defn count [nucleotide strand]
  {:pre [(contains? nucleotides nucleotide)]}
  (get (nucleotide-counts strand) nucleotide))

