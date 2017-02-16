

package mergeSort

object MergeSort {
  
  def split[T <% Ordered[T]](fl : List[T]) :(List[T], List[T]) = {
    if(fl == Nil){
      return(Nil,Nil)
    } 
	  val fv = fl.head
	  val ls1 = fl.tail
	  if (ls1 == Nil) {
 		   return(fv::Nil , Nil)
	  }
	  val sv = ls1.head
	  val ls2 = ls1.tail
	  val(tl1, tl2) = split(ls1.tail) 
	  return(fv::tl1, sv::tl2)
 }
  
  def merge [T <% Ordered[T]]( x: List[T], y : List[T]) : List[T] = (x,y) match {
  
    case (x, Nil) => x
    case (Nil,y) =>  y
    case( fm::fl, sm::sl) => if (fm > sm) sm::merge(x,sl)
                             else fm::merge(fl,y)
  }
  def mergeSort [T <% Ordered[T]] (ls :List[T]): List[T] = {
    if( ls == Nil || ls.tail == Nil)
      return ls
      
    val (fl,sl) = split(ls)
    val lsm1 = mergeSort(fl)
    val lsm2 = mergeSort(sl)
    merge(lsm1, lsm2)
 }
  
  
  def main(args: Array[String]) {
    
     val intData:List[Integer] = List(1,3,5,2,6)
     val (firstList, secondList) = split(intData)
     println(firstList)
     println(secondList)
     
     val firstSortedList: List[Integer] = List(1,3,5)
     val secondSortedList : List[Integer] = List(2,6)
     val mergedList :List[Integer] = merge(firstSortedList,secondSortedList)
     
     val sortedIntegers  = mergeSort(intData)
     println(sortedIntegers)
     
     val charData: List[String] = List("a","c","b","d")
     val (firstListChar, secondListChar) = split(charData)
     println(firstListChar)
     println(secondListChar)
     
     val firstSortedListChar: List[String] = List("a","c")
     val secondSortedListChar : List[String] = List("b","d")
     val mergedListChar :List[String] = merge(firstSortedListChar,secondSortedListChar)
     println(mergedListChar)
     
     val sortedInteger = mergeSort(intData)
     println(sortedInteger)
     
     val sortedString  = mergeSort(charData)
     println(sortedString)
   }
}