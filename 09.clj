(defn square [x]
  (* x x))

(defn pythagorean-triplet? [a b c]
  (and (< a b c)
       (= (square c) (+ (square a) (square b)))))

(def triplet
  (let [nums (range 500)]
    (for [a nums
          b nums
          c nums
          :when (and (= 1000 (+ a b c))
                     (pythagorean-triplet? a b c))]
      [a b c])))

triplet

(reduce * triplet)
