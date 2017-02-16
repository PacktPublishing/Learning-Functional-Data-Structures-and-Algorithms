package com.fpdatastruct.deque

object Deque extends App {

  case class Deque(outLen: Int, out: Stream[Int], inLen: Int, in: Stream[Int], c: Int = 2) {
    def pushFront(elem: Int): Deque = {
      adjustStreams(outLen + 1, Stream.cons(elem, out), inLen, in, c)
    }

    def popFront(): (Int, Deque) = {
      out match {
        case Stream.Empty => throw new IllegalArgumentException("Empty queue")
        case x #:: newOut => (x, adjustStreams(outLen - 1, newOut, inLen, in, c))
      }
    }
  }

  def adjustStreams(outLen: Int, out: Stream[Int], inLen: Int, in: Stream[Int], c: Int): Deque = {
    if (outLen > c*inLen+1) {
      val newOutLen = (outLen+inLen)/2
      val newInLen  = outLen + inLen - newOutLen

      val newOut = out.take(newOutLen)
      val newIn = in append out.drop(newInLen).reverse

      Deque(newOutLen, newOut, newInLen, newIn, c)
    } else if (inLen > c*outLen+1) {
      val newInLen = (outLen+inLen)/2
      val newOutLen = outLen + inLen - newInLen

      val newIn = in.take(newInLen)
      val newOut = out append in.drop(newOutLen).reverse

      Deque(newOutLen, newOut, newInLen, newIn, c)
    } else
      Deque(outLen, out, inLen, in, c)
  }

  val dq = Deque(0, Stream.Empty, 0, Stream.Empty)
  val dq1 = dq.pushFront(1)
  val dq2 =  dq1.pushFront(2)
  val dq3 = dq2.pushFront(3)

  val (x,p) = dq3.popFront()
  println(x)

  val (y,p1) = p.popFront()
  println(y)

}

