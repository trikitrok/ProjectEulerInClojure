(defn sieve [[nums primes]]
  (let [[prime & more] nums]
    (vector (remove #(zero? (rem % prime)) nums)
            (cons prime primes))))

(defn primes-below [n]
  (apply
    concat
    (first
     (drop-while
      #(< (ffirst %) (Math/sqrt n))
      (iterate sieve [(range 2 (inc n)) nil])))))

(defn sum-primes-below [n]
  (reduce + (primes-below n)))

(sum-primes-below 10) ; 17
(sum-primes-below 100) ; 1060
(sum-primes-below 1000) ; 76127
(sum-primes-below 10000) ; 5736396
(sum-primes-below 100000) ; 454396537
(sum-primes-below 2000000) ; 142913828922