import akka.actor._
import scala.concurrent.duration._

object Akka_ReceiveTimeoutExample extends App{

  class MyActor extends Actor {
    // To set an initial delay
    context.setReceiveTimeout(Duration.Undefined)
    def receive = {
      case "Hello" =>
        // To set in a response to a message
        println("HELLO WORLD!!")
        context.setReceiveTimeout(5000 milliseconds)
      case ReceiveTimeout =>
        // To turn it off
        println("Se ejecuta este código cuando pasa el timeout")
        //context.setReceiveTimeout(Duration.Undefined) //cambia el timeout a infinito
        //throw new RuntimeException("Receive timed out")
    }
  }

  val system = ActorSystem("receive_timeout_actor_system")

  val myActor = system.actorOf(Props[MyActor], "myActor")

  myActor ! "Hello";


}
