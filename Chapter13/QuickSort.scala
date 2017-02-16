

package quickSort

object QuickSort {
  //Method to get partition of a List at pivot location
  def partition[T <% Ordered[T]](elm : T, seq : List[T], fp :List[T], sp: List[T]): (List[T], List[T]) = seq match {
    case fe::fl => if (fe < elm) partition(elm, fl, fe::fp,sp)
                                 else 
                                  partition(elm,fl,fp,fe::sp)
    case Nil => (fp,sp)
    
  }
  
  def quickSort[T <% Ordered[T]](data : List[T]): List[T] = data match {
    case Nil => Nil
    case fv:: Nil => List(fv)
    case fv::fl => {
                     val (l1, l2) = partition( fv,fl, Nil,Nil)
                      val lfl = quickSort(l1)
                      val rhl = quickSort(l2)
                      val tmp = fv :: rhl
                      return lfl ++ tmp    
                   }
  }
  
// Main Function 
  def main(args: Array[String]) {     
       val intData1:List[Integer] = List(3,5,2,6)
        val elm : Integer= 4
     val (firstList, secondList) = partition(elm,intData1,Nil, Nil)
     println(firstList)
     println(secondList)
     
      val intData:List[Integer] = List(1,3,5,2,6)
      val sortedIntegers  = quickSort(intData)
     println(sortedIntegers)
     
      val charData: List[String] = List("a","c","b","d")
       val sortedString  = quickSort(charData)
     println(sortedString)
   }
}