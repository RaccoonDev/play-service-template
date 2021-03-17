lazy val webapp = (project in file("webapp"))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-service-template""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.5",
    libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
    scalacOptions ++= List(
      "-encoding", "utf8",
      "-deprecation",
      "-feature",
      "-unchecked",
      "-Xfatal-warnings"
    ),
    dockerExposedPorts += 9000,
    dockerBaseImage := "openjdk:12.0.1-jdk",
    Universal / javaOptions ++= Seq(
      // don't write any pid files
      "-Dpidfile.path=/dev/null",
      // reference a logback config file that has no file appenders
      "-Dlogback.configurationFile=logback-prod.xml"
    )
  )
