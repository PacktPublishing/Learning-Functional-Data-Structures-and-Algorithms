Compile List.scala

% scalac List.scala
...

% scala
...

scala> import com.fpdatastruct.lists._
import com.fpdatastruct.lists._

scala> import com.fpdatastruct.lists.List._
import com.fpdatastruct.lists.List._

scala> val l = List(1, 2, 3)
l: com.fpdatastruct.lists.List.List[Int] = ::(1,::(2,::(3,Nil)))

scala> println(tail(l))
::(2,::(3,Nil))

You can play with other list functions now
