### 2023-5-5
====================
1. redesign the front, Beautify the UI


### 2023-5-7
==================================
1. Configure JNI:

Add the path to the JNI header file in the CLion project. Usually the path is $JAVA_ HOME/include and $JAVA_ HOME/include/{platform}, where {platform} is your operating system (such as Linux, Darwin, etc.).

Write a C++function as an implementation of the native method, and call the callback interface of the web service through JNI.

2. Write Java code to implement web services:

Create a web service project using a Java web framework (such as Spring Boot). Implement API interfaces, callback interfaces, and WebSocket communication within it.

Implement a Java class and declare a native method to initiate video parsing tasks. At the same time, implement a static code block to load C++dynamic libraries.

Compile Java code and add the generated. class file to the C++project.

Compile C++code into a dynamic library:

Modify the CMakeLists.txt file to compile C++code into dynamic libraries (such as. so files,. dll files, etc.).

Ensure that this dynamic library is included in the Java web service project.

