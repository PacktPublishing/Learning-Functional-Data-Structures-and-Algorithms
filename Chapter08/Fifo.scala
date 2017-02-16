package com.fpdatastruct.queue

object Fifo extends App {

  case class Fifo(out: List[Int], in: List[Int]) {
    def check(): Boolean = (out, in) match {
      case (Nil, x :: xs) => false
      case _ => true
    }
    require(check, "Invariant Failed - out.em")
  }

  def push(e: Int, queue: Fifo): Fifo = {
    val newIn = e :: queue.in
    queue.out match {
      case Nil => Fifo(newIn.reverse, Nil)
      case _ => queue.copy(in = newIn)
    }
  }

  def pop(queue: Fifo): (Int, Fifo) = {
    queue.out match {
      case Nil => throw new IllegalArgumentException("Empty queue");
      case x :: Nil => (x, queue.copy(out = queue.in.reverse, Nil))
      case y :: ys => (y, queue.copy(out = ys))
    }
  }

//  val q = push(3, push(2, push(1, Fifo(Nil, Nil))))
  val q = List(1,2,3).foldLeft(Fifo(Nil, Nil))((q, e) => push(e, q))

  val (one, q1) = pop(q)
  println(one)

  val (two, q2) = pop(q1)
  println(two)
}

