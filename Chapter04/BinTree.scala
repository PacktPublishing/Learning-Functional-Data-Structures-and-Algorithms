package com.fpdatastruct.bintree

object BinTree extends App {
  sealed trait BinTree[+A]
  case object Leaf extends BinTree[Nothing]
  case class Branch[A](value: A, left: BinTree[A], right: BinTree[A]) extends BinTree[A]

  def size[A](tree: BinTree[A]): Int = tree match {
    case Leaf => 0
    case Branch(_, l, r) => 1 + size(l) + size(r)
  }

  def depth [A](tree: BinTree[A]): Int = tree match {
    case Leaf => 0
    case Branch(_, l, r) => 1 + ( depth(l) max depth(r) )
  }

  def buildCompleteTree(v: Int, depth: Int): BinTree[Int] =
    if (depth == 0) Leaf
    else Branch(v, buildCompleteTree(2*v,  depth-1), buildCompleteTree(2*v+1,  depth-1))

  def buildTree[A](list: List[A]): BinTree[A] = list match {
    case Nil => Leaf
    case x :: xs => {
      val k = xs.length / 2
      Branch(x, buildTree(xs.take(k)), buildTree(xs.drop(k)))
    }
  }

  def flip[A](tree: BinTree[A]): BinTree[A] = tree match {
    case Leaf => Leaf
    case Branch(v, l, r) => Branch(v, flip(r), flip(l))
  }

  def equal[A](tree1: BinTree[A], tree2: BinTree[A]): Boolean = (tree1,
    tree2) match {
    case (Leaf, Leaf) => true
    case (Branch(v1, l1, r1), Branch(v2, l2, r2)) if v1 == v2 =>
      equal(l1, l2) && equal(r1, r2)
    case _ => false
  }

  def flippedEqual[A](tree1: BinTree[A], tree2: BinTree[A]): Boolean = (tree1,
    tree2) match {
    case (Leaf, Leaf) => true
    case (Branch(v1, l1, r1), Branch(v2, l2, r2)) if v1 == v2 =>
      flippedEqual(l1, r2) && flippedEqual(l2, r1)
    case _ => false
  }

  def preorder[A](tree: BinTree[A]): List[A] = tree match {
    case Leaf => Nil
    case Branch(v, l, r) => v :: (preorder(l) ++ preorder(r))
  }

  def inorder[A](tree: BinTree[A]): List[A] = tree match {
    case Leaf => Nil
    case Branch(v, l, r) => inorder(l) ++ ( v :: inorder(r))
  }

  def postorder[A](tree: BinTree[A]): List[A] = tree match {
    case Leaf => Nil
    case Branch(v, l, r) => postorder(l) ++ postorder(r) ++ List(v)
  }

  def preorderAcc[A](tree: BinTree[A], acc: List[A]): List[A] = tree match {
    case Leaf => acc
    case Branch(v, l, r) => {
      println(s"When at ${v} - acc = ${acc}")
      v :: preorderAcc(l, preorderAcc(r, acc))
    }
  }


  def inorderAcc[A](tree: BinTree[A], acc: List[A]): List[A] = tree match {
    case Leaf => acc
    case Branch(v, l, r) => inorderAcc(l, v :: inorderAcc(r, acc))
  }

  def postorderAcc[A](tree: BinTree[A], acc: List[A]): List[A] = tree match {
    case Leaf => acc
    case Branch(v, l, r) => postorderAcc(l, postorderAcc(r, v :: acc))
  }

  val tree = buildCompleteTree(1, 3)
  println(preorder(tree))
  println(preorderAcc(tree, List()))

}

