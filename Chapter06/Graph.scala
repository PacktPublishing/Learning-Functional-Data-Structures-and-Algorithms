package com.fpdatastruct.functionalalgo

object Graph extends App {
  import scala.annotation.tailrec

  def succSet(a: String, g: List[(String, String)]): List[String] = g match {
    case Nil => Nil
    case x :: xs if (a == x._1) => x._2 :: succSet(a, xs)
    case _ :: xs => succSet(a, xs)
  }

  def depthFirst(initial: String, g: List[(String, String)]) : List[String] = {
    def depthf(nodes: List[String], visited: List[String]): List[String] = nodes match {
      case Nil => visited
      case x :: xs if visited.contains(x) => depthf(xs, visited)
      case x :: xs => depthf(succSet(x, g) ++ xs, x::visited)
    }

    val result = depthf(List(initial), List())
    result.reverse
  }

  def depthFirst1(initial: String, g: List[(String, String)]) : List[String] = {

    def depthf(nodes: List[String], visited: List[String]): List[String] = nodes match {
      case Nil => visited
      case x :: xs => depthf(xs,
        if (visited.contains(x)) visited
        else depthf(succSet(x, g), x::visited))
    }

    val result = depthf(List(initial), List())
    result.reverse
  }

  def topsort(g: List[(String, String)]) = {
    def sort(nodes: List[String], visited: List[String]): List[String] = nodes match {
      case Nil => visited
      case x :: xs => sort(xs,
        if (visited.contains(x)) visited
        else x :: sort(succSet(x, g), visited))
    }

    val (start, _) = g.unzip
    val result = sort(start, List())
    result
  }

  def topsortWithCycle(g: List[(String, String)]) = {
    def sort(nodes: List[String], path: List[String], visited: List[String]):
    List[String] = nodes match {
      case Nil => visited
      case x :: xs if path.contains(x) =>
        throw new RuntimeException("Cycle detected")
      case x :: xs => sort(xs, path,
        if (visited.contains(x)) visited
        else x :: sort(succSet(x, g), x :: path, visited))
    }

    val (start, _) = g.unzip
    val result = sort(start, List(), List())
    result
  }

  type VC = (List[String], List[String])

  def addToVisited(x: String, v: VC) = (x :: v._1, v._2)

  def topsortPrintCycle(g: List[(String, String)]) = {
    def sort(nodes: List[String], path: List[String],
             visited: VC): VC = nodes match {
      case Nil => visited
      case x :: xs =>
        val (v, c) = visited
        sort(xs, path,
          if (path.contains(x)) (v, x::c)
          else if (v.contains(x)) visited
          else addToVisited(x, sort(succSet(x, g), x :: path, visited))
        )
    }

    val (start, _) = g.unzip
    val result = sort(start, List(), (List(), List()))
    result
  }

  val graph = List(("m", "n"), ("m", "o"), ("m", "p"),
    ("n", "q"), ("o", "r"), ("p", "q"),
    ("q", "r"), ("q", "s"))

  val nodes = depthFirst1("m", graph)
  println(nodes)

  val grwork = List(("getup","shower"),
    ("shower", "breakfast"),
    ("breakfast","dress"),
    ("dress","office"),
    ("office", "dinner"),

    ("breakfast","leisurely_lunch"),
    ("leisurely_lunch", "movie"),
    ("movie", "dinner"))

  val topsorted = topsortPrintCycle(("dinner", "movie") :: grwork)
  println(topsorted)
}

