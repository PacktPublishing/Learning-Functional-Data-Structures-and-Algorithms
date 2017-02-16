package com.fpdatastruct.deque

import scala.collection.SeqView

object LazyQueue extends App {

  case class LazyQueue(out: Stream[Int], outLen: Int, in: List[Int], inLen:
  Int) {

    def push(elem: Int) = {
      makeLazyQueue(out, outLen, elem :: in, inLen + 1)
    }

    def pop: (Int, LazyQueue) = {
      (out.head, makeLazyQueue(out.tail, outLen - 1, in, inLen))
    }

    def empty = out.isEmpty && in.isEmpty
  }

  def makeLazyQueue(out: Stream[Int], outLen: Int, in: List[Int], inLen: Int): LazyQueue
  = if (inLen <= outLen) {
    LazyQueue(out, outLen, in, inLen)
  } else {
    val newOutStream = copyInToOut(out, in, Stream.empty)
    val newOutSize = outLen + inLen
    val newInList = Nil
    val newInSize = 0

    LazyQueue(newOutStream, newOutSize, newInList, newInSize)
  }

  def copyInToOut(out: Stream[Int], in: List[Int], revIn: Stream[Int]): Stream[Int] = {
    in match {
      case Nil => Stream.empty
      case x :: xs if out.isEmpty => Stream.cons(x, revIn)
      case x :: xs =>
        Stream.cons(out.head, copyInToOut(out.tail, in.tail,
          Stream.cons(x,
            revIn)))

    }
  }

  val emptyQ = makeLazyQueue(Stream.empty, 0, Nil, 0)
  val q = List(10, 20, 30).foldLeft(emptyQ)((acc, x) => acc.push(x))

  val (a1, q1) = q.pop
  println(s"a1 = ${a1}, q1 = ${q1}")

  val (a2, q2) = q1.pop
  println(s"a2 = ${a2}, q1 = ${q2}")

  val (a3, q3) = q2.pop
  println(s"a3 = ${a3}, q1 = ${q3}")

}

