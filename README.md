Egen Coding Challenge - Level 2



Steps

1) Compile and  generate jar

mvn clean package


2) Run

java -jar -Dbase.value=<base_weight> target/egen-be-challenge-0.0.1-SNAPSHOT.jar


Enter value for base_weight. [Example- -Dbase.value=150]

3) Test Project

mvn test

 OR

1) Shell Script to compile and run the project [for unix based platform] -

./run-all.sh


Enter value for base_weight.

 APIs Exposed

 Metrics

- Stores the data that comes from sensor

1) Create


POST Request => http://localhost:8080/metrics/create/


2) Read


GET Request => http://localhost:8080/metrics/read/


3) Read by Range


GET Request => http://localhost:8080/metrics/readRange/{startTime}/{endTime}



 Alerts

- Stores the alerts that were created by the rules

1) Read

GET Request => http://localhost:8080/alerts/read/


2) Read by Range


GET Request => http://localhost:8080/alerts/readRange/{startTime}/{endTime}


