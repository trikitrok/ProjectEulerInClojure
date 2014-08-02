(def fibo (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(take 12 fibo)

;1, 2, 3, 5, 8, 13, 21, 34, 55, 89

(take-while (partial > 100) fibo)

(filter even? (take-while (partial > 100) fibo))

(reduce + (filter even? (take-while (partial > 4000000) fibo))) ; 4613732