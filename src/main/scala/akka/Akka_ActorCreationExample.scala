import akka.actor._

/**
* Ejercicio para la creación de actores mediante el uso de Props
* More info: http://doc.akka.io/docs/akka/2.4.0/scala/actors.html
*
**/
object Akka_ActorCreation extends App{

  object MyActor{
    case class Greeting(from: String)
    case object Goodbye
  }

  class MyActor extends Actor{
     import MyActor._
     def receive = {
       case x:Int => println("MyActor: me ha llegado un ENTERO!!")
       case x:String => println(s"MyActor: $x");
       case Greeting(from) => println(s"MyActor: Saludos desde $from")
       case Goodbye => println("MyActor: BYE")
       case _ => println("MyActor: me ha llegado un mensaje!!")
     }
  }

  object MyActorWithArguments {
  /**
   * Create Props for an actor of this type.
   * @param magicNumber The magic number to be passed to this actor’s constructor.
   * @return a Props for creating this actor, which can then be further configured
   *         (e.g. calling `.withDispatcher()` on it)
   */
   //define la función que permite ingresar los argumentos en la contrucción context.actorOf()
   //NOTAR QUE SE UTILIZA UN METODO PARA GENERAR UNA INSTANCIA DE Props
   def props(magicNumber: Int): Props = Props(new MyActorWithArguments(magicNumber))
  }

  class MyActorWithArguments(magicNumber: Int) extends Actor {
    def receive = {
      case x: Int => println("myActorWithArguments: " + x + magicNumber)
      case _ => println("myActorWithArguments: mensaje distinto de entero!!")
    }
  }
  class ParentActor extends Actor {

    //import context._ //se puede utilizar para evitar el tener que colocar context a cada rato.
    val myActor = context.actorOf(Props[MyActor], name = "myActorFromParentActor")
    def receive = {
      case x:String => myActor ! s"ParentActor: $x"
      case _ => println("ParentActor: me ha llegado un mensaje!!")
    }
  }

  /*** fin de la definición de los actores **/

  //Actores creados desde ActorSystem
  val system = ActorSystem("props_actor_system")
  //prueba para un actor sin argumentos
  val myActor = system.actorOf(Props[MyActor], "myActorFromSystem")
  myActor ! 1
  myActor ! "esto cualquier cosa"
  myActor ! MyActor.Goodbye
  myActor ! MyActor.Greeting("Miguel")
  //prueba Actor con argumentos en el contructor
  val myActorWithArguments =  system.actorOf(MyActorWithArguments.props(2), "myActorWithArguments")
  myActorWithArguments ! 1
  myActorWithArguments ! "esto cualquier cosa"

  //Actores creados desde otros actores
  val myParentActor = system.actorOf(Props[ParentActor], "myParentActor")
  myParentActor ! "hola mundo!!"

  //future { blocking(Thread.sleep(10000L)); "done" }
  //system.shutdown
}
