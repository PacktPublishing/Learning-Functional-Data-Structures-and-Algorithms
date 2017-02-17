// Written by Raju
// Run it using following command
//  scala immutableStream.scala


import scala.Stream._




def strFun(n : Int) : Stream[Int] = {               
      	println("Evaluating next element of Stream")
     	cons(n,strFun(n+1))
     }

var infStr = strFun(1)


println("Printing second element of Stream")
println("--------------------------------")
println(infStr(1))

//Stream is Immutable

try{
infStr(1) = 10
}catch{
case e:Throwable => println(e)
}

