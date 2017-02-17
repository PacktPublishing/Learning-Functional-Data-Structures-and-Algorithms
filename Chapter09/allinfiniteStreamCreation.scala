// Written by Raju
// Run it using following command
// scala allinfiniteStreamCreation.scala


import scala.Stream._



//Creation of a infinite length Stream

var msc = 1 #:: 2 #:: empty

println(empty)

var ms  = cons(1, empty)


def strFun(n : Int) : Stream[Int] = {               
      	println("Evaluating next element of Stream")
     	cons(n,strFun(n+1))
     }

var infStr = strFun(1)

println("Printing first element of Stream")
println("--------------------------------")
println(infStr(0))
println("Printing second element of Stream")
println("--------------------------------")
println(infStr(1))
println("Printing second element of Stream")
println("--------------------------------")
println(infStr(1))


//Creation of a Stream from another

var minfStr = infStr.map(x => x*x)
println("Printing third element of Stream")
println("--------------------------------")
println(minfStr(2))

println(minfStr(2))

def mapStr( x : Int) : Int = {
      println("Mapping Values")
      x*x
   } 

infStr = strFun(1)



minfStr = infStr.map(x => mapStr(x))




println(minfStr(2))

println(minfStr(2))


//Stream to List

//var ls = infStr.toList

var  strm = Stream(1,2,3,4,5)

var ls  =  strm.toList



//Apending one Stream to another

strm = Stream(1,2,3,4,5)


var strm1 =  Stream(6,7,8)

var astrm = strm.append(strm1)



//Length of a Stream
println("Printing Stream Leangth")
println("-----------------------")
println(astrm.length)

//Some mathematical function of Stream class
println("Printing Stream Summation")
println("-------------------------")
println(astrm.sum)
println("Printing Stream Maximum")
println("-----------------------")
println(astrm.max)
println("Printing Stream Minimum")
println("-----------------------")
println(astrm.min)



//Some more methods of Stream class

strm = Stream(1,2,3,4,5)
strm.count(x => x%2==0)
println("Printing Stream After Count")
println("---------------------------")
println(strm)

println(strm.find(x => x >3))


