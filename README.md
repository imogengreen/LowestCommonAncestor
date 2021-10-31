# LowestCommonAncestor
Lowest Common Ancestor assignment as part of CSU33012 Software Engineering.

This is an implementation of the Lowest Common Ancestor problem in a binary tree in both Java and Python. There is also a unit test file for each implementation.

**Overview of IDEs and Dependencies**

_Java implementation:_
This was written in VSCode. In order to do JUnit testing in VSCode, we must first do some additional setting up...
1. Navigate to settings.json 
Download the Junit Platform Standalone Console JAR file (available here: https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqazB4OVJPWXpEOUg4QU5RT3MyTzVQQU9rTEZGd3xBQ3Jtc0tubGF2ckQzRkRMOGFHZHh4bkt6NExWd0FwTWh0QkE3bTNIaF8tcVItb3V3S1c4Z2R3ZkZIQVBaT2YtZ2s4MWtYRGN1OENibW9DeV9Rdk1sNldHNHpGNmhrZUdidjdNTXRpVDRzX01kMlJoYWJjLVBjcw&q=https%3A%2F%2Fsearch.maven.org%2Fremotecontent%3Ffilepath%3Dorg%2Fjunit%2Fplatform%2Fjunit-platform-console-standalone%2F1.6.0%2Fjunit-platform-console-standalone-1.6.0.jar)
2. Within settings.json, type the following:

![image](https://user-images.githubusercontent.com/90784712/136812625-085861b2-25a1-4371-bb48-d9a7ef25053f.png)

3. Restart VSCode
4. You will now be able to write and run JUnit tests in VSCode!

_Python implementation:_
This was written in PyCharm, which is an IDE developed by JetBrains for developing Python code. 
Pycharm is available to download at: https://www.jetbrains.com/pycharm/download/#section=windows

To create unit tests in Pycharm is very straightforward. 
1. Create a new file
New... > New Python File > New Python Unit Test
2. Hey presto! It does all the setting up for you so all that you have to do is write the tests.

When developing Python code, we must have Python installed on our local machine. 
- We can check the version by typing "python --version"
- If it is not already installed, we can install in one simple step on a Windows machine by typing "python" into command prompt. This then takes us to the Microsoft Store where Python 3 can be installed (current version: Python 3.9.7)

**DAG Branch**: I have created this branch so that I can include functionality for the Java LCA implementation to work for Directed Acyclic Graphs.
