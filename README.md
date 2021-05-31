# yantra
A micro-service inspired by the unix program bc

## Requirements
Java 16+

## Usage

```
mvn clean spring-boot:run
```

```
curl -i http://localhost:8080/add/2/to/3/
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 12

{"result":5}
```
