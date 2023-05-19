fork in run := true
version := "0.1.0"
name := "DataTransformer"
scalaVersion := "2.13.10"
libraryDependencies ++= Seq(
  "com.github.mjakubowski84" %% "parquet4s-core" % "2.1.0",
  "com.github.tototoshi" %% "scala-csv" % "1.3.10",
  "org.mariadb.jdbc" % "mariadb-java-client" % "2.4.3",
  "mysql" % "mysql-connector-java" % "5.1.26")


Compile / mainClass  := Some("Main")
assembly / mainClass := Some("Main")

assemblyMergeStrategy  in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}