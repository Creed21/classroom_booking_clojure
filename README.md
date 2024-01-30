# classroom_booking clojure final project
Clojure, Mustache, and Ring/Jetty-Adapter are all important components in web development with Clojure.

# Clojure:
Clojure is a dynamic, functional programming language that runs on the Java Virtual Machine (JVM). It emphasizes immutability and persistent data structures, making it an excellent choice for building robust and scalable applications.
 
# Mustache:
is a logic-less templating language. It allows for the separation of presentation and logic in web applications. Mustache templates are easy to read and write, making them a popular choice for rendering HTML in web applications.

# Ring/Jetty-Adapter:
Ring is a web application library for Clojure that provides a simple and composable interface for handling HTTP requests and responses. It abstracts away the details of working with web servers, making it easier to develop web applications in Clojure. Jetty-Adapter is a specific adapter for Ring that allows you to deploy your Clojure web application on the Jetty web server.
Together, Ring and Jetty-Adapter provide a solid foundation for building web applications in Clojure. Ring handles the request-response cycle, while Jetty-Adapter allows you to deploy and run your Clojure application on a web server.
This combination provides a clean and efficient way to handle HTTP requests and serve web content using Clojure.
In a typical Clojure web application, you'll use Ring to handle HTTP requests, Mustache for templating, and a web server like Jetty (with the help of Jetty-Adapter) to serve the application to users.
Overall, these technologies work together to provide a powerful and expressive framework for building web applications in Clojure, leveraging the strengths of functional programming and the JVM ecosystem.

---------------------------------------------------------------------------------------------------------
## About the application

### Title: Reservation Management Application

### Introduction:

The Reservation Management Application is a user-friendly and efficient system designed to facilitate the process of reserving classrooms for various purposes.
This application is especially useful for educational institutions, event organizers, 
and businesses that require a streamlined reservation process. It allows users to create, manage, and track reservations with ease,
ensuring a hassle-free experience for both administrators and users.

### Key Features:

### User Profiles:
The application allows users to create individual profiles, providing essential information such as name, contact details, 
and organizational affiliation. User profiles help in managing reservations and tracking the reservation history.

### Classroom Types: 
Classrooms are categorized by types, making it easier for users to select the most suitable space for their needs.
Common classroom types might include lecture halls, seminar rooms, laboratories, and more.

### Reservation Creation: 
Users can create new reservations by selecting their preferred classroom, specifying the date and time,
and providing a brief description of the purpose of the reservation. The application ensures that there are no double bookings for the same classroom and time slot.

### Approval Process: 
Once a reservation is created, it goes through an approval process.
Administrators review and approve reservations to avoid conflicts and ensure that the requested classroom is available.

### User History: 
Users can view their reservation history, including past and upcoming reservations.
This feature helps users keep track of their room bookings over time.

### Search and Filters:
Users can search for available classrooms based on specific criteria, such as type, capacity, and availability.
This makes it easier to find the ideal space for their needs.

### Administrative Dashboard:
Administrators have access to a dashboard that provides an overview of all reservations, pending approvals, and usage statistics.
This central control panel allows administrators to efficiently manage classroom resources.

### UI and Rest API
In the project there are two types of interacting with the system: one is UI (using mustache) and one is REST API (JSON).

### Testing with Midje
[Midje](https://github.com/marick/Midje) library is a test framework for Clojure.
Midje is a testing library for Clojure that provides a unique and expressive syntax for writing tests. 
It is designed to make testing in Clojure both powerful and enjoyable.
Midje supports top-down as well as bottom-up testing.

Midje uses facts which are expressed using the fact macro, and they are organized in tables.
 
> example: (fact "Adding numbers"
(+ 2 2) => 4
(+ 1 1) => 2)

The => operator is used to denote the expected result in a fact.
> example: (fact "String length checker"
(count "hello") => 5)

Midje provides an arrow threading operator (=>) that makes the flow of data through expressions more explicit.
>(fact "Arrow threading"
2 => inc => (* 2) => 6)

Midje provides checkers for comparing data structures, making it easy to test maps, vectors, and other data types.
> (fact "Map equality"
{:a 1 :b 2} => {:a 1 :b 2})

Midje is designed to produce clear and informative error messages, helping developers quickly identify the cause of a failure.
Midje supports interactive development by allowing you to run specific facts or sections of facts in the REPL.
Overall, Midje encourages expressive, readable, and maintainable tests, making it a popular choice for testing Clojure applications. 
It integrates well with the REPL-driven development approach often used in the Clojure community.


### Conclusion:

The Reservation Management Application streamlines the process of reserving classrooms, 
making it simple for users to find and book suitable spaces while ensuring efficient resource allocation and management for institutions and organizations.
With features like approval workflows, user profiles, and analytics, it offers a comprehensive solution for reservation needs,
promoting a smooth and organized booking process. Whether you're a student booking a study room or an event planner reserving a lecture hall,
this application is designed to meet your reservation needs effectively and efficiently.


---------------------------------------------------------------------------------------------------------

## About Testing

Testing is a crucial aspect of software development, and it serves various purposes in ensuring the quality and reliability of your applications.
Here are some reasons why testing is important and why every project should have a comprehensive set of tests:

###Identifying Bugs Early:
Testing helps in detecting and fixing bugs at an early stage of development. 
This reduces the cost of fixing issues and improves the overall quality of the code.

###Ensuring Correctness:
Tests verify that your code behaves as expected under various conditions. 
This ensures that the software functions correctly and meets the specified requirements.

###Maintaining Code Quality:
Tests act as a safety net when making changes to the codebase. 
They help prevent regressions, ensuring that new features or modifications don't break existing functionality.

###Facilitating Refactoring:
Tests provide confidence when refactoring or reorganizing code. 
Developers can make changes and quickly validate that existing functionality remains intact.

###Documenting Behavior:
Test cases serve as documentation for how different parts of the application should work. 
They provide a clear understanding of the expected behavior of the system.

###Supporting Continuous Integration/Continuous Deployment (CI/CD):
Automated tests are an integral part of CI/CD pipelines. They ensure that changes are thoroughly tested before being deployed to production, 
reducing the risk of introducing defects.

###Enhancing Collaboration:
Tests serve as a form of communication between team members. 
They express the intended behavior of the code and help team members understand how different components interact.

###Increasing Confidence:
Having a comprehensive test suite increases confidence in the reliability of the application. 
Developers and stakeholders can be more certain that the software behaves as intended.

###Saving Time and Resources:
While writing tests may require an initial investment, it pays off in the long run.
Automated tests can be executed quickly and repeatedly, saving time and resources that would otherwise be spent on manual testing.

###Meeting Business Requirements:
Testing ensures that the software meets the business requirements and user expectations. 
This is crucial for customer satisfaction and the success of the project.

Testing is an essential part of the software development process. 
It improves the overall quality of the code, reduces the risk of defects, and provides a safety net for ongoing development and maintenance. 
A project without proper testing is more likely to encounter issues, 
and the cost of fixing problems in production is generally higher than addressing them during development.


## Types of Testing

There are various types of testing, each serving a specific purpose in the software development life cycle. Here's an overview of some common types of testing:

### Unit Testing:
Objective: Verify the correctness of individual units or components of the software.
Scope: Isolated testing of functions, methods, or classes.
Tools: Examples include JUnit (Java), pytest (Python), and NUnit (.NET).

### Integration Testing:
Objective: Ensure that different units or components work together as expected.
Scope: Testing interactions between integrated components.
Tools: Examples include TestNG, Test::Unit, and Mockito.

###Functional Testing:
Objective: Validate that the software functions according to specified requirements.
Scope: End-to-end testing of features and functionalities.
Tools: Selenium (for web applications), Appium (for mobile applications), and Robot Framework.

###API Testing:
Objective: Verify the functionality and reliability of APIs (Application Programming Interfaces).
Scope: Testing API endpoints, requests, and responses.
Tools: Postman, RestAssured, and Insomnia.

###End-to-End (E2E) Testing:
Objective: Validate the entire application workflow from start to finish.
Scope: Emulates real user scenarios and interactions.
Tools: Cypress, Selenium, and Puppeteer.

###Performance Testing:
Objective: Assess the responsiveness, speed, and scalability of the application under various conditions.
Scope: Measures response times, throughput, and resource usage.
Tools: Apache JMeter, Gatling, and Locust.

###Load Testing:
Objective: Evaluate how well the system performs under expected load conditions.
Scope: Assessing the system's ability to handle a specific number of concurrent users or transactions.
Tools: Apache JMeter, Gatling, and LoadRunner.

###Stress Testing:
Objective: Push the system beyond its intended capacity to identify failure points and weaknesses.
Scope: Exceeding normal load conditions to determine system robustness.
Tools: Apache JMeter, StressStimulus, and Siege.

###Security Testing:
Objective: Identify vulnerabilities and weaknesses in the application's security.
Scope: Assessing potential risks such as data breaches and unauthorized access.
Tools: OWASP ZAP, Nessus, and Burp Suite.

###Usability Testing:
Objective: Evaluate the user-friendliness and overall user experience of the application.
Scope: Assessing ease of use, navigation, and user satisfaction.
Tools: Often involves manual testing and user feedback.

###Acceptance Testing:
Objective: Ensure that the application meets business requirements and is ready for release.
Scope: Validates the application against predefined acceptance criteria.
Tools: Cucumber, Behave, and SpecFlow.

###Regression Testing:
Objective: Ensure that new changes do not adversely impact existing functionalities.
Scope: Testing previously validated features after code changes.
Tools: Automated testing frameworks used for unit, integration, and functional testing.


These testing types can be combined and tailored to the specific needs and characteristics of the project. 
The goal is to have a comprehensive testing strategy that provides confidence in the quality and reliability of the software.


---------------------------------------------------------------------------------------------------------

##Integration Testing vs. API Testing:

Both Integration Testing and API Testing are crucial components of a comprehensive testing strategy. 
While Integration Testing ensures that different parts of a system work well together, 
API Testing specifically targets the functionality provided by APIs. 
Combining both types of testing helps ensure the reliability and stability of a software application.

###Integration Testing - within the system:
Focuses on testing interactions between integrated components within a system.
May involve testing multiple layers of an application, including databases, backend services, and frontend components.
Ensures that different modules collaborate correctly.
In project integration tests are under the test.classroom_booking.integrations_test package

###API Testing - without the system:
Concentrates on testing APIs in isolation.
Verifies that APIs adhere to their specifications and perform as expected.
Evaluates how well APIs handle data requests and responses.
In project integration tests are under the test.classroom_booking.rest_api_test package

* Also be aware of testing environment and starting database state before you start testing.
* When conducting tests, especially integration tests involving a database, 
* it's crucial to manage the testing environment and the database state to ensure accurate and reliable results.

---------------------------------------------------------------------------------------------------------
### Specially enthusiastic about dynamic querying clojure vs java

In this Clojure function, read-data-with-conditions takes a map of conditions and builds a WHERE 
clause dynamically based on non-nil key-value pairs in the conditions. 
It then uses the jdbc/query function to execute a SQL SELECT query with the generated WHERE clause.

```
Clojure dynamic querying
(defn read-data-with-conditions [conditions]
(jdbc/with-db-connection [conn db/db-spec]
(let [where-clause (->> conditions
(filter (fn [[k _]] (not (nil? (get k conditions)))))
(map (fn [[k v]] (str k " = ?")))
(clojure.string/join " AND "))]
(jdbc/query conn (str "SELECT * FROM classroom_booking.classroom WHERE " where-clause) (vals conditions)))))
```

These two methods are part of a class, likely named GenericObject, 
and they are used for dynamically building a SELECT query and a WHERE clause based on the fields of the class instance.

This method is responsible for constructing a SELECT query.

```
JAVA dynamic querying

public String makeSelectRefl() {
return "SELECT "+getColumNamesRefl()
+"\nFROM " +  getClassName()//className
+"\n"+getGenericWhere()
+getWhereRefl();
}
```
This method iterates through the declared fields of the class and builds a WHERE clause based on the non-null field values.
```
protected String getWhereRefl() {
String where = "";
for(Field f : this.getClass().getDeclaredFields()) {
f.setAccessible(true);
if(f.getName().contains("serialVersionUID")) {
f.setAccessible(false);
continue;
}
String field_name = f.getName();
String attr_type = f.getType().getName();
attr_type = attr_type.substring(attr_type.lastIndexOf(".")+1);

            Object field_value = null;
            try {
                field_value = f.get(this);
            } catch (IllegalArgumentException | IllegalAccessException ex) {Logger.getLogger(GenericObject.class.getName()).log(Level.SEVERE, null, ex); }            

            if(field_value == null)  continue;

            where += "\n and "+field_name+" = ";
            where += getFieldValueFromType(attr_type, field_value);// getFieldValueFromType(attr_type, where, field_value);
            f.setAccessible(false);
        }
        
        return where;
    }
```

Clojure is a functional language, and Java is an object-oriented language. 
They follow different programming paradigms, impacting how problems are approached and solved.

From this example we can see that the problem is much easier to solve in functional paradigm in clojure than in OOP in java.

---------------------------------------------------------------------------------------------------------
## Sources
[1] Daniel Higginbotham, 2016, Clojure for the Brave and True

[2] https://github.com/bbatsov/clojure-style-guide

[3] https://clojars.org/

[4] https://clojure.org/api/cheatsheet

[5] https://github.com/marick/Midje

[6] https://github.com/clj-kondo/clj-kondo

[7] https://github.com/clj-kondo/lein-clj-kondo

---------------------------------------------------------------------------------------------------------
## License
Copyright © 2023/2024 Aleksandar Jankovic all rights reserved

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
which is available at http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary Licenses 
when the conditions for such availability set forth in the Eclipse Public License, 
v. 2.0 are satisfied: GNU General Public License as published by the Free Software Foundation, 
either version 2 of the License, or (at your option) any later version, 
with the GNU Classpath Exception which is available at https://www.gnu.org/software/classpath/license.html.
