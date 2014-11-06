(defn multiple? [n]
  (fn [x] (zero? (mod x n))))

(def triple? (multiple? 3))

(def quintuple? (multiple? 5))

(quintuple? 5)
(quintuple? 3)
(quintuple? 10)
(triple? 3)
(triple? 5)

(defn quintuple-or-triple? [x]
  (or (triple? x) (quintuple? x)))

(quintuple-or-triple? 3)
(quintuple-or-triple? 5)
(quintuple-or-triple? 4)

(defn all-quintuple-or-triple-below [n]
  (filter
   quintuple-or-triple?
   (range 1 n)))

(all-quintuple-or-triple-below 10)

(def sum-all-quintuple-or-triple-below-below
  (comp
   (partial reduce +)
   (partial all-quintuple-or-triple-below)))

(sum-all-quintuple-or-triple-below-below 10)

(sum-all-quintuple-or-triple-below-below 1000)

(sum-all-quintuple-or-triple-below-below 10000000)

(sum-all-quintuple-or-triple-below-below 100000000)

(defn sum-all-quintuple-or-triple-below-below [x]
  (->>
   x
   (all-quintuple-or-triple-below)
   (reduce +)))

(sum-all-quintuple-or-triple-below-below 10)

(def all-quintuples-or-triples
  (filter
   quintuple-or-triple?
   (range)))

(defn below [num]
  (partial take-while (partial > num)))

(reduce + ((below 10) all-quintuples-or-triples))

(def sum (partial reduce +))

(defn multiple-of [n]
  (fn [x] (zero? (mod x n))))

(def multiple-of-3? (multiple-of 3))

(def multiple-of-5? (multiple-of 5))

(sum
 (for [x (range 1001)
       :when (and (multiple-of-3? x)
                  (multiple-of-5? x))]
   x))

(sum
 (filter #(and (multiple-of-3? %)
               (multiple-of-5? %))
         (range 1 1001)))
