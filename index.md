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

   **Note:** read [sbt_tutorial/README.md](sbt_tutorial/README.md) file

2. **script_examples** - windows and unix scripts examples
        $ cd script_examples
        $ bash simple_unix_script.scala (or simple_windows_script.bat)

   **Note:** We assume here the file script.sh has execute access and the search path for the scala command is specified in the PATH environment variable.

3. **src** - Scala code examples. Select Main Class

        $ sbt
        \> run

        Multiple main classes detected, select one to run:

          [1] Akka_ActorCreation
          [2] Akka_GenericExample
          [3] Lang_CaseClassExample
          [4] Lang_ForComprenhensionExample
          [5] Lang_FunctionlCombinatorsExample
          [6] Lang_FuturePromisesExample
          [7] Lang_SimpleClassExample
          ...

## List of Scala code examples ()

### script
0. Simple Unix Script - A Hello World example as Unix Script.
0. Simple Windows Script - A Hello World example as Windows Script.

<!-- Se utiliza markdown-include by Sethen para hacer un merge de los markdown
./node_modules/markdown-include/bin/cli.js markdown.json
More info: https://github.com/sethen/markdown-include#how-to-use-from-the-command-line -->
### Language
#include "./src/main/scala/language/README.md"

### Akka
#include "./src/main/scala/akka/README.md"

### Advance
0. Interop Scala Java - Scala code using Java code example.


##Interesting Vídeos
* [Busy Java Developer's Guide to Scala: Thinking](https://www.youtube.com/watch?v=_qRYOayG9SM)
* [Introducción al lenguaje de programación scala](https://www.youtube.com/watch?v=TuC5dKfwbME)
