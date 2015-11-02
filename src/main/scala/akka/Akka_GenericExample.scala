import akka.actor.{ ActorRef, ActorSystem, Props, Actor, Inbox }
import scala.concurrent.duration._

// se  definen los mensajes

case object Greet //asks the Actor for latest greeting  - Solicita el último saludo
case class WhoToGreet(who: String) //redefines the new greeting - redefine a quien saludar
case class Greeting(message: String)  // returns the latest greeting - retorna el último saludo


//define al actor
class Greeter extends Actor {
  var greeting = ""

  def receive = {
    case WhoToGreet(who) => greeting = s"hello from scala, $who"
    case Greet           => {
                    //println("Dentro de Greeter(Greet)")
                    //Thread.sleep(5.seconds.fromNow.timeLeft.toMillis)
                    sender ! Greeting(greeting) // Send the current greeting back to the sender
                    }
  }
}

// prints a greeting
class GreetPrinter extends Actor {
  def receive = {
    case Greeting(message) => println(message)
  }
}


//Aplicación main
object Akka_GenericExample extends App {

  // Create the 'helloakka' actor system
  //println("system.type: " + system.getClass )
  val system = ActorSystem("helloakka")

  // Create the 'greeter' actor
  val greeter = system.actorOf(Props[Greeter], "greeter")
  println("greeter.type: " + greeter.getClass )

  // Create an "actor-in-a-box"
  val inbox = Inbox.create(system)

  // Tell the 'greeter' to change its 'greeting' message
  greeter.tell(WhoToGreet("akka"), ActorRef.noSender)

  // Ask the 'greeter for the latest 'greeting'
  // Reply should go to the "actor-in-a-box"
  inbox.send(greeter, Greet)

  // Wait 5 seconds for the reply with the 'greeting' message
  val Greeting(message1) = inbox.receive(50.seconds)
  val msn = message1 + "TEXTO_ADICIONAL"
  println(s"Greeting from Scala: $msn")

  // Change the greeting and ask for it again
  greeter.tell(WhoToGreet("typesafe"), ActorRef.noSender)
  inbox.send(greeter, Greet)
  val Greeting(message2) = inbox.receive(50.seconds)
  println(s"Greeting from Scala: $message2")

  system.shutdown


  //system.stop(greeter)
  //system.stop(GreetPrinter)

/*
  val greetPrinter = system.actorOf(Props[GreetPrinter])
  // after zero seconds, send a Greet message every second to the greeter with a sender of the greetPrinter
  system.scheduler.schedule(0.seconds, 1.second, greeter, Greet)(system.dispatcher, greetPrinter)
  */
}
