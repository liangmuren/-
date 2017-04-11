|        |                      |      |      |      |      |
| ------ | -------------------- | ---- | ---- | ---- | ---- |
| Task 1 | 使用Java实现Web服务器编程     | 5    | 实验一  | 3    | 3    |
| Task 2 | 使用Java实现POP客户端编程     | 5    | 实验二  | 3    | 3    |
| Task3  | 使用Java/CORBA实现分布应用编程 | 5    | 实验三  | 3    | 3    |
| Task 4 | 熟悉ICMP协议和DHCP协议      | 3    | 实验四  | 3    | 3    |


**参考资料：**

1、  HyperText Transfer Protocol, RFC 1945 RFC 2616

2、  PostOffice Protocol Ver.3 RFC 1939

3、  Java Network Programming and Distributed Computing

4、  PracticalPacket Analysis：sing Wireshark toSolve Real-World Network Problems

5、  Instant Wireshark Starter

## Task 1

完成简单的web服务器程序，上交程序和设计文档

## Task 2

完成user、pass、retr、list等命令，上交程序和设计文档

## Task 3

**Readings:**

- Reilly and Reilly, chapter 12 

- JavaTM IDL Technology Documentation 

  at [http://java.sun.com/j2se/1.5/docs/guide/idl/index.html](http://java.sun.com/j2se/1.5/docs/guide/idl/index.html).These readings describe a variety of ways in which Java and CORBA interact, andgive an introduction to using IDL and CORBA. 

### Background

Build a distributed to-do list using Java and CORBA. Variousclients should be able to connect to a server managing various to-do listobjects to query list items, add list items, delete list items, and clear to-dolists. The server should also have management functionality that allows memberregistration. Each to-do list item has a description, and a start time and anend time in which users must complete their items. Users should be able to addany number of items to their to-do lists.

### Tasks

For this programming exercise, we will be using JavaSoft's JavaIDL, which is a CORBA ORB written completely in Java. The advantages of Java'sIDL are that it is free and very portable. Its disadvantage is that itsfunctionality is minimal. However, it supports static method invocations, andit has a naming service, which is all we need for this programming exercise.The Java IDL compiler (`idlj`)is packaged with the [latest version of Java](http://java.sun.com/j2se/1.4.2/download.html)(1.4.2 as of the time of this writing). Youmay find documentation for the `idlj`compiler [here](http://java.sun.com/j2se/1.4.2/docs/guide/rmi-iiop/toJavaPortableUG.html).

Your to-do list should implement the following functionality. Eachpiece of functionality outlined below must be accessible from the client usingthe CORBA naming service. Each user's to-do list must be a separate object thatis managed using CORBA. 

**User Registration** 

New usersmay register. New users must supply a user name and a password. If the supplieduser name is already in use by some other user, print an error message. Uponsuccessful registration, print a message stating so. A new user registrationshould create a new to-do list object for the user. 

**Adding Items** 

Registeredusers may add items to their to-do list. Each item has a start time and an endtime. Parameters should include the start and end times, and a label. The usershould receive a message indicating a successful addition or an error if oneoccurs. 

**Querying Items** 

Registeredusers may look up all items in their to-do list in a given interval of time.The parameters should include the start and end times of the search interval.Return a list of the entries found in the specified time range. In the list,include the start time, end time, and label of each item. 

**Deleting Items** 

Registeredusers may delete items from their to-do list. The parameters should uniquelyidentify the entry to be deleted. 

**Clearing Items** 

Registeredusers may clear all items from their to-do list. 

### Interface

Your client must be accessible via a simple console-based menu.

### Implementation

To complete this assignment, you will need to manage multipleCORBA objects using the CORBA naming service. For each user that successfullyregisters, you must create a new to-do list and add it to the CORBA namingservice. To that end, you will need to write a to-do list creator that createsto-do lists and adds them to the CORBA naming system. The to-do list creatormust be also be accessible using the CORBA naming service. Therefore, if thereare n to-do list system users, CORBA must manage n+1CORBA objects — one to-do list object for each user *plus* the creatorobject. You will need to perform the following tasks to complete thisassignment.

- Write a to-do list creator object that creates to-do     lists upon a successful user registration and adds the to-do list objects     to the CORBA naming service. 
- Casting the to-do list object to a generic Java object     and generating the IDL description of the interfaces. 
- Write a simple CORBA client that exercises the main     methods of the to-do list and to-do list creator CORBA object. 
- Deploying and running the system. You should run a     test involving two or more agenda objects, keeping track of the agendas of     different users. The client should use the CORBA naming service to find     the appropriate agenda object. 

### Submission

**Coding Style and Documentation** 

You are expected to design classes in an object-oriented mannerusing good programming practices.

Your code must be written using [Java codingconventions](http://java.sun.com/docs/codeconv/). Your code must be welldocumented and contain a README file with instructions on compiling and runningeach program.

The files you should turn in are listed below.

- Submit all files necessary to run your to-do list. 
- A README file. 

## Task 4

利用Wireshark截取数据包，并对数据包进行解析。上交分析报告。



