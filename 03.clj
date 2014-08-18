(def factor?
  (comp zero? (partial rem)))

(defn prime-factors [n]
  (loop [m 2, n n, factors #{}]
    (cond
     (> m n) factors
     (factor? n m) (recur m (/ n m) (conj factors m))
     :else (recur (inc m) n factors))))

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
