; Written by Raju
; Run using following command
; clojure streamSequence.clj
;Streams (lazy sequence) in Clojure

(defn strFun [n]
( lazy-seq  (println "Evaluating next element of Stream") (cons n (strFun (inc n)))))

(println (take 3  (strFun 1)))

;Creating a memoized function of lazy sequences in Clojure

(defn strFun [n]
 ( lazy-seq  (println "Evaluating next element of Stream") (cons n (strFun (inc n)))))

(def memzstrFun (memoize strFun))

(println  (take 3 (memzstrFun 1)))

(println  (take 3 (memzstrFun 1)))

