# rss-reader

The goal of this application is to be able to distribute data from different feeds including images to clients.

The project is a microservice that polls a news feed from http://feeds.nos.nl/nosjournaal?format=xml and stores the data in an SQL database.

All layers have been tested with Junit, AssertJ, Suite and Spring Test.

## Technologies

* [SpringBoot] - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".!
* [H2] - H2 is a relational database management system written in Java. It can be embedded in Java applications or run in client-server mode
* [Maven] - Maven is a build automation tool used primarily for Java projects.
* [Junit] - JUnit is a unit testing framework for the Java programming language
* [Swagger] - Swagger is an open-source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services
* [Git] - Git is a distributed version-control system for tracking changes in source code during software development.
* [Docker] - Docker is a set of coupled software-as-a-service and platform-as-a-service products that use operating-system-level virtualization to develop and deliver software in packages called containers
* [Jenkins] - Jenkins is an open source automation server written in Java. Jenkins helps to automate the non-human part of the software development process, with continuous integration and facilitating technical aspects of continuous delivery.
* [Kubernetes] - Kubernetes (K8s) is an open-source system for automating deployment, scaling, and management of containerized applications 

## Endpoint to test

After running you can test two endpoints.

```sh
$ http://localhost:8180/swagger-ui.html#/
$ http://localhost:8180/h2-console
```

__Note:__ 
* Swagger request parameter. __format:__ xml 
* Password for H2 db. __password:__ kpayares

## How to run it

There are three different ways to run the project.
 1) run with an IDE, for example Spring Tools 4.
 2) By using Docker engine.
 3) By using Kubernetes (Deployment is provided)

### Run it with Docker

__Note__: Docker engine must be installed.

Open cmd in the root project and type

```sh
$ mvn clean package docker:build
```

This previous command will push the docker image in DockerHub: __stevenxs/rss-service:latest__

Pull the images with the following command.
```sh
$ docker pull stevenxs/rss-service:latest
```
Run the container with the following command.
```sh
$ docker run -p 8180:8180 --name rss-service stevenxs/rss-service:latest
```
## Deploying with Jenkins

1) Install Jenkins.
2) Fork the project into your own repository.
3) Connect Jenkins with your own repository.
4) Create a multibranch pipeline and associate your own repository with Jenkins.
5) Make a change in the repository to start the workflow process in Jenkins.

__Note__: associate jdk8 and maven with the Jenkins global configuration

#### Jenkins Workflow

As soon you made a push of your code in Github, Jenkins will scan your repository, and the Pipeline will start, the Jenkins Pipeline follows the next stages.

1) Initialize: Clean the project.
2) Compile: Compile the project.
3) Test: Test the project.
4) Build: Package the project into a docker image and push it into the DockerHub repository.
5) Deploy: Run K8S deploy in local cluster as follow.
```sh
kubectl create -f rss-service-deployment-manifest.yaml
```
## Check all with K8S

__note__: Kubectl must be installed, Docker for desktop include a K8S installation.

The __rss-service-deployment-manifest.yml__ included a service and a deployment, the service acts as a load balancer of 3 replicas specified in the deployment.

__note__: verify the context of your K8S.
```sh
kubectl config get-contexts
```
Expected output: * docker-for-desktop or docker-desktop according to your docker installation.

Finally run the next command to check if everything went well.
```sh
kubectl get svc,deployment,pod
```
Expected output:

| NAME              | TYPE       | CLUSTER-IP   |EXTERNAL-IP| PORT(S) | AGE |
| ------            | ------     | ------       | ------    | ------  | --- |
|service/kubernetes | ClusterIP  | 10.96.0.1    | <none>    | 443/TCP |3m13s|
|service/rss-service|LoadBalancer|10.105.152.174| localhost |8180:30943/TCP|47s|

| NAME                              | READY | UP-TO-DATE| AVAILABLE | AGE |
| --------------------------------- | ----- | --------- | --------- | --- |
| deployment.extensions/rss-service | 3/3   | 3         | 3         | 47s |

| NAME                           |  READY  | STATUS  |  RESTARTS |  AGE |
| ------------------------------ | ------  | ------  | --------- | ---- |
|pod/rss-service-889b68887-6wklq |  1/1    | Running |  0        |  47s |
|pod/rss-service-889b68887-7m44k |  1/1    | Running |  0        |  47s |
|pod/rss-service-889b68887-qmxc8 |  1/1    | Running |  0        |  47s |

After it, the application will be ready to test it.

***
This file was generated by https://dillinger.io/

   [SpringBoot]: <https://spring.io/projects/spring-boot>
   [H2]: <https://www.h2database.com/>
   [Maven]: <https://maven.apache.org/>
   [Junit]: <https://junit.org/junit5/>
   [Swagger]: <https://swagger.io/>
   [Git]: <https://git-scm.com/>
   [Docker]: <https://www.docker.com/>
   [Jenkins]: <https://jenkins.io/>
   [Kubernetes]: <https://kubernetes.io/>
