#!/bin/sh
exec scala "$0" "$@"
!#
#------ Preamble end  and scala code start ----

# TODO: Test this script

/**
* CLASS TYPE 1: Class without parameter in constructor
**/
class Room{

  //'val' can not be change
  val notDisturbMessage: String = "Do not enter!!"
  val freeMessage: String = "Knock before enter!!"

  //you can change it
  var isBussy: Boolean = false

  /** --- COSNTRUCTOR END ---**/
  //define a method
  def printGreet(): Unit = println("Welcome to Room")
  def getSignboardMessage: String = if(isBussy) notDisturbMessage else freeMessage

}

/**
* CLASS TYPE 2: Class with parameter in constructor
**/
class Wall(color: String) {
  /** --- CONSTRUCTOR START ---**/
  val colorClassVal:String = if (color == "red") {
    "RED"
  } else if (color == "black") {
    "BLACK"
  } else {
    "WHITE"
  }
}

/**
* CLASS TYPE 3: Class with several constructors
**/
//TODO: implement it

object SimpleClassExample {
  def main(args: Array[String]) {

    //Class without parameter in constructor
    val room = new Room
    room.printGreet
    room.isBussy = true
    println(room.getSignboardMessage)

    //Class with parameter in constructor
    val wall = new Wall("black")
    println(wall.colorClassVal)

    //Parameters do not work as val.
    //println(wall.color)
  }
}

SimpleClassExample.main(args)
