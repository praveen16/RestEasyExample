Simple RestEasy JAX-RS 2.0 Server with a sample Servlet Filter 
=======================================================================

- RestEasy 3.0.16 Restful web service.
- ServletFilter that hooks into the servlet execution.
- Used to test https://issues.jboss.org/browse/RESTEASY-851

Simple JAX-RS 2.0 Server and Client that exchanges JSON documents.
Added a ServletFilter and verify if unchecked/unmapped exceptions flow back through the servlet filter. 

Instructions to SetUp and Run this project
==========================================
Assumptions:
--------------
- Maven is setup on your environment
- You are familiar with using GIT and GITHub

--------
Steps:
---------
- Fork/Clone project
- build using command ->  mvn -U clean install
- run application using command -> mvn jetty:run

- Verify in Browser with api endpoints
 -- http://localhost:9095/customers 
 -- http://localhost:9095/customers/1

To verify RESTEASY-851
 -- http://localhost:9095/customers/exception
