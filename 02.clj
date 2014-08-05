(def fibonaccis
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(take 12 fibonaccis) ; (0 1 2 3 5 8 13 21 34 55 89)

(take-while (partial > 100) fibonaccis) ; (0 1 2 3 5 8 13 21 34 55 89)

(filter even? (take-while (partial > 100) fibonaccis)) ; (0 2 8 34)

(reduce + (filter even? (take-while (partial > 4000000) fibonaccis))) ; 4613732

(def evens-in (partial filter even?))

(defn fibonaccis-below [num]
  (take-while (partial > num) fibonaccis))

(reduce + 0 (evens-in (fibonaccis-below 4000000))) ; 4613732
