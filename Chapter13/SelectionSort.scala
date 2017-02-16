

package selectionSort

object SelectionSort {
  def selectionSort[T <% Ordered[T]](data : List[T]): List[T] = data match {
    case Nil => Nil
    case fv::Nil => List(fv)
    case fv::fl => 
                   val minData = fl.min
                   val minIndex =  fl.indexOf(minData)
                   if(fv <= minData)
                     fv::selectionSort(fl) 
                   else{
                    val (fp,sp)= fl.splitAt(minIndex)
                    sp.head::selectionSort(fp:::fv::sp.tail)
                   }
                     
  }
  def main(args: Array[String]) {
    val intData:List[Integer] = List(1,3,5,2,6)
    val sortedIntegers  = selectionSort(intData)
    println(sortedIntegers)
     
    val charData: List[String] = List("a","c","b","d")
    val sortedString  = selectionSort(charData)
    println(sortedString)
   }
}