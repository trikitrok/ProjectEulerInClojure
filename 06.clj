(defn pow [x n]
  (reduce * (repeat n x)))

(pow 55 2)

(defn square [x]
  (pow x 2))

(square 55)

(def sum (comp (partial reduce +) map))

(sum identity (range 0 11))
(sum square (range 0 11))

(defn sum-square-difference [n]
  (let [nums (range 0 (+ 1 n))]
    (- (square (sum identity nums))
       (sum square nums))))

(sum-square-difference 10)
(sum-square-difference 100)


