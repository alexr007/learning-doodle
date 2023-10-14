Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "learning-doodle",
    libraryDependencies ++= Seq(
      compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
      "org.creativescala"          %% "doodle"                    % "0.19.0",
      "org.creativescala"          %% "doodle-svg"                % "0.16.1",
      "org.scalatest"              %% "scalatest"                 % "3.2.16",
      "org.scalacheck"             %% "scalacheck"                % "1.17.0",
      "org.scalatestplus"          %% "scalacheck-1-17"           % "3.2.16.0",
      "com.github.alexarchambault" %% "scalacheck-shapeless_1.16" % "1.3.1",
      "com.lihaoyi"                %% "pprint"                    % "0.8.1",
    )
  )
