#!/bin/sh
exec scala "$0" "$@"
# This is a comment - To execute just type
#     $ bash 01_simple_unix_script.scala
# on your windows console in this file Path
!#


object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world! " + args.toList)
  }
}

HelloWorld.main(args)
