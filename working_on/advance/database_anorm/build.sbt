scalaVersion := "2.9.1"

resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/releases"

libraryDependencies ++= Seq(
  "play" %% "anorm" % "2.0-RC4",
  "com.github.seratch" %% "scalikejdbc" % "[0.5,)",
  "org.hsqldb" %  "hsqldb" % "[2,)"
)
