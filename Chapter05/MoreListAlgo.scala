package com.fpdatastruct.morelistalgo

object MoreListAlgo extends App {
  def carry(c: Int, list: List[Int]):List[Int] = (c, list) match {
    case (0, xs) => xs
    case (1, Nil) => List(1)
    case (1, x :: xs) => (1 - x) :: carry(x, xs)
    case (_, _) => throw new IllegalArgumentException("Invalid input!!!")
  }

  def add(c: Int, ps: List[Int], qs: List[Int]): List[Int] = (ps, qs) match {
    case (Nil, Nil) => carry(c, Nil)
    case (Nil, _ :: _) => carry(c, qs)
    case (_ :: _, Nil) => carry(c, ps)
    case (x::xs, y::ys) => ((c+x+y) % 2) :: add((c+x+y)/2, xs, ys)
  }

  def addNums(first: List[Int], second: List[Int]): List[Int] = {
    val result = add(0, first.reverse, second.reverse)
    result.reverse
  }

  def mult(first: List[Int], second: List[Int]): List[Int] = {
    def multiply(ps: List[Int], qs: List[Int]): List[Int] = (ps) match {
      case Nil => Nil
      case 0 :: xs => 0 :: multiply(xs, qs)
      case 1 :: xs => add(0, qs, 0::multiply(xs, qs))
    }
    val result = multiply(first.reverse, second.reverse)
    result.reverse
  }

  val k = carry(1, List(1, 1, 0, 1))

  println( addNums(List(1, 0, 1, 1), List(1, 1, 1, 1, 0)) )
  println( addNums(List(1, 0), List(1, 0)) )
  println( addNums(List(1, 0, 1), List(1, 0, 0)) )
  println( addNums(List(1, 0, 0), List(1, 0, 1)) )

  println( mult(List(1, 1), List(1, 1, 1, 1)) )
  println( mult(List(1, 1, 1), List(1, 0, 1)) )
}

