/**
*  How to use:
*  $ scala ScalaUsingJavaClass.scala
*
*  Description:
*   The scala script use a compiled ./com/molavec/greet/Greet.class
*  to say Hi!!
*
**/
import _root_.com.molavec.greet.Greet

object ScalaUsingJavaClass{
  def main(args: Array[String]) {

    var greet01 = new Greet;
    var greet02 = new Greet("hola mundo");

    greet01.printToConsole();
    greet02.printToConsole

    greet01.setGreet("hiho")
    greet02.setGreet("hahu")


    greet01.printToConsole();
    greet02.printToConsole

    var str1: String = greet01.getGreet
    var str2 = greet01.getGreet();

    println(str1)
    println(str2)

  }
}
