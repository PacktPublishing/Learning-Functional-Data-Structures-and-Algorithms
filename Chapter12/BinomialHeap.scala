package com.fpdatastruct.binomealheaps

import com.fpdatastruct.binomealheaps.BinomialHeap.Node


object BinomialHeap extends App {
  case class Node(rank: Int, v: Int, children: List[Node])

  def linkUp(t1: Node, t2: Node) =
    if (t1.v <= t2.v)
      Node(t1.rank+1, t1.v, t2 :: t1.children)
    else
      Node(t1.rank+1, t2.v, t1 :: t2.children)

  def insert(t: Node, rootList: List[Node]): List[Node] = rootList match {
    case Nil => List(t)
    case x :: xs if (t.rank < x.rank) => t :: rootList
    case x :: xs => insert(linkUp(t, x), xs)
  }

  def insertElem(rtList: List[Node], elem: Int) = {
    insert(Node(0, elem, Nil), rtList)
  }

  def merge(ts1: List[Node], ts2: List[Node]): List[Node] = (ts1, ts2) match {
    case (ts1, Nil) => ts1
    case (Nil, ts2) => ts2
    case (t1 :: ts11, t2 :: ts22) if (t1.rank < t2.rank) => t1 :: merge(ts11, ts2)
    case (t1 :: ts11, t2 :: ts22) if (t2.rank < t1.rank) => t2 :: merge(ts1, ts22)
    case (t1 :: ts11, t2 :: ts22) => insert(linkUp(t1, t2), merge(ts11, ts22))
  }

  def findMin(rootList: List[Node]): Node = rootList min (Ordering.by((p: Node) => p.v))

  def removeMin(rootList: List[Node]): List[Node] = {
    val min = findMin(rootList)
    val listExceptMin = rootList filterNot(_ == min)
    merge(listExceptMin, min.children)
  }

  val list = List(13, 12, 24, 4, 15, 28, 21, 9, 11, 17, 32, 14, 20, 41, 30)

  val v = list.foldLeft[List[Node]](List[Node]())(insertElem)

  val min = findMin(v)

  println(min.v)

  val v1 = removeMin(v)

  val min1 = findMin(v1)

  println(min1.v)

}


