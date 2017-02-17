// Written by Raju
// Run it using following command
//scala eagerEvaluation.scala
//Eager Evaluation
var fv  = 5

def leftBool(x : Int) : Boolean ={
      	println("Left Function")
     	x > 5
      }

def rightBool(x : Int) : Boolean = {
     println(" Right Function")
     x < 6
  }

var x = 3
println(leftBool(x) && rightBool(x))
 x = 6
println(leftBool(x) && rightBool(x))
