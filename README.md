# S7_test
To run project -> download .jar file and run with "java -jar ./s7_test-1.0-SNAPSHOT"

Here are some info about project:

GET request : localhost:8078/flight/{flightClass}
  please write "economy" or "business" to check how many places left in flight class
  
GET request : localhost:8078/flight/info
  returns list of passengers grouped by their flight class
  
POST request : localhost:8078/flight/register
  Request body : 
  {
    "name":{}, // name of the passenger
    "flightClass":{} // flight class needed
}
returns 200 if passenger registered successfully, 500 if there are no places left in his class or if he already registered to the flight
