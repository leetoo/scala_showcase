# how to it works

These example are extracted from official SBT Getting started and may suffer some changes.

# compile scala files.

    $ sbt
    > compile

  sbt checks **.scala** files en **ROOT** or **src/main/scala** or **src/test/scala**


   **Note:** Using **~compile** in sbt console you will get compile with every change un source files.
   **Note:** It is not necessary indicates which files compile.

# run scala files

   sbt search for main method in scala objects and executed it. If some class extends **App** class it will run every method inside it.

# buid.sbt

   sbt uses a **build.sbt** file to execute task, compile and declare manage dependencies.

  Every time when you run sbt command this file is load. So error in this file are detected in this step.
