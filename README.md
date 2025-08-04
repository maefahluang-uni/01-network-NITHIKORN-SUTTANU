[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=20028262)
# Web Lab - Server with Socket
 This lab demonstrate how to create a simple web server that run on a localhost at specified network port. Server utilises Java's thread to keep server running to wait for a request.

 ## How to do lab
 1. study lecture materials.
 2. learn the purpose of statements shown in the slides
 3. start working on the exercise by cloning this project to your VS Code.
 4. answer question in the blank when it ask you to do so
 5. push back the code to Github to submit this lab.
 
**You have to carefully read the instruction. DO NOT skip any part.**

## Exercise A. Complete Server
The `MockWebServer` in package `th.mfu` serves the web server in our system. It get a request and response back `Hello Web!` message. You have to complete its source code by following the steps below and look for hints at `TODO` in the source code. The `MockWebServer` implements `Runnable` to make it be able to run as a thread. You must complete `run` method.
1. Create a server socket using `ServerSocket` in java.net library by openning at specified `port` defined from the constructor. 
2. Within infinite while loop,  accept incoming client connections to obtain client socket.
2. After that, create input and output streams for the client socket with `BufferedReader` and `PrintWriter`
3. Then, read the request from the client and send a response to the client. For example, if the server runs on port 8080, it should print out `Hello, Web! on Port 8080` 
4. Finally, close the client socket 
5. Study the code in `main()` and tell me What it does?
```
The `main()` created two server instances `server1` and `server2` running on different ports 8080 and 8081. `start()` method begins the execution of each server. `System.in.read()` It waits for user to press any key. When user press any key, it will stop both servers, print out the message and exit the program.
```
6. Run the `main()`, point the web browser to `http://localhost:8080` and `http://localhost:8081`
It should shows a simple HTML with the word such as  `Hello, Web! on Port 8080`.

## Exercise B. Complete Client
The `MockWebClient` is in the same package. This class mocks the web browser by sending a `HTTP GET` request to the web server and receive the message back to print out in the console. The `main()` method contains the source code to do this.
1. Create a socket to port `8080` using `Socket` class
2. create input and output streams for the client socket with `BufferedReader` and `PrintWriter`
3. send out the `HTTP GET` though `PrintWriter`
4. receive the response back from the web server and  print out to console
5. Finally, close the  socket 
6. Make sure the server is running and run this `MockWebClient` to see the result. It should print out message like below: 

```
HTTP/1.1 200 OK
Content-Type: text/html

<html><body>Hello, Web! on Port 8080</body></html>
```

## Exercise C. Unit Testing Mockup Server
Run the `MockWebServerTest` in `src/test/java`. This test script create a new object of MockWebServer on port 8080 and evaluate if the returned message is correct. 

## Challenge
Think about the following,  modify the code to experiment it and put your thought below.
- How can we run `MockWebserver` on different port? 
- How can we run more than 2 instances of  `MockWebserver`? 
- How can we change the content in HTML such as showing table, more text and adding images?
- What would be the benefit of running many instances?

```
- How to run MockWebServer on different ports?
  Just create new instances of MockWebServer with different port numbers and start them in separate threads.
- How can we run more than 2 instances of  `MockWebserver`? 
  Use a loop to start multiple servers on different ports.
- How can we change the content in HTML such as showing table, more text and adding images?
  Modify the HTML string sent in the response. For example:
- What would be the benefit of running many instances?
  Running multiple MockWebServer instances helps balance the load, isolate different services on separate ports, and improve reliability by ensuring others stay running if one fails. It’s also useful for testing and simulating real-world setups with multiple services.
```
**Please push the code back to Github to submit this lab**
After you push, ensure you have green checkmark on the repository.
<img width="692" height="201" alt="image" src="https://github.com/user-attachments/assets/0a4ab63d-7b6e-4711-90e7-b472bc11db2d" />

