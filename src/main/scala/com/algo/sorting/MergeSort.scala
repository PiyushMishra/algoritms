package com.algo.sorting

import scala.annotation.tailrec

object MergeSort extends App {
  val numbers = Seq(24, 67, 89, 24, 5, 7, 456, 789, 34, 98, -1)

  def merge(left: Seq[Int], right: Seq[Int]) = {
    @tailrec
    def sort(left: Seq[Int], right: Seq[Int], result: Seq[Int]): Seq[Int] = {
      (left, right) match {
        case (xs, Nil) => result ++ xs
        case (Nil, ys) => result ++ ys
        case (xs, ys) => if (ys(0) < xs(0)) sort(xs, ys.tail, result.:+(ys(0))) else sort(xs.tail, ys, result.:+(xs(0)))
      }
    }
    sort(left, right, Seq())
  }

  def mergeSort(numbers: Seq[Int]): Seq[Int] = {
    numbers.length match {
      case 1 => numbers
      case x: Int =>
        val middle = numbers.length / 2
        val (leftHalf, rightHalf) = numbers.splitAt(middle)
        merge(mergeSort(leftHalf), mergeSort(rightHalf))
    }
  }

  print(mergeSort(numbers))
}
