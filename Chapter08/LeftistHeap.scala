package com.fpdatastruct.queue

object LeftistHeap extends App {
  sealed abstract class TreeNode {
    def rank: Int
  }

  case class Node(rank: Int, v: Int, left: TreeNode, right: TreeNode)
    extends TreeNode

  case object Leaf extends TreeNode {
    override val rank = 0
  }

  def makeNode(v: Int, left: TreeNode, right: TreeNode): Node =
    if (left.rank >= right.rank) Node(left.rank + 1, v, left, right)
    else Node(right.rank + 1, v, right, left)

  def merge(node1: TreeNode, node2: TreeNode): TreeNode = (node1, node2) match {
    case (node1, Leaf) => node1
    case (Leaf, node2) => node2
    case (Node(_, x, a1, b1), Node(_, y, a2, b2)) => {
      if (x < y) makeNode(x, a1, merge(b1, node2))
      else makeNode(y, a2, merge(node1, b2))
    }
  }

  def insert(v: Int, h: TreeNode): TreeNode = {
    val singleTree = makeNode(v, Leaf, Leaf)
    merge(singleTree, h)
  }

  def min (h:TreeNode): Int = h match {
    case Leaf => throw new IllegalArgumentException("Empty tree")
    case (Node(_, x, _, _)) => x
  }

  def pop(h:TreeNode): (Int, TreeNode) = h match {
    case Leaf => throw new IllegalArgumentException("Empty tree")
    case (Node(_, x, a, b)) => (x, merge(a, b))
  }

  def empty: TreeNode = Leaf

  val q = List(1, 2, 3, 4, 5).foldLeft(empty)((a, b) => insert(b, a))

  val (one, q1) = pop(q)
  println(one)

  val (two, q2) = pop(q1)
  println(two)

}

