//scalaVersion := "2.11.12"
//
//// Set to false or remove if you want to show stubs as linking errors
//nativeLinkStubs := true
//
//enablePlugins(ScalaNativePlugin)

lazy val buildTest =
  project
    .in(file("."))
    .settings(
      scalaVersion := "2.11.12",
      nativeLinkStubs := true
    )
    //.settings(ScalaNativePlugin.projectSettings)
    .enablePlugins(ScalaNativePlugin)
