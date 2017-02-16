package com.fpdatastruct.rbtrees

object RBTree extends App {

  sealed trait Color

  case object Red extends Color

  case object Black extends Color

  sealed abstract class Tree {
    def color: Color
  }

  case class Node(color: Color, left: Tree, value: Int, right: Tree) extends Tree {
    override def toString = left.toString + " " + value.toString + " " + right.toString
  }

  case object End extends Tree {
    override def toString = "."

    override val color: Color = Black
  }

  def insert(v: Int, t: Tree): Tree = {
    def ins(s: Tree): Tree = s match {
      case End => Node(Red, End, v, End)
      case node@Node(_, left, value, right) =>
        val root = if (v < value) balance(node.copy(left = ins(left)))
        else if (v > value) balance(node.copy(right = ins(right)))
        else node
        root match {
          case node@Node(Red, _, _, _) => node.copy(color = Black)
          case _ => root
        }
    }
    ins(t)
  }

  def balance(ggParent: Node): Tree =
    ggParent match {
      case Node(Black, gParent@Node(Red, parent@Node(Red, ggChild1, _, ggChild2), _, gChild), _, child) =>
        gParent.copy(color = Red,
          left = parent.copy(color = Black),
          right = ggParent.copy(color = Black, left = gChild, right = child))
      case Node(Black, gParent@Node(Red, gChild, _, parent@Node(Red, ggChild1, _, ggChild2)), _, child) =>
        parent.copy(color = Red,
          left = gParent.copy(color = Black, right = ggChild1),
          right = ggParent.copy(color = Black, left = ggChild2, right = child))
      case Node(Black, child, _, gParent@Node(Red, gChild, _, parent@Node(Red, ggChild1,
      _, ggChild2))) => gParent.copy(color = Red,
        left = ggParent.copy(color = Black, left = child,
          right = parent.copy(color = Black)))
      case Node(Black, child, _, gParent@Node(Red, parent@Node(Red, ggChild1, _,
      ggChild2), _, gChild)) =>
        parent.copy(color = Red, left = ggParent.copy(color = Black, ggChild1),
          right = gParent.copy(color = Black, left = ggChild2))
      case _ => ggParent
    }

  def end: Tree = End

  val t = List(10, 20, 30, 40).foldLeft(end)((tree, elem) => insert(elem, tree))

  println(t)
}

