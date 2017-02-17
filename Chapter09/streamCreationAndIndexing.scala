// Written by Raju
// Run it using following command
//  scala streamCreationAndIndexing.scala

import scala.Stream
var ms = Stream("a","b","c","d","e")
println("Printing created Stream")
println("-----------------------")
println(ms)
println("-----------------------")

//Indexing the elements of Stream
println("Printing first element of Stream")
println("--------------------------------")
println(ms(0))
println("Printing third element of Stream")
println("--------------------------------")
println(ms(2))

println(ms)
