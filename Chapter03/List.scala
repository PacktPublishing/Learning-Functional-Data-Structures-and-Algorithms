package com.fpdatastruct.lists

import scala.annotation.tailrec

object List extends App {

  sealed trait List[+A]
  case object Nil extends List[Nothing]
  case class ::[+A](head: A, tail: List[A]) extends List[A]

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else ::(as.head, apply(as.tail: _*))

  def head[A](list: List[A]): A = list match {
    case Nil => sys.error("tail of empty list")
    case x :: _ => x
  }

  def tail[A](list: List[A]): List[A] = list match {
    case Nil => sys.error("tail of empty list")
    case _ :: xs => xs
  }

  def drop[A](l: List[A], n: Int): List[A] =
    if (n <= 0) l
    else l match {
      case Nil => Nil
      case _ :: t => drop(t, n - 1)
    }

  def dropWhile[A](as: List[A])(f: A => Boolean): List[A] = as match {
    case x :: xs if f(x) => dropWhile(xs)(f)
    case _ => as
  }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case h :: t => ::(h, append(t, a2))
    }

  def appendElem[A](l: List[A], elem: A): List[A] = l match {
    case Nil => List(elem)
    case x :: xs => ::(x, appendElem(xs, elem))
  }

  def prepend[A](list: List[A], v: A) = list match {
    case Nil => ::(v, Nil)
    case x :: xs => ::(v, list)
  }

  @tailrec
  def elemAtIndex[A](l: List[A], i: Int): A = (l,i) match {
    case (Nil, _) => sys.error(s"index ${i} not valid")
    case (x :: xs, 0) => x
    case (x :: xs, _) => elemAtIndex(xs, i-1)
  }

  def setElem[A](l: List[A], i: Int, elem: A): List[A] = (l, i) match {
    case (Nil, _) => sys.error(s"index ${i} not valid")
    case (_ :: xs, 0) => ::(elem, xs)
    case (x :: xs, _) => ::(x, setElem(xs, i-1, elem))
  }

  val l = List(1, 2, 3) // calls apply
  println(tail(l))

}

