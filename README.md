## Synopsis
This is a small example demonstrate the use of Hystrix for third party dependencies in your application. The application is a REST API to convert currency from GBP or USD to INR. The third party service is being stubbed using wiremock returning a response with a fixed delay. 


## Installation
  * Java 1.8
  
## How to build
./gradlew clean createCapsule

## How to start server
./gradlew startServer

## How to stop server
./gradlew stopServer

## How to start stub (third party service that brings conversion rate)
./gradlew startStubServer

## How to stop stub server
./gradlew stopStubServer

## Hystrix Dashboard
Hystrix dashboard is a separate application that consumes hystrix event stream emitted from the application(Hystrix Example) and show the graph with current state of circuit.
 # Starting Hystrix dashboard
  * Add the hystrix dashboard war placed under ${projectDir}/dashboard to a tomcat container under /webapps.
  * Start tomcat and goto http://localhost:7979
  * Add the hystrix event stream of the application which is http://{hostname}:{port}/currencyConversionService/hystrix.stream to dashboard.
  * Click on 'Monitor Streams' button.
