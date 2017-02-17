; Written by Raju
; Run using following command
; clojure arithmeticProgression.clj

;Arithmetic progression in Clojure

 (defn arithmeticProgression [ft cd]
  ( lazy-seq  (cons ft (arithmeticProgression (+ ft cd) cd))))

(println (take 10 (arithmeticProgression 2 3)))

