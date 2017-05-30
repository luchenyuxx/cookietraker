import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.2",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "cookietracker",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.5.2",
      "com.typesafe.akka" %% "akka-testkit" % "2.5.2" % Test
    ),
    // Used for HTML parse
    libraryDependencies += "org.jsoup" % "jsoup" % "1.10.2",
    // Used for URL validate
    libraryDependencies += "commons-validator" % "commons-validator" % "1.6"
  )
