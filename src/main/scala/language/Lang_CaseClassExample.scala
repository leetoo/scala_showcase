object Lang_CaseClassExample {

  abstract class Term
  case class Var(name: String) extends Term
  case class Fun(arg: String, body: Term) extends Term
  case class App(f: Term, v: Term) extends Term

  def printTerm(term: Term) {
    term match {
      case Var(n) =>
        print(n)
      case Fun(x, b) =>
        print("^" + x + ".")
        printTerm(b)
      case App(f, v) =>
        Console.print("(")
        printTerm(f)
        print(" ")
        printTerm(v)
        print(")")
    }
  }

  def isIdentityFun(term: Term): Boolean = term match {
    case Fun(x, Var(y)) if x == y => true
    case _ => false
  }

  def main(args: Array[String]) {
    val v = Var("hola")
    val id = Fun("x", Var("x"))
    val t = Fun("x", Fun("y", App(Var("saludo1"), Var("saludo2"))))
    printTerm(id)
    println
    printTerm(t)
    println
    println(isIdentityFun(id))
    println(isIdentityFun(t))
  }
}

//SimpleClassExample.main(args)
