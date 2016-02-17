# C++ Make Project Template

A Simple C++ Project Structure copied from: http://hiltmon.com/blog/2013/07/03/a-simple-c-plus-plus-project-structure/

All credits go to [hiltmon](http://hiltmon.com/)

## Project Structure

![](http://hiltmon.com/images/simple-cpp-folders.jpg)

For each application, the folders are:

* __bin__: The output executables go here, both for the app and for any tests and spikes.
* __build__: This folder contains all object files, and is removed on a clean.
* __doc__: Any notes, like my assembly notes and configuration files, are here. I decided to create the development and production config files in here instead of in a separate config folder as they “document” the configuration.
* __include__: All project header files. All necessary third-party header files that do not exist under /usr/local/include are also placed here.
* __lib__: Any libs that get compiled by the project, third party or any needed in development. Prior to deployment, third party libraries get moved to /usr/local/lib where they belong, leaving the project clean enough to compile on our Linux deployment servers. I really use this to test different library versions than the standard.
* __spike__: I often write smaller classes or files to test technologies or ideas, and keep them around for future reference. They go here, where they do not dilute the real application’s files, but can still be found later.
* __src__: The application and only the application’s source files.
* __test__: All test code files. You do write tests, no?

## Notes

Notes on the Makefile:

* The TODO at the top reminds me that I am using a different version of a library in development and it must be removed before deployment.
* The TARGET is the main executable of the project, in this case bin/runner. Type make and this is what gets built.
* I’m using g++ because it’s the same on Mac OS X and on the production Linux boxes.
* If I uncomment the clang line, I get a failed link as the libraries are incompatible (or comment out the last line under $(TARGET):). But then I get the benefit of a clang static analyzer run help me make my code better, well worth it.
* I use the fewest number of compiler CFLAGS when developing as possible, optimization happens later.
* The SOURCES list is dynamic, I don’t want to manually have to maintain this list as I program. Anything in the src folder will be included in the compile as long as it has a SRCEXT extension.
* The OBJECTS list is also dynamic and uses a Makefile trick to build the list based on available sources.
* The LIB in this case uses a local library for MongoDB as I am testing it, but uses the default homebrew or yum installed libraries for boost. I normally do not use boost, but Mongo needs it.
* The INC ensures all headers in the include folder are accessible.
* I like to see the commands that run, hence the multitude of @echo's.
* Since there are so few of them, I manually add spikes and test builds as a new Makefile target, see the ticket: target for example.
* The .PHONY clean is brilliant, it nukes the build folder and the main executable. It does not clean spike or test executables though.

#### Aside: Why separate the includes and the sources?

This is fundamentally not necessary for most of my expected projects as they will be stand-alone daemons. But I do expect to build a few shared libraries for these daemons, and having the include files separate makes them easier to deploy later on. So I may as well get into the practice of keeping them separate.
