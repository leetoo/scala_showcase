::#!
@echo off
call scala %0 %*
goto :eof
::!#


/**
* Examples based on:
*
* https://twitter.github.io/scala_school/collections.html
* http://www.tutorialspoint.com/scala/scala_options.htm
* http://www.javamexico.org/blogs/ezamudio/el_poder_de_option_mas_alla_del_pattern_matching
*
**/
object FunctionlCombinatorsExample {
  def main(args: Array[String]) {

    collectionExamples

    //List Collection Manage Examples Function
    listExamplesFunction

    //set Collection Manage Examples Function
    setExamplesFunction

    //Tuple Collection Manage Examples Function
    //tupleExamplesFunction

    //Map Collection Manage Examples Function
    mapExamplesFunction

  }
}

FunctionlCombinatorsExample.main(args)



def collectionExamples = {

   val a:Option[Int] = Some(5)
   val b:Option[Int] = None

   println("a.isEmpty: " + a.isEmpty )
   println("b.isEmpty: " + b.isEmpty )

   println( "a.getOrElse(0): " + a.getOrElse(0) )
   println( "b.getOrElse(10): " + b.getOrElse(10) )

}

def listExamplesFunction:Unit = {
  val numberList = List(1, 2, 3, 4)
  println("LIST: numberList._1: " + numberList.lift(1))
  println("LIST: numbers.map((i: Int) => i * 2): " +numberList.map((i: Int) => i * 2)) //example of map Combinators
  def timesTwo(i: Int): Int = i * 2
  println("LIST: numberList.map(timesTwo): " + numberList.map(timesTwo)) //example of map combinator using a function
  println("LIST: numberList.foreach((i: Int) => i * 2): " + numberList.foreach((i: Int) => i * 2)) //example of foreach combinator
  println("LIST: numberList.filter((i: Int) => i % 2 == 0): " + numberList.filter((i: Int) => i % 2 == 0)) //example of fliter combinator

}

def setExamplesFunction:Unit = {

  val numberSet = Set(3, 9, 5, 4, 4, 2, 4, 3)
  println("SET: numberSet._1: " + numberSet)  // get elements of set
  println("SET: numberSet._1: " + numberSet(2))  //check if 2 is in set: true
  println("SET: numberSet._1: " + numberSet(10)) //check if 10 is in set: false

}

def tupleExamplesFunction:Unit = {
  val hostPortTuple = ("localhost", 80)
  println("TUPLE: hostPortTuple._1: " + hostPortTuple._1)
}

def mapExamplesFunction:Unit = {

  val map = Map("N1" -> "Andrés", "N2"->"Francisco")
  println("MAP: map.get('N1'): " + map.get("N1"))
  println("MAP: map.get('N2'): " + map.get("N2"))
  println("MAP: map.get('N1').map(_.length): " + map.get("N1").map(_.length))

  map.get("N1").map(_.toUpperCase).map(_.reverse) match {
    case Some(s) => println("MAP: " + s) //Aqui la cadena ya viene transformada
    case None => println("MAP:  no hay cadena")
  }

}
