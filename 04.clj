(reverse (range 100 1000))

(defn palindrome? [number]
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

(defn products [lower higher]
  (let [numbers (reverse (range lower (+ higher 1)))]
    (for [x1 numbers x2 numbers]
      (* x1 x2))))

(defn palindrome-products [lower higher]
  (filter palindrome? (products lower higher)))

(defn largest-palindrome-product [lower higher]
  (apply max (palindrome-products lower higher)))

(largest-palindrome-product 10 99)
(largest-palindrome-product 100 999)
