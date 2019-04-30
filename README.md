# Asset Manager REST service

A Spring project that implements a REST service to create, update, delete, and query asset records in a dockerized PostgreSQL database.

Assets can be queried by name, and query results can be ordered on arbitrary fields and paginated.

## Running the service

Start the docker container for the database (not provided in this repo):

```shell
docker-compose up
```

From the root of the project repo, using Maven start the service on localhost:8080:

```shell
mvn spring-boot:run
```

## Usage examples (with Postman)

Create an asset using the POST method and a request body (an asset object) of type application/json:

```shell
localhost:8080/assets
```

Update an asset with the given id using the POST method and a request body (an asset object) of type application/json:

```shell
localhost:8080/assets/{id}
```

Delete an asset with the given id using the DELETE method:

```shell
localhost:8080/assets/{id}
```

Find an asset with the given id using the GET method:

```shell
localhost:8080/assets/{id}
```

Find an all assets using the GET method, optionally sorted and paginated:

```shell
localhost:8080/assets?sort=brand&sort=type,desc&page=5&size=10
```

Query assets by name containing the given name substring using the GET method, optionally sorted and paginated:

```shell
localhost:8080/assets/search?name=Group&sort=brand&sort=name&page=4&size=10
```

Standard HTTP status codes are returned for the above requests.
