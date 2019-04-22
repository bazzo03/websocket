name := "websocket"
 
version := "1.0" 
      
lazy val `websocket` = (project in file(".")).enablePlugins(PlayJava)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  guice ,
  javaJdbc ,
  javaWs,
  "com.typesafe.akka" %% "akka-actor" % "2.5.22",
  "org.slf4j" % "slf4j-api" % "1.7.26"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      