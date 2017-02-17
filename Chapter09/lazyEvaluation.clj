; Written by Raju
; Run using following command
; clojure lazyEvaluation.clj
; Lazy Evaluation in Clojure
(def lazyVal (delay 10))
(println lazyVal)
(println (realized? lazyVal))
(println (class lazyVal))
(println (deref lazyVal))
(println lazyVal)
(println (realized? lazyVal))
(println (def lazyVal (delay 10)))

(println (force lazyVal))
(println (def lazyVal (delay 10)))
(println @lazyVal)
(println (def fp (promise)))
(println (realized? fp))
(println (deliver fp (str "MyString")))
(println (realized? fp))
(println fp)
(println (deref fp))
(println (def lazyDate ( delay (new java.util.Date))))
(println lazyDate )
(println (def simpleDate  (new java.util.Date)))
(println simpleDate)
(println (count [1,2,3,4,5]))
(println simpleDate)
(println (deref lazyDate))
