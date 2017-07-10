# UmweltbundesamtDeAirQualityImporter
- Importer for Current concentrations of air pollutants in Germany
- No need for url (imports the last day data automatically)

## Use the docker
#### Pulling the image:
```sh
$ docker pull ahmadjawidjami/umwelt_airquality_importer
```
#### Running with sample environment variables:
```sh
$  docker run \
--env "KAFKA_BOOTSTRAP_SERVERS=localhost:9092" \
--env "KAFKA_BROKER_LIST=localhost:9092" \
--env "KAFKA_TOPIC=airQualityGermany" \
ahmadjawidjami/umwelt_airquality_importer
```
#### Mandatory enviroment variables:
- KAFKA_BOOTSTRAP_SERVERS
- KAFKA_BROKER_LIST

#### Optional environment variable
- KAFKA_TOPIC &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; //Defaults to 'airQualityGermany'



