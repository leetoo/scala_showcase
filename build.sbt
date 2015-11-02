import sbt.Keys._

lazy val akka_example = (project in file(".")).
    settings(Seq(
        name := """hello-akka""",
        version := "1.0",
        scalaVersion := "2.11.6",
        testOptions += Tests.Argument(TestFrameworks.JUnit, "-v"),
        fork in run := true,
        //mainClass in (Compile, run) := Some("HelloAkkaScala"),
        libraryDependencies ++= Seq(
            "com.typesafe.akka" %% "akka-actor" % "2.3.12",
            "com.typesafe.akka" %% "akka-testkit" % "2.3.12",
            "org.scalatest" %% "scalatest" % "2.2.4" % "test",
            "junit" % "junit" % "4.12" % "test",
            "com.novocode" % "junit-interface" % "0.11" % "test"
            )
        )
    )
