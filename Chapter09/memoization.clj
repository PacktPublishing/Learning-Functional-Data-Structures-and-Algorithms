; Written by Raju
; Run using following command
; clojure memoization.clj
;Memoization in Clojure
(defn simpleFactFun [n]
  (if (or (= n 1) (= n 0)) 1  
 	   ( do 
		(println "Calculating Factorial")
		 ( * n (simpleFactFun (dec n))))
  )
)

(println  (simpleFactFun 5))

(def  memoizedFactFun (memoize simpleFactFun))

(println  (memoizedFactFun 5))

(println (memoizedFactFun 5))


