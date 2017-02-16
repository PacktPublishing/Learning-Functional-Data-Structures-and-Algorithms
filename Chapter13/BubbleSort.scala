

package bubbleSort

object BubbleSort {
  
  def getLargest[T <% Ordered[T]](data : List[T]): (T,List[T]) = {
    
     val fv = data.head
     val fl = data.tail
     if(fl == Nil)
       return (fv,Nil)
     val (fd, lso) = getLargest(fl)
     if(fd >= fv)
       (fd ,fv::lso)
     else
       (fv, fd :: lso)
  }
  
  def bubbleSort[T <% Ordered[T]](data : List[T]) : List[T] = data match {
    case Nil => Nil
    case _ => 
              val (fv, sl) = getLargest(data)
               bubbleSort(sl):::List(fv)
  }
  
  def main(args: Array[String]) {
   
     val intData:List[Integer] = List(1,3,5,2,6)
     val largestInteger = getLargest(intData)
     println(largestInteger)
     
     val sortedIntegers  = bubbleSort(intData)
     println(sortedIntegers)
     
     
     val charData: List[String] = List("a","c","b","d")
     val largestCharacter = getLargest(charData)
     println(largestCharacter)
     
     val sortedString  = bubbleSort(charData)
     println(sortedString)
     
   }
}