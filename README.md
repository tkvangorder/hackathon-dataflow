# Hack-a-thon Data Flow Project

This project explores how the Spring Cloud Data Flow Server Functions.

To get up and running :


1. Install Maven
2. Install Docker
2. Clone this Repo
3. Download the spring-cloud-dataflow-server-local (See http://cloud.spring.io/spring-cloud-dataflow/). The binary resources are not stored within this repo.
4. Put the spring-cloud-dataflow-server-local-x.x.x.RELEASE.jar in the direction `data-flow-server`, at the root directory where you cloned the repo.
5. Startup the docker infrastructure with `docker-compose up -d`
6. From the "hackathon" folder run `mvn clean package install`
7. Import the root maven project into your IDE.
8. Start the hack-config project as a Spring Boot application. This is just a config server that is pulling config from a local directory. You will need to adjust the local directory in the application.yml file before starting.
9. Start the Data flow server by running the script `start-data-flow-server.sh`

# hackathon project layout.

- domain-events = Common model objects used by all sources/sinks.
- hack-config = A Config server that reads yml files from a local file folder.
- source-* = Various pre-defined sources that read data from the Build.com database and publish that data via a stream.
- build-dataflow-apps.properties = A file that maps "application" names to maven coordinates. This can be used to import the build-specific sources/sinks into the data flow server.

# The data flow server

The data flow server can be accessed via `http://localhost:1234/dashboard`

- You can import the "default" application provided by the spring cloud project via the `Apps->Bulk Import Applications` and using the link http://bit.ly/Bacon-RELEASE-stream-applications-kafka-10-maven
- You can import the "build" applications, using `Apps->Bulk Import Applications` and selecting the file `build-dataflow-apps`

# Data Flow DSL

- This command starts an http server, where messages posted will pass to the transform, the transform will parse a json payload to extract a `name` attribute, and the result will be logged to a file.

`http --server.port=5555 | transform --expression="#jsonPath(payload, '$.name')" | file --directory=/tmp --suffix=log --name=example`

- This command is similar, except it is now using the build customer source. This source will publish a day's worth of customers data every 5 seconds, starting on 1/1/2017, and incrementing one day at a time until the current date is reached.

`build-customer | transform --expression="#jsonPath(payload, '$.email')" | file --directory=/tmp --suffix=log --name=customers`

- If you want to have a second consumer group assigned to the same stream, you can use a "destination" to route an existing stream into a new sink.

`:data-order > file --directory=/tmp --name=data-order`


