package insertionSort

object InsertionSort {
  //Function to insert element in sorted List part
   def insertElement[T <% Ordered[T]](elm : T , sorted : List[T]): List[T]= {
    if(sorted == Nil){
      return elm::sorted
    }
    val firstElement  :: tailElement = sorted
    if (firstElement < elm)
      firstElement :: insertElement(elm,tailElement)
    else
      elm :: sorted
  }
  // Method for Insertion Sorting 
  def insertionSort[T <% Ordered[T]](data : List[T]) : List[T] = {
    if(data == Nil)
        data
    else{
        val firstElement = data.head 
        val tailElement = data.tail
        val temp  = insertionSort(tailElement)
        insertElement(firstElement, temp)
    }
  } 
  
  def main(args: Array[String]) {
     val ls : List[Integer] = List(1,4,5)
     val v : Integer= 3
     val insertedList =  insertElement(v,ls)
     println(insertedList)
     val intData:List[Integer] = List(1,3,5,2,6)
     val sortedIntegers  = insertionSort(intData)
     println(sortedIntegers)
     
     
     val charData: List[String] = List("a","c","b","d")
     val sortedString  = insertionSort(charData)
     println(sortedString)
   }
}