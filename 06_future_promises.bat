::#!
@echo off
call scala %0 %*
goto :eof
::!#

/**
* More info: http://docs.scala-lang.org/overviews/core/futures.html
**/
object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world! " + args.toList)
  }
}


HelloWorld.main(args)
