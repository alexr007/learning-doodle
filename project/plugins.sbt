resolvers += MavenRepository("Artima", "https://repo.artima.com/releases")
resolvers ++= Resolver.sonatypeOssRepos("public")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")
addDependencyTreePlugin
