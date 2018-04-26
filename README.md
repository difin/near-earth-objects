# near-earth-objects

This application retrieves the list of near-earth-objects (NEOs) using NASA API, and:
- Displays total number of NEOs retrieved
- Finds the largest NEO in size **based on the max diameter** and display its info in a 'pretty-print' JSON format
- Finds the closest **to Earth** NEO for **today's date** and display its info in 'pretty-print' JSON format

## System Requirements
- Java 8
- Maven
- Internet access

## Technologies Used
- Java with Java 8 features (parallel streams, lambdas, java.util.Optional)
- Spring (Dependency Injection, RestTemplate)
- Jackson (JSON marshaling/unmarshaling)
- Maven (Dependency Management & build)
- JUnit, Hamcrest Matchers & Mockito for Testing

## How to Build
```
mvn clean install
```

## How to Run Unit Tests
Unit tests are executed as part of build command above, but can be run separately (after build) as following:
```
mvn test
```

## How to Run the Application from Command Line

```
cd target
java -jar near-earth-objects-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Proof that this code is functional

- Unit tests
- Sample output (below)
- Can be built and executed on any environment which meets the system requirements (above)

## Sample output
```
Apr 26, 2018 3:42:42 AM org.difin.neo.services.NeoRetrievalService getNeos
INFO: Starting retrieval of all NEOs, please wait...
Apr 26, 2018 3:44:53 AM org.difin.neo.services.NeoRetrievalService getNeos
INFO: Retrieval of all NEOs completed

Apr 26, 2018 3:44:53 AM org.difin.neo.services.NeoRetrievalService findLargestNeo
INFO: 
Starting to look for the largest NEO
Apr 26, 2018 3:44:53 AM org.difin.neo.services.NeoRetrievalService findLargestNeo
INFO: Lookup for the largest NEO completed

Apr 26, 2018 3:44:53 AM org.difin.neo.services.NeoRetrievalService findClosestToEarthNeo
INFO: Starting to look for the closest to Earth NEO
Apr 26, 2018 3:44:57 AM org.difin.neo.services.NeoRetrievalService findClosestToEarthNeo
INFO: Lookup for the closest to Earth NEO completed

-----------------------------------------------------
Total number of NEOs: 18658
-----------------------------------------------------
Largest NEO:
{
  "links" : {
    "self" : "https://api.nasa.gov/neo/rest/v1/neo/2001036?api_key=nkyGvNDnBXs7XoGU1R85FdNxq0LR6vXntVkOdzNm"
  },
  "neo_reference_id" : "2001036",
  "name" : "1036 Ganymed (1924 TD)",
  "nasa_jpl_url" : "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2001036",
  "absolute_magnitude_h" : "9.45",
  "estimated_diameter" : {
    "kilometers" : {
      "estimated_diameter_min" : 34.241673084,
      "estimated_diameter_max" : 76.5667086792
    }
  },
  "close_approach_data" : [ {
    "close_approach_date" : "1910-02-25",
    "miss_distance" : {
      "astronomical" : 1.9562567743
    },
    "relative_velocity" : {
      "kilometers_per_second" : "6.3038677758",
      "kilometers_per_hour" : "22693.9239930329"
    },
    "orbiting_body" : "Juptr"
  }, {
    "close_approach_date" : "1911-10-15",
    "miss_distance" : {
      "astronomical" : 0.3813625431
    },
    "relative_velocity" : {
      "kilometers_per_second" : "17.0936926953",
      "kilometers_per_hour" : "61537.2937030022"
    },
    "orbiting_body" : "Earth"
  }, {
    "close_approach_date" : "1924-10-17",
    "miss_distance" : {
      "astronomical" : 0.4962742563
    },
    "relative_velocity" : {
      "kilometers_per_second" : "19.3628604719",
      "kilometers_per_hour" : "69706.2976987352"
    },
    "orbiting_body" : "Earth"
  }, {
    "close_approach_date" : "1998-10-14",
    "miss_distance" : {
      "astronomical" : 0.4642629762
    },
    "relative_velocity" : {
      "kilometers_per_second" : "13.6399797421",
      "kilometers_per_hour" : "49103.9270715352"
    },
    "orbiting_body" : "Earth"
  }, {
    "close_approach_date" : "2011-10-13",
    "miss_distance" : {
      "astronomical" : 0.3591042827
    },
    "relative_velocity" : {
      "kilometers_per_second" : "14.3047044441",
      "kilometers_per_hour" : "51496.9359986876"
    },
    "orbiting_body" : "Earth"
  }, {
    "close_approach_date" : "2024-10-13",
    "miss_distance" : {
      "astronomical" : 0.3740971683
    },
    "relative_velocity" : {
      "kilometers_per_second" : "16.3343762188",
      "kilometers_per_hour" : "58803.7543875511"
    },
    "orbiting_body" : "Earth"
  }, {
    "close_approach_date" : "2037-10-15",
    "miss_distance" : {
      "astronomical" : 0.4661876809
    },
    "relative_velocity" : {
      "kilometers_per_second" : "18.6810564978",
      "kilometers_per_hour" : "67251.8033920393"
    },
    "orbiting_body" : "Earth"
  }, {
    "close_approach_date" : "2040-06-30",
    "miss_distance" : {
      "astronomical" : 1.9576240147
    },
    "relative_velocity" : {
      "kilometers_per_second" : "6.6728724113",
      "kilometers_per_hour" : "24022.3406805796"
    },
    "orbiting_body" : "Juptr"
  }, {
    "close_approach_date" : "2050-12-07",
    "miss_distance" : {
      "astronomical" : 0.0956584456
    },
    "relative_velocity" : {
      "kilometers_per_second" : "14.9803020979",
      "kilometers_per_hour" : "53929.0875525725"
    },
    "orbiting_body" : "Mars"
  }, {
    "close_approach_date" : "2088-05-12",
    "miss_distance" : {
      "astronomical" : 1.959770709
    },
    "relative_velocity" : {
      "kilometers_per_second" : "6.220394144",
      "kilometers_per_hour" : "22393.4189184226"
    },
    "orbiting_body" : "Juptr"
  }, {
    "close_approach_date" : "2124-10-12",
    "miss_distance" : {
      "astronomical" : 0.3763476284
    },
    "relative_velocity" : {
      "kilometers_per_second" : "14.4716409786",
      "kilometers_per_hour" : "52097.9075230075"
    },
    "orbiting_body" : "Earth"
  }, {
    "close_approach_date" : "2137-10-12",
    "miss_distance" : {
      "astronomical" : 0.3591572808
    },
    "relative_velocity" : {
      "kilometers_per_second" : "15.0172117072",
      "kilometers_per_hour" : "54061.9621457756"
    },
    "orbiting_body" : "Earth"
  }, {
    "close_approach_date" : "2150-10-13",
    "miss_distance" : {
      "astronomical" : 0.4125989985
    },
    "relative_velocity" : {
      "kilometers_per_second" : "16.9054743401",
      "kilometers_per_hour" : "60859.7076241994"
    },
    "orbiting_body" : "Earth"
  }, {
    "close_approach_date" : "2176-12-16",
    "miss_distance" : {
      "astronomical" : 0.0286838076
    },
    "relative_velocity" : {
      "kilometers_per_second" : "15.7498661969",
      "kilometers_per_hour" : "56699.5183089062"
    },
    "orbiting_body" : "Mars"
  } ],
  "is_potentially_hazardous_asteroid" : false
}
-----------------------------------------------------
Closest NEO:
{
  "links" : {
    "self" : "https://api.nasa.gov/neo/rest/v1/neo/3803910?api_key=HlgpL20gLFA8s5FiCQjD9Vv4bmxvm9gaQ2Av1M7C"
  },
  "neo_reference_id" : "3803910",
  "name" : "(2018 HP)",
  "nasa_jpl_url" : "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3803910",
  "absolute_magnitude_h" : "26.287",
  "estimated_diameter" : {
    "kilometers" : {
      "estimated_diameter_min" : 0.0146945055,
      "estimated_diameter_max" : 0.0328579133
    }
  },
  "close_approach_data" : [ {
    "close_approach_date" : "2018-04-26",
    "miss_distance" : {
      "astronomical" : 0.0297829546
    },
    "relative_velocity" : {
      "kilometers_per_second" : "10.3296230856",
      "kilometers_per_hour" : "37186.6431082723"
    },
    "orbiting_body" : "Earth"
  } ],
  "is_potentially_hazardous_asteroid" : false
}
-----------------------------------------------------
```
