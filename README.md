# Ticket-Service
[![Build Status](https://travis-ci.com/iuanshuai/Ticket-Service.svg?branch=master)](https://travis-ci.com/iuanshuai/Ticket-Service)
![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/iuanshuai/Ticket-Service.svg?label=License)
![](https://img.shields.io/badge/Java-1.8-green.svg)

## Project Technical Overview

This is an implementation of a simple ticket service that facilitates the discovery, temporary hold, and final reservation of seats within a high-demand performance venue.

It was made using **Spring Boot**, **Spring Data JPA**, **Spring RESTful web services**, **Maven**, **PostgreSQL**,and **Docker**.

## Build & Installation

* Install and run [PostgreSQL](hhttps://www.postgresql.org).
    ```
    docker pull postgres
    docker run --name dealerDB -e POSTGRES_DB=ticketservice_unit -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=password -p 5430:5432 -d postgres
    ``` 
* Clone the repository and switch to the directory.
    ```
    clone https://github.com/iuanshuai/Ticket-Service.git
    cd Ticket-Service
    ```
* Do the database migration
    ```
    mvn clean compile flyway:migrate -P unit -Ddb_username=admin -Ddb_password=password
    ```
* Create war package file `mvn clean compile package -DskipTests=true`.
* Deploy the `war` file in `target` to a application server of your choice (e.g. [Apache Tomcat](http://tomcat.apache.org/)). For example, if using tomcat, run `sh startup.sh`


