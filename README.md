# datarest-907-example
Example illustrating DATAREST-907 issue


To illustrate the issue, run the application 
````
mvn clean isntall
brew services restart mongodb
java -jar target/datarest-907-example-0.0.1-SNAPSHOT.jar
````

The create a sample entity:
````
curl -H 'Accept: application/json, text/plain, */*' -H 'Content-Type: application/json' --data '{ "myJodaTime": "2016-09-09T00:00:00.000Z" }' http://localhost:8080/myentities
````

To retrieve an entity:
````
curl -i -H 'Accept: application/json, text/plain, */*' -H 'Content-Type: application/json' -X GET http://localhost:8080/myentities/57eb759102ca691e90262ab3
````
Result with Spring Boot 1.4.1
````
HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Wed, 28 Sep 2016 07:48:42 GMT

{
  "myJodaTime" : {
    "content" : "2016-09-09T00:00:00.000Z"
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/myentities/57eb759102ca691e90262ab3"
    },
    "myEntity" : {
      "href" : "http://localhost:8080/myentities/57eb759102ca691e90262ab3"
    }
  }
}
````

Now change the Spring Boot version in the pom.xml file to 1.3.8, rebuild and rerun the application as described above:
````
curl -i -H 'Accept: application/json, text/plain, */*' -H 'Content-Type: application/json' -X GET http://localhost:8080/myentities/57eb759102ca691e90262ab3
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Wed, 28 Sep 2016 07:50:15 GMT

{
  "myJodaTime" : "2016-09-09T00:00:00.000Z",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/myentities/57eb759102ca691e90262ab3"
    },
    "myEntity" : {
      "href" : "http://localhost:8080/myentities/57eb759102ca691e90262ab3"
    }
  }
}
````

Notice the difference in the Joda DateTime representation.