(def positive-integers (iterate inc 1))

(def evenly-divisible?
  (comp zero? rem))

(evenly-divisible? 16 4)
(evenly-divisible? 9 3)
(evenly-divisible? 10 3)

(defn evenly-divisible-by-numbers? [from to number]
  (let [numbers (range from (+ to 1))]
    (every? (partial evenly-divisible? number) numbers)))

(evenly-divisible-by-numbers? 1 2 4)
(evenly-divisible-by-numbers? 1 3 4)
(evenly-divisible-by-numbers? 1 10 2520)

(defn positive-numbers-evenly-divisible-by-numbers [from to]
  (filter (partial evenly-divisible-by-numbers? from to)
          positive-integers))

(first (positive-numbers-evenly-divisible-by-numbers 1 10))

;(first (positive-numbers-evenly-divisible-by-numbers 1 20)) ; java.lang.OutOfMemoryError: GC overhead limit exceeded

(def factor?
  (comp zero? rem))

(defn prime-factors [n]
  (loop [n n prime 2 factors []]
    (cond
      (= n 1) factors
      (factor? n prime) (recur (/ n prime) prime (conj factors prime))
      :else (recur n (inc prime) factors))))

(defn unique-factor? [factors]
  (and (not (empty? factors))
       (apply = factors)))

(defn extract-divisors [numbers-with-unique-factor]
  (loop [numbers-with-unique-factor numbers-with-unique-factor divisors [] factors []]
    (if (empty? numbers-with-unique-factor)
      divisors
      (let [factor (first (second (first numbers-with-unique-factor)))]
        (if (some #{factor} factors)
          (recur (rest numbers-with-unique-factor) divisors factors)
          (recur (rest numbers-with-unique-factor) (conj divisors (first (first numbers-with-unique-factor))) (conj factors factor)))))))

(extract-divisors '([9 [3 3]] [8 [2 2 2]] [7 [7]] [6 [2 3]]))
(extract-divisors
 (filter #(unique-factor? (second %))
         (map #(vector % (prime-factors %)) (reverse (range 1 10)))))

(reduce
 *
 (extract-divisors
  (filter #(unique-factor? (second %))
          (map #(vector % (prime-factors %)) (reverse (range 1 10))))))

(defn smallest-positive-number-evenly-divisible-by-all [from to]
  (reduce
   *
   (extract-divisors
    (filter #(unique-factor? (second %))
            (map #(vector % (prime-factors %)) (reverse (range from (+ to 1))))))))

(smallest-positive-number-evenly-divisible-by-all 1 10)
(smallest-positive-number-evenly-divisible-by-all 1 20)

(defn greatest-common-divisor [a b]
  (if (zero? b)
    a
    (greatest-common-divisor b (rem a b))))

(defn least-common-multiple [a b]
   (/ (* a b) (greatest-common-divisor a b)))

(defn smallest-positive-number-evenly-divisible-by-all [from to]
  (reduce
    least-common-multiple
    (range from (+ to 1))))

(smallest-positive-number-evenly-divisible-by-all 1 10)
(smallest-positive-number-evenly-divisible-by-all 1 20)
