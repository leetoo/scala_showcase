::#!
@echo off
call scala %0 %*
goto :eof
:: This is a comment - To execute just type
::    C:\Path_to_this\> 01_simple_windows_script.bat 
:: on your windows console in this file Path
::!#


object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world! " + args.toList)
  }
}


HelloWorld.main(args)
