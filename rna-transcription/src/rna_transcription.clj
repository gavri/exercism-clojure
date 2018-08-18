(ns rna-transcription)

(def transcription-map
  {
   \C \G
   \G \C
   \A \U
   \T \A
   }
  )

(defn validate-dna-strand [dna-strand]
  (doseq [nucleotide dna-strand]
    (assert (contains? transcription-map nucleotide)) dna-strand))

(defn to-rna [dna]
  (validate-dna-strand dna)
  (apply str (map #(transcription-map %) dna)))
