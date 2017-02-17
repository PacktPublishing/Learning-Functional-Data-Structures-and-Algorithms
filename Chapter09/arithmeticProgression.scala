// Written by Raju
// Run it using following command
//  scala arithmeticProgression.scala

import Stream._

def arithmeticProgression(ft : Double, cd: Double ) : Stream[Double] = {
      		cons(ft, arithmeticProgression(ft+cd, cd ))
           }


val ap = arithmeticProgression(2,3)
println("Printing Arithmetic Progression with first element 2 and  common difference 3")
println("-----------------------------------------------------------------------------")
print(ap.take(5).toList)
