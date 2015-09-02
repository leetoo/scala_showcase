::#!
@echo off
call scala %0 %*
goto :eof
::!#


object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world! " + args.toList)
  }
}


HelloWorld.main(args)
