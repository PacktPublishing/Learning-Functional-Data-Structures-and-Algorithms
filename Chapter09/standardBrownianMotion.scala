// Written by Raju
// Run it using following command
//  scala standardBrownianMotion.scala

import Stream._

def brownianPathGenerator( x : Double) : Stream[Double] = {
        val y = scala.util.Random.nextGaussian
        cons(x, brownianPathGenerator(x+y))
     }

val brownianPath = brownianPathGenerator( 0 ).take(10)
println("Printing 10 elements of a Standard Brownian Path")
println("------------------------------------------------")
brownianPath.toList.foreach(println)
