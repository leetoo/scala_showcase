#!/bin/sh
exec scala "$0" "$@"
!#
#------ Preamble end  and scala code start ----

# TODO: Test this script

object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world! " + args.toList)
  }
}

# esto es un comentario
HelloWorld.main(args)
