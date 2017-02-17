; Written by Raju
; Run using following command
; clojure standardBrownianMotion.clj
;Standard Brownian Motion in Clojure

 (defn brownianPathGenerator [x] ;; Line One 
  (def rndm (java.util.Random.)) ;; Line Two
  (def y (.nextGaussian rndm)) ;; Line Three
 (lazy-seq (cons x (brownianPathGenerator (+ x y))))) ;; Line Four 

(println  (take 10 (brownianPathGenerator 0)))

