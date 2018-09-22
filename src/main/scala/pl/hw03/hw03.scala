package pl.hw03

object hw03 extends App {

  // Problem 1: Short-circuit Evaluation
  
  // implements 'e1 && e2'
  def and(e1: => Boolean, e2: => Boolean): Boolean = {
    ???
  }
  
  // implements 'e1 || e2'
  def or(e1: => Boolean, e2: => Boolean): Boolean = {
    ???
  }
  
  // Problem 2: Newton's Method
  
  def cubicRoot(c: Double, epsilon: Double): Double = {
    require (c >= 0) // makes sure that we don't call cubicRoot with negative values
    require (epsilon >= 0) // the error bound should also be positive

    // Replace the ??? with your implementation of Newton's Method
    
    var xn: Double = ??? // insert appropriate value to initialize xn
    
    ??? 
    
    return xn
  }

  // Problem 3: Binary Search

  def isStrictlySorted(a: Array[Int]): Boolean = {
    require (a != null) // make sure that 'a' is non-null

    ???
  }

  def binarySearch(x: Int, a: Array[Int]): Int = {
    require (a != null && isStrictlySorted(a)) // make sure that 'a' is non-null and sorted

    ???

  }
  
  // Add testing code here, or better yet, add them as additional unit tests to test/scala/pl/hw03/hw03Spec.scala
  
  // Examples:
  // println(cubicRoot(27, 0.0001))
  // println(isStrictlySorted(Array(1, 2, 3)))
  // println(binarySearch(2, Array(1, 3, 4)))
}
