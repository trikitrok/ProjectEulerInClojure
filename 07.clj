(defn is-prime? [n]
  (loop [i 2]
    (cond
     (= i n) true
     (zero? (rem n i)) false
     :else (recur (+ i 1)))))

(is-prime? 2)
(is-prime? 3)
(is-prime? 4)

(def nums (iterate inc 2))

(last (take 5 (filter is-prime? nums)))
;(last (take 10001 (filter is-prime? nums))) ; 104743

(def factor?
  (comp zero? rem))

(defn prime-factors [n]
  (loop [n n prime 2 factors []]
    (cond
      (= n 1) factors
      (factor? n prime) (recur (/ n prime) prime (conj factors prime))
      :else (recur n (inc prime) factors))))

(defn is-prime? [n]
  (= 1 (count (prime-factors n))))

(is-prime? 2)
(is-prime? 3)
(is-prime? 4)

(last (take 5 (filter is-prime? nums)))
;(last (take 10001 (filter is-prime? nums))) ;104743
;(last (take 10001 (filter #(= 1 (count %)) (map prime-factors nums))))

(defn prime? [n]
  (loop [n n prime 2 factors []]
    (if (> (count factors) 1)
      false
      (cond
       (= n 1) true
       (factor? n prime) (recur (/ n prime) prime (conj factors prime))
       :else (recur n (inc prime) factors)))))

(prime? 3)
(prime? 40)
(prime? 40000)
(prime? 40000000)

(iterate #(vector (prime? (inc (second %))) (inc (second %))) [2 2])
(filter #(first %) (iterate #(vector (prime? (inc (second %))) (inc (second %))) [2 2]))
;(last (take 10001 (filter #(first %) (iterate #(vector (prime? (inc (second %))) (inc (second %))) [2 2]))))

(defn prime [n]
  (loop [n n prime 2 factors []]
    (if (> (count factors) 1)
      false
      (cond
       (= n 1) prime
       (factor? n prime) (recur (/ n prime) prime (conj factors prime))
       :else (recur n (inc prime) factors)))))

;(last (take 10001 (filter #(not (false? %)) (map prime (range)))))



