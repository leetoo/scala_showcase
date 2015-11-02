import akka.actor._
import scala.concurrent.duration._
import akka.pattern.ask
import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object Akka_MessagesExample extends App{

  //Ïts a good Idea define case classes for comples messages
  //case class BECASUSE THEY SHOULD BE IMMUTABLES.
  case class User(firstname:String, lastname:String)
  case class Register(user:User)
  case class IsRegistered(user:User)

  class MyActor extends Actor{
   var userVar:User = new User("","")
   def receive = {
     case Register(user) => { userVar = user; println("El usuario procesado es " + user.firstname + " " + user.lastname)}
     case IsRegistered(user) =>{sender ! (userVar == user) }
     case _ => println("Mensaje no valido")
   }
  }

  val system = ActorSystem("messages_actor_system")
  val myActor = system.actorOf(Props[MyActor], "myActor")

  myActor ! Register(new User("Miguel", "Olave"))
  myActor.tell("mensaje", ActorRef.noSender) //es lo mismo que lo anterior


  var future = myActor.ask(IsRegistered(new User("Miguel", "Olave")))(5 seconds)


  future.onComplete {
      case Success(value) => println(s"futureTrue: $value")
      case Failure(e) => println("futureTrue: Exception: " + e.printStackTrace)
  }

  future = myActor.ask(IsRegistered(new User("S", "A")))(5 seconds)
  future.onComplete {
      case Success(value) => println(s"futureFalse: $value")
      case Failure(e) => println("futureFalse: Exception: " + e.printStackTrace)
  }

  //system.shutdown

}
