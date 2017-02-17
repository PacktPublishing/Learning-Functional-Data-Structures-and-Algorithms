// Written by Raju
// Run it using following command
// scala fiboSeries.scala
import Stream._
def fiboSeries(x : BigInt, y : BigInt) : Stream[BigInt] = {
     cons(x,fiboSeries(y,x+y))
    }

val fibSeriesWithZero = fiboSeries(0,1)
println("Printing Fibonacci series with start element 1 and 1")
println("----------------------------------------------------")
fibSeriesWithZero.take(5).foreach(println)
println("Printing Fibonacci series with start element 1 and 1")
println("----------------------------------------------------")
val fibSeriesWithOne = fiboSeries(1,1)
fibSeriesWithOne.take(5).foreach(println)
