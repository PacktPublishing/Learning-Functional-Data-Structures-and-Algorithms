// Written by Raju
// Run it using following command
// scala memoization.scala

val ab = scala.collection.mutable.ArrayBuffer(1,2,3,4)  // Line one
print(ab.remove(1))  // Line Two
print(ab.remove(1)) // Line Three
print(ab.remove(1)) // Line Four


class Multiply {
     	       def mult(num: Int) : Int = num*2
     	 }

val myMult = new Multiply()  //Line One
print(myMult.mult(4))  //Line Two
print(myMult.mult(4))  //Line three

//Memoization in Scala
class SimpleFactorial{
    def simpleFactFun(num : Int) : Int ={
    	if(num == 0 || num == 1)
    		1
    	else{
		println("Calculating Factorial")
    		num*simpleFactFun(num-1)
     	    }
    }
}

val simpleFact = new SimpleFactorial()
var factValue = simpleFact.simpleFactFun(5)

factValue = simpleFact.simpleFactFun(5)

class MemoizedFactorial{
    var memoized : Map[Int,Int] = Map()

    def lookupFunction(id : Int) :Int = memoized.getOrElse(id,0)

    def memoizedFactFun(num : Int) : Int ={
    	if(num == 0 || num == 1)
    		1
     	else if (lookupFunction(num) > 0)
     		lookupFunction(num)
    	else{
    		val fact = num*memoizedFactFun(num-1)
		println("In memoizing part")
    		memoized += num -> fact
     		fact
     	    }
    }

}


var memFact =  new MemoizedFactorial()

factValue = memFact.memoizedFactFun(5)

factValue = memFact.memoizedFactFun(5)

factValue = memFact.memoizedFactFun(4)

factValue = memFact.memoizedFactFun(3)

