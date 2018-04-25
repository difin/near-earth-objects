# near-earth-objects

# Sample output

Starting retrieval of all NEOs
Retrieval of all NEOs completed in 152.147 seconds

Starting to look for the largest NEO
Lookup for the largest NEO completed in 0.04 seconds

Starting to look for the closest to Earth NEO
Lookup for the closest to Earth NEO completed in 0.092 seconds

-----------------------------------------------------
Total number of NEOs: 18658
-----------------------------------------------------
Largest NEO:
```
{
  "links" : {
    "self" : "https://api.nasa.gov/neo/rest/v1/neo/2001036?api_key=HlgpL20gLFA8s5FiCQjD9Vv4bmxvm9gaQ2Av1M7C"
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
  "close_approach_data" : [ ],
  "is_potentially_hazardous_asteroid" : false
}
```
-----------------------------------------------------
Closest NEO:
```
{
  "links" : {
    "self" : "https://api.nasa.gov/neo/rest/v1/neo/3803910?api_key=nkyGvNDnBXs7XoGU1R85FdNxq0LR6vXntVkOdzNm"
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
```
-----------------------------------------------------

Process finished with exit code 0
