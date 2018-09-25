# Homework 3 (20 Points)

The deadline for Homework 3 is Saturday, September 29, 6pm. The late
submission deadline is Thursday, October 4, 6pm.

## Getting the code template

This homework assumes that you have already accepted the invitation to join
the [GitHub organization for the course](https://github.com/nyu-pl-fa18). If
you have not received an invitation, then you either haven't told us
your GitHub username yet or you haven't completed the consent form. In this
case, please contact us immediately and provide the requested
information so that we can send you an invitation.

Here are some Git-related resources:
* If you are unfamiliar with Git, watch the [first two git basics video](http://git-scm.com/videos).
* If you are unfamiliar with Github, watch [this YouTube video](https://www.youtube.com/watch?v=0fKg7e37bQE).
* A [simple git cheatsheet](http://rogerdudler.github.io/git-guide/).
* A [complete reference](http://www.git-scm.com/book/en/v2).
* I suggest using the command line or the IntelliJ integration to interact with Git, but in a pinch [this GUI](https://desktop.github.com/) might be useful.

Before you perform the next steps, you first need to create your own
private copy of this git repository. To do so, click on the link
provided in the announcement of this homework assignment on
Piazza. After clicking on the link, you will receive an email from
GitHub, when your copy of the repository is ready. It will be
available at
`https://github.com/nyu-pl-fa18/hw3-<YOUR-GITHUB-USERNAME>`.  
Note that this may take a few minutes.

* Open a browser at `https://github.com/nyu-pl-fa18/hw3-<YOUR-GITHUB-USERNAME>` with your Github username inserted at the appropriate place in the URL.
* Choose a place on your computer for your homework assignments to reside and open a terminal to that location.
* Execute the following git command: <br/>
  ```git clone https://github.com/nyu-pl-fa18/hw3-<YOUR-GITHUB-USERNAME>.git```<br/>
  ```cd hw3```

The code template for solving the exercises is provided in the file

```
src/main/scala/pl/hw3/hw03.scala
```

relative to the root directory of the repository. Follow the
instructions in the notes for Class 2 to import the project into
InteliJ (or use your other favorite IDE or editor to work on the assignment).

The file

```
src/test/scala/pl/hw3/hw03Spec.scala
```

contains unit tests that help you to ensure that the code that you
write is correct. You can run the unit tests directly from within
InteliJ: right-click on the file in the "Project" overview and choose
"Run 'hw03Spec'". After running the test suite, the IDE will show you
a summary indicating which tests failed (if any).

Alternatively, you can run the tests by executing the command `test`
in the sbt shell. You can do the latter either from within the IDE or
on the command line: open a terminal in the project directory and
execute `sbt`. When the prompt of the sbt shell appears type `test`.

Feel free to add additional test cases to the file
`hw03Spec.scala`. You can also add testing code at the end of object
`hw03` in the file `hw03.scala` (see the comment in the file
indicating where to put testing code). To run this code, right-click
on the file `hw03.scala` and select "Run 'hw03'". Alternatively,
execute the command `run` in the sbt shell, which has the same effect.

You can implement the solutions to all problems of this homework by
replacing the `???` expressions in `hw03.scala` with your code for the
corresponding problem. Please do not modify the signatures of the
given function definitions (i.e. do not change the names of these
functions, their arguments, or their return types).

## Submitting your solution

From now on, we will be using GitHub for submitting homework
solutions, which is more convenient than NYU classes for programming
assignments.

Once you have completed the assignment, you can submit your solution
by pushing the modified code template to GitHub. This can be done by
opening a terminal in the project's root directory and executing the
following commands in the :

```bash
git add .
git commit -m "solution"
git push
```

You can replace "solution" by a more meaningful commit message.

Refresh your browser window pointing at
```
https://github.com/nyu-pl-fa18/hw3-<YOUR-GITHUB-USERNAME>/
```
and double-check that your solution has been uploaded correctly.

You can resubmit an updated solution anytime by reexecuting the above
git commands. Though, please remember the rules for submitting
solutions after the homework deadline has passed.


## Problem 1: Short-circuit Evaluation (4 Points)

Neither Algol 60 nor Algol 68 employs short-circuit evaluation for
Boolean expressions. However, both languages support a form of
conditional expressions similar to Scala. Show how to use conditional
expressions in Scala to achieve the effect of short-circuit
evaluation. That is, give Scala expressions that behave exactly like
the Scala expressions

```scala
e1 && e2 // logical and
```

and

```scala
e1 || e2 // logical or
```

for all possible Boolean expressions `e1` and `e2`. Your solution is
only allowed to use Scala's conditional expressions and should only
refer to `e1` and `e2` as well as the Boolean constants `true` and
`false`. In particular, you should not use `||` and `&&`.

The code template contains two function definitions

```scala
def and(e1: Boolean, e2: Boolean): Boolean = {
  ???
}
```
and

```scala
def or(e1: Boolean, e2: Boolean): Boolean = {
  ???
}
```

Replace the `???` with your implementation of the corresponding operator.

## Problem 2: Newton's Method (6 Points)

In this exercise, we will implement a function that computes the cubic
root of a given floating point number. To do so, we will use Newton's
method (also known as Newton-Raphson).  Recall from Calculus that a
root of a differentiable function can be iteratively approximated by
following tangent lines. More precisely, let <img alt="f" src="http://latex.codecogs.com/gif.latex?f"> be a differentiable
function, and let <img alt="x_0" src="http://latex.codecogs.com/gif.latex?x_0"> be an initial guess for a root of <img alt="f" src="http://latex.codecogs.com/gif.latex?f">. Then,
Newton's method specifies a sequence of approximations <img alt="x_0, x_1, \dots" src="http://latex.codecogs.com/gif.latex?x_0%2C%20x_1%2C%20%5Cdots"> with the following recursive equation: 

<img alt="x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}" src="http://latex.codecogs.com/gif.latex?x_%7Bn&amp;plus;1%7D%20%3D%20x_n%20-%20%5Cfrac%7Bf%28x_n%29%7D%7Bf%27%28x_n%29%7D">

The cubic root of a real number <img alt="c" src="http://latex.codecogs.com/gif.latex?c"> for <img alt="c &gt; 0" src="http://latex.codecogs.com/gif.latex?c%20%3E%200">, written <img alt="\sqrt[3]{c}" src="http://latex.codecogs.com/gif.latex?%5Csqrt%5B3%5D%7Bc%7D">, is a positive <img alt="x" src="http://latex.codecogs.com/gif.latex?x"> such that <img alt="x^3 = c" src="http://latex.codecogs.com/gif.latex?x%5E3%20%3D%20c">.
Thus, to compute the cubic root of a number <img alt="c" src="http://latex.codecogs.com/gif.latex?c">, we want to find the
positive root of the function: 

<img alt="f(x) = x^3 - c" src="http://latex.codecogs.com/gif.latex?f%28x%29%20%3D%20x%5E3%20-%20c">

It follows from Newton's method that the following recursive equation defines a sequence of
approximations for the cubic root of <img alt="c" src="http://latex.codecogs.com/gif.latex?c">

<img alt="x_{n+1} = \frac{c / x_n^2 + 2 x_n}{3}"
src="http://latex.codecogs.com/gif.latex?x_%7Bn&amp;plus;1%7D%20%3D%20%5Cfrac%7Bc%20/%20x_n%5E2%20&amp;plus;%202%20x_n%7D%7B3%7D">

Implement a function `cubicRoot`

```scala 
def cubicRoot(c: Double, epsilon: Double): Double 
``` 
that computes
the approximations <img alt="x_n" src="http://latex.codecogs.com/gif.latex?x_n"> of the cubic root of <img alt="c" src="http://latex.codecogs.com/gif.latex?c"> until the approximation error is below <img alt="\epsilon" src="http://latex.codecogs.com/gif.latex?%5Cepsilon"> (epsilon), that is
     
   <img alt="|x_n^3 - c| < \epsilon"
   src="http://latex.codecogs.com/gif.latex?%7Cx_n%5E3%20-%20c%7C%20%3C%20%5Cepsilon">
   
holds. You can use the function `math.abs` from the Scala standard library to
compute the absolute value of a `Double` value. Use a while loop to
compute the approximations one step at a time.

## Problem 3: Binary Search (4 + 6 Points)

The Scala type `Array[Int]` represents arrays that store integer
values. For instance, you can create an array that stores the integer
values `1`, `2`, and `3` by writing `Array(1,2,3)`. The elements of
an array `a` are indexed from `0` to `a.length-1` where `a.length` is
the length of `a`. To retrieve the value of `a` at index `i`, you
write `a(i)`. For example, if `a` is `Array(1,2,3)` then `a.length` is
`3`, `a(0)` is `1`, and `a(2)` is `3`. Scala arrays are
*bounds-checked*, i.e., when you try to access an index `i` that is
outside of the interval `[0,a.length)`, then an exception will be thrown.

The goal of this exercise is to implement a function 

```scala
  def binarySearch(x: Int, a: Array[Int]): Int
```

that searches for an integer value `x` in an integer array `a`
using binary search. Binary search solves this problem by keeping track
of a range within the array in which `x` must be if it is anywhere in
the array. Initially, the range is the entire array.  The range is
shrunk by comparing its middle element to `x` and discarding half the
range. The process continues until `x` is discovered in the array or
until the range in which it must lie is known to be empty.

We implement a variant of this algorithm that works on strictly sorted
arrays and can be used, e.g., in the implementation of B-trees.

As a warm-up, implement a function

```scala
def isStrictlySorted(a: Array[Int]): Boolean
```

that uses a while loop to check whether `a` is strictly sorted in
increasing order. We will use this function to ensure that
`binarySearch` is only called on arrays that are properly sorted.

Now implement `binarySearch` itself. The function should return an integer
`i` such that:

* `i` is the smallest index `i` such that `a(i)` is greater or equal
  to `x` if such an index exists within the bounds of `a`.
  
* otherwise (i.e. if all elements of `a` are smaller than `x`), `i`
  should be equal to `a.length`.

Implement the function using a while loop.

The following is a useful suggestion but not a graded part of this
exercise:

Jon Bentley conducted an experiment where he asked more than a hundred
professional programmers to implement binary search. He found that
only about 10% got it right the first time, without testing. Are you
up for a challenge? 

Write down the *loop invariant* of your binary search
implementation. A loop invariant is a condition that is true before
the loop body is executed in each iteration of the loop, as well as
after the loop exits. Think of an invariant that captures the key
properties of your implementation that are maintained in each
iteration of the while loop:

* What properties do the variables satisfy that store the two indices
  bounding the remaining range?

* How does the value of `x` relate to the values stored in the array
  (inside and outside of the remaining range)?

* ...

Carefully think about all corner cases. Run your code only after you
convinced yourself that your solution is correct.  Are you one of
Bentley's glorious 10%? If not, don't worry. If one of the unit tests
that I have provided or one of your own tests fails, think about how
that test input relates to the invariants you came up with. Did you
forget an important property in your invariant? E.g. did you miss a
corner case?  Is one of your properties not a correct loop invariant?
Use this analysis to debug your code (and your invariant).

Hint: you can write *assertions* in your code that test whether your
properties are loop invariants. For instance, if you store the left
bound of the range in the variable `l`, one of your invariants could
say that `l` should always be positive. You can check this by adding
the statement

```scala
assert(0 <= l)
```

at the beginning of the body of your while loop. If the property is
violated in any loop iteration when you run your tests, an exception
will be thrown.
