::#!
@echo off
call scala %0 %*
goto :eof
::!#

/**
* CLASS TYPE 1: Class without parameter in constructor
**/
class Room{

  /** --- CONSTRUCTOR START ---**/
  //"val" can not be change
  val notDisturbMessage: String = "Do not enter!! I learning Scala!!"
  val freeMessage: String = "Knock before enter!!"

  //you can change their values
  var isBussy: Boolean = false
  var ownerName: String = "No Owner"

  /** --- COSNTRUCTOR END ---**/

  //define a function
  val defineRoomOwer = { (owner:String) => ownerName = owner }

  //define a methods
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
* CLASS TYPE 3: Class with several constructors using curried
**/
//TODO: implement it

object SimpleClassExample {
  def main(args: Array[String]) {

    //Class without parameter in constructor
    val room = new Room
    room.printGreet
    room.isBussy = true
    room.defineRoomOwer("Miguel")
    println("Room owner: " + room.ownerName +
          " | Room state: " + room.getSignboardMessage)

    //Class with parameter in constructor
    val wall = new Wall("black")
    println(wall.colorClassVal)

    //Parameters do not work as val.
    //println(wall.color)
  }
}

SimpleClassExample.main(args)
