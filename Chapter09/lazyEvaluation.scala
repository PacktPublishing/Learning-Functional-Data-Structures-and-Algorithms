// Written by Raju
// Run it using following command
// scala lazyEvaluation.scala
var sv = 5
sv = 6
val svc = 5
sv = 5
lazy val svl = 5
// Lazy Value date example 
import  java.util.Calendar  //Line One
lazy val lazyDate = Calendar.getInstance.getTime  //Line Two
val simpleDate = Calendar.getInstance.getTime  // Line Three
val rl = 1 to 20 //Line Four 
for(x <- rl) print(x) //Line Five 
 println("Simple Date Variable Value Is : " + simpleDate) // Line Six
 println("Lazy Date Variable Value Is : " + lazyDate) // Line Seven

