import java.sql.Connection
import scalikejdbc._
import anorm._

/**
 * @see "https://github.com/playframework/Play20/wiki/ScalaAnorm"
 * @see "https://github.com/seratch/scalikejdbc"
 */
object WithScalikeJDBC extends App {

  Class.forName("org.hsqldb.jdbc.JDBCDriver")
  ConnectionPool.singleton("jdbc:hsqldb:mem:hsqldb:WithAnorm", "", "")

  implicit val conn: Connection = ConnectionPool.borrow()
  SQL("create table emp (id integer primary key, name varchar(30))").execute()
  SQL("insert into emp (id, name) values ({id}, {name})").on("id" -> 1, "name" -> "name1").executeUpdate()
  SQL("insert into emp (id, name) values ({id}, {name})").on("id" -> 2, "name" -> "name2").executeUpdate()

  val selectAll: SqlQuery = SQL("select id, name from emp")
  val all: Stream[SqlRow] = selectAll.apply
  all.foreach {
    row => println(row)
  }
  val selectAll2: SqlQuery = SQL("select * from emp")
  selectAll2() foreach println

  case class Emp(id: Int, name: String)

  val res: Stream[Emp] = SQL("select id,name from emp")().collect {
    case Row(id: Int, Some(name: String)) => Emp(id, name)
  }
  res foreach println

}
