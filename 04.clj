(reverse (range 100 1000))

(defn- palindrome? [number]
  (let [num-str (str number)]
    (= num-str (apply str (reverse num-str)))))

(palindrome? 9009)
(palindrome? 9008)

(apply
 max
 (filter
  palindrome?
  (let [numbers (reverse (range 10 100))]
    (for [x1 numbers x2 numbers]
      (* x1 x2)))))

(defn palindromes-in [lower higher]
  (let [numbers (reverse (range lower (+ higher 1)))]
    (filter palindrome?
            (for [x1 numbers x2 numbers]
      (* x1 x2)))))

(defn largest-palindrome-in [lower higher]
  (apply max (palindromes-in lower higher)))

(largest-palindrome-in 10 99)
(largest-palindrome-in 100 999)
