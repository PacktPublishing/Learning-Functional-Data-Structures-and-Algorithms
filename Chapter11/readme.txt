Compile the scala file

% scalac RBTree.scala

% scala
...

scala> import com.fpdatastruct.rbtrees.RBTree._
import com.fpdatastruct.rbtrees.RBTree._

scala>   val t = List(10, 20, 30, 40).foldLeft(end)((tree, elem) => insert(elem, tree))
t: com.fpdatastruct.rbtrees.RBTree.Tree = . 10 . 20 . 30 . 40 .

scala>   println(t)
. 10 . 20 . 30 . 40 .

