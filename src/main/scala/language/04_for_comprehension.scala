/**
* More Info:
*
* http://nerd.kelseyinnis.com/blog/2013/11/12/idiomatic-scala-the-for-comprehension/
* http://debasishg.blogspot.cl/2008/03/monads-another-way-to-abstract.html
*
**/
object HelloWorld {
  def main(args: Array[String]) {
    val first = List("a", "b")
    val next = List("*", "#")
    val last = List("x", "y", "z")


    //for-yield example
    val returnList1 = for {
      i <- first
      j <- next
      k <- last
    }
    yield(i + j + k)

    println("returnList1: " + returnList1)

    //same could be done with flatMap
    val returnList2 = first flatMap {
      i => next flatMap {
        j => last map {
          k => i + j + k
        }
      }
    }
    println("returnList2: " + returnList2)



    }


}

HelloWorld.main(args)
