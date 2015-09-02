::#!
@echo off
call scala %0 %*
goto :eof
::!#

/**
* More Info: http://nerd.kelseyinnis.com/blog/2013/11/12/idiomatic-scala-the-for-comprehension/
**/
object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world! " + args.toList)
  }
}


HelloWorld.main(args)
