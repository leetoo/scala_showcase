# Scala Showcase

 A lot of scripts useful to learn and train others in Scala.
 Before use it I recommend:

* Visit [Twitter Scala School!](https://twitter.github.io/scala_school/index.html) and when you feel that implements your test are better in files than Scala REPL you are welcome to clone **Scala Showcase**.
* If you use [Atom IDE](https://atom.io) use [language-scala plugin](https://atom.io/packages/language-scala)

## How to use

There are three main directories:

1. **sbt_tutorial** - sbt tutorials examples

        $ cd sbt_tutorial
        $ vim build.sbt #open build.sbt in an editor
        $ # and comment and uncomment diferrent
        $ #parts and close it.

        $ sbt
        > hello //first simple task example

   **Note:** read sbt_tutorial/README.md file

2. **script_examples** - windows and unix scripts examples
        $ cd script_examples
        $ bash simple_unix_script.scala (or simple_windows_script.bat)

   **Note:** We assume here the file script.sh has execute access and the search path for the scala command is specified in the PATH environment variable.

3. **src** - Scala code examples

        $ scala src/main/scala/XXX/filename.scala

## List of Scala code examples (src/)

### script
0. Simple Unix Script - A Hello World example as Unix Script.
0. Simple Windows Script - A Hello World example as Windows Script.

### Language
0. Simple Class - A simple Classes example.
0. Case Class - Case Class example **(TODO)**
0. Functional Combinators - Functional Combinators example
0. For-Comprehension - for-yield example
0. Future Promises - Future Promises examples **(TODO)**

### Advance
0. Interop Scala Java - Scala code using Java code example.


##Interesting Vídeos
* [Busy Java Developer's Guide to Scala: Thinking](https://www.youtube.com/watch?v=_qRYOayG9SM)
* [Introducción al lenguaje de programación scala](https://www.youtube.com/watch?v=TuC5dKfwbME)
