The Scala Native `sbt-scala-native` plugin version 0.3.8 does not behave correctly when the `sbt-pgp` plugin
version 1.1.1 has been added when using `sbt` 0.13.17. The example works fine using `sbt` 1.2.6 or by using
the `sbt-pgp` plugin version 1.0.0 which is the last version that worked.

By changing the `project/build.properties` file to change the `sbt` version or by altering the `project/plugins.sbt`
file to add, remove, or change version of the `sbt-pgp` you can see the behaviour using `sbt` 0.13.17.
The following commands can be used to test and when altering the demo to check alternatives.

```
$ sbt
> cleanFiles
> run
> exit
```

The following `sbt` commands also work.
```
> reload
> run
```

Incorrect Result:
```
> run
background log: info: Running Main
background log: debug: Waiting for threads to exit or System.exit to be called.
background log: debug:   Classpath:
	/Users/eric/workspace/buildtest/target/scala-2.11/classes
	/Users/eric/.ivy2/cache/org.scala-lang/scala-library/jars/scala-library-2.11.12.jar
	/Users/eric/.ivy2/cache/org.scala-native/nativelib_native0.3_2.11/jars/nativelib_native0.3_2.11-0.3.8.jar
	/Users/eric/.ivy2/cache/org.scala-lang/scala-reflect/jars/scala-reflect-2.11.12.jar
	/Users/eric/.ivy2/cache/org.scala-native/javalib_native0.3_2.11/jars/javalib_native0.3_2.11-0.3.8.jar
	/Users/eric/.ivy2/cache/org.scala-native/auxlib_native0.3_2.11/jars/auxlib_native0.3_2.11-0.3.8.jar
	/Users/eric/.ivy2/cache/org.scala-native/scalalib_native0.3_2.11/jars/scalalib_native0.3_2.11-0.3.8.jar
background log: debug: Waiting for thread run-main-0 to terminate.
Hello, world!
background log: debug: 	Thread run-main-0 exited.
background log: debug: Interrupting remaining threads (should be all daemons).
background log: debug: Sandboxed run complete..
background log: debug: Exited with code 0
[success] Total time: 0 s, completed Nov 11, 2018 7:26:05 AM
```

Correct Result:

```
> run
[info] Linking (1212 ms)
[info] Discovered 800 classes and 4709 methods
[info] Optimizing (debug mode) (1159 ms)
[info] Generating intermediate code (356 ms)
[info] Produced 39 files
[info] Compiling to native code (1364 ms)
[info] Linking native code (immix gc) (179 ms)
Hello, world!
[success] Total time: 7 s, completed Nov 11, 2018 7:40:07 AM
```

There is also a workaround commented out in the build that may hint at what the underlying problem may be.