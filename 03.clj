(def factor?
  (comp zero? rem))

(defn prime-factors [number]
  (loop [number number prime 2 factors #{}]
    (cond
      (= number 1) factors
      (factor? number prime) (recur (/ number prime) prime (conj factors prime))
      :else (recur number (inc prime) factors))))


(prime-factors 35)
(prime-factors 24)
(prime-factors 600851475143)

(apply max (prime-factors 35))
(apply max (prime-factors 24))
(apply max (prime-factors 600851475143))

(defn largests-prime-factor [n]
  (apply max (prime-factors n)))

(largests-prime-factor 2)
(largests-prime-factor 45)
(largests-prime-factor 70)

(largests-prime-factor 600851475143)

(defn largests-prime-factor [n]
  (->>
   n
   (prime-factors)
   (apply max)))

(largests-prime-factor 600851475143)
