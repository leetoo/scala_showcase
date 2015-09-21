import sbt.Keys._ //it is not necessary. it automatic imported


/**
 * PART 1:
 *  - single project
 *  - single task
**/


//task definition
lazy val hello = taskKey[Unit]("An example task")

lazy val library = (project in file(".")).
    settings(Seq(
      organization := "com.example", 
      version := "1,0",
      hello := println("hola!!")
    )
  )


//#####################################################

/**
 *  PART 2:
 *   - commonSettings
 *   - several task
 *
**/

/**
//task definition

lazy val hello = taskKey[Unit]("An example task")
lazy val startServer = taskKey[Unit]("start server")
lazy val stopServer = taskKey[Unit]("stop server")
lazy val sampleIntTask = taskKey[Int]("A sample int task.")
lazy val sampleStringTask = taskKey[String]("A sample string task.")

lazy val commonSettings = Seq(
      organization := "com.example",
      version := "0.1.0-SNAPSHOT",
      scalaVersion := "2.11.7",
      hello := {println("HELLO!!")} //task implementation
    )

lazy val library = (project in file(".")).
    settings(commonSettings: _*).
    settings(
      startServer := {
        println("starting...")
        Thread.sleep(500)
      },
      stopServer := {
        println("stopping...")
        Thread.sleep(500)
      },
      sampleIntTask := {
        startServer.value
        val sum = 1 + 2
        println("sum: " + sum)
        stopServer.value // THIS WON'T WORK IN THIS ORDER 
                         // ASINCRONIC EXECUTION 
        sum
      },
      sampleStringTask := {
        startServer.value // DEDUPLICATION - it ran in sampleIntTask
        val s = sampleIntTask.value.toString
        println("s: " + s)
        s
      }
    )

**/

//#####################################################

/**
 *  PART 3:
 *   - Execute a sequence of senteces OPTION 1
 *
**/

/*  
//task definition
lazy val hello = taskKey[Unit]("An example task")
lazy val startServer = taskKey[Unit]("start server")
lazy val stopServer = taskKey[Unit]("stop server")
lazy val sampleIntTask = taskKey[Int]("A sample int task.")
lazy val sampleStringTask = taskKey[String]("A sample string task.")

lazy val commonSettings = Seq(
      organization := "com.example",
      version := "0.1.0-SNAPSHOT",
      scalaVersion := "2.11.7",
      hello := {println("HELLO!!")} //task implementation
    )

lazy val library = (project in file(".")).
    settings(commonSettings: _*).
    settings(
      startServer := {
        println("starting...")
        Thread.sleep(500)
      },
      sampleIntTask := {
        startServer.value
        val sum = 1 + 2
        println("sum: " + sum)
        sum
      },
      sampleStringTask := {
        startServer.value // DEDUPLICATION - it ran in sampleIntTask
        val s = sampleIntTask.value.toString
        println("s: " + s)
        s
      },
      sampleStringTask := {
        val old = sampleStringTask.value
        println("stopping...")
        Thread.sleep(500)
        old
      }
    )
*/

//#####################################################

/**
 *  PART 4:
 *   - Execute a sequence of senteces OPTION 2
 *
**/
/*

//Note that is not necessary import project.ServerUtil._

//task definition
lazy val hello = taskKey[Unit]("An example task")
lazy val sampleIntTask = taskKey[Int]("A sample int task.")
lazy val sampleStringTask = taskKey[String]("A sample string task.")

lazy val commonSettings = Seq(
      organization := "com.example",
      version := "0.1.0-SNAPSHOT",
      scalaVersion := "2.11.7",
      hello := {println("HELLO!!")} //task implementation
    )

lazy val library = (project in file(".")).
    settings(commonSettings: _*).
    settings(
      sampleIntTask := {
        ServerUtil.startServer
        val sum:Int = 1 + 2
        try {
          //val sum:Int = 1 + 2
          println("sum: " + sum)
        } finally {
          ServerUtil.stopServer
          //sum
        }
        sum
      },
      sampleStringTask := {
        ServerUtil.startServer
        val s = sampleIntTask.value.toString
        println("s: " + s)
        s
      }
    )
*/

//#####################################################

/**
 *  PART 5:
 *   - Multi project
 *
**/


/**Diferent ways to define a project **/
//lazy val util = project //simple notation
//lazy val core = project.dependsOn(util) //core depends on util project
//lazy val util = project.in(file("util")) //java notation
//lazy val core = project in file("core")  //scala notation

/*
lazy val commonSettings = Seq(
  organization := "com.example",
  scalaVersion := "2.11.4"
)

lazy val core = (project in file("core")).
  dependsOn(util). //Classpath dependency
  settings(commonSettings: _*).
  settings(
    version := "0.1.3"
    // other settings
  )


lazy val util = (project in file("util")).
  settings(commonSettings: _*).
  settings(
    version := "0.1.2"
    // other settings
  )

lazy val root = (project in file(".")).
  aggregate(util, core). //added by "aggregation"
  settings(
    version := "0.1.1", //CHECKOUT 'show version' on sbt.
    aggregate in update := false //control task aggregation
  )
*/


//#####################################################

/**
 *  PART 6:
 *   - .scala build definition
 *   - bare definition
 *
 *   bare definition is a old way to define settings in sbt.
 *
 * How settings is imported:
 *   • In .scala files, you can add settings to Build.settings for sbt 
 *     to find,and they are automatically build-scoped.
 *   • In .scala files, you can add settings to Project.settings for 
 *     sbt to find and they are automatically project-scoped.
 *   • Any Build object you write in a .scala file will have its 
 *     contents imported and available to .sbt files.
 *   • The settings in .sbt files are appended to the settings 
 *     in .scala files.
 *   • The settings in .sbt files are project-scoped unless you explicitly
 *     specify another scope.
 * 
 *  Last replace Win!!
**/
/*
name := "hello"

version := "1.0"

scalaVersion := "2.11.4"

sampleKeyC in ThisBuild := "C: in build.sbt scoped to ThisBuild"

sampleKeyD := "D: in build.sbt"

*/
