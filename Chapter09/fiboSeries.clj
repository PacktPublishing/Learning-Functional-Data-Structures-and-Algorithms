; Written by Raju
; Run using following command
; clojure fiboSeries.clj
;Fibonacci Series in Clojure

 (defn fiboSeries [x y]
 (lazy-seq (cons x (fiboSeries y (+ x y)))))

(println  (take 5 (fiboSeries 0 1)))

(println (take 5 (fiboSeries 1 1)))

