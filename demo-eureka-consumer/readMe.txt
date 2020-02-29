1) Build mvn clean package for demo-eureka-docker.
2) Build image :-docker build  . -t  demo-eureka-docker
3)Run Image :- docker run -p 9091:9091 --name demo-eureka-docker -d demo-eureka-docker
4) Check eureka is running in a container or not . http://localhost:9091


5)Build docker producer image :- docker build  . -t  demo-eureka-producer

6) docker run -p 5656:5656 --name demo-eureka-producer --link demo-eureka-docker:demo-eureka-docker -d demo-eureka-producer
7) Check eureka url in application.properties . It is  cntainername:port

8) Build docker producer image :- docker build  . -t  demo-eureka-consumer

9) docker run -p 5657:5657 --name demo-eureka-consumer --link demo-eureka-docker:demo-eureka-docker --link demo-eureka-producer:demo-eureka-producer -d demo-eureka-consumer

10)Check url for calling producer in code . Note that we are not using port because it has been registered with eureka server.
If it would not have been registered with eureka, then we have to give the containername:port . But still remember
if we want to communicate between containers then we have to link them using --link while running the container

10) http://localhost:5657/display. Voillllaaaaaaaa


Very Important notes :-

We can see its a lot of pain to run the containers everytime with lengthy commands . To avoid this docker has come up with docker-compose
command to handle multiple containers . Below is the docker-compose.yml file . Create the docker-compose.yml file anywhere in the system.
go to the specified path in the power shell and run docker-compose up command.Make sure individual docker files are present the path specified.

version: '3.3'
services:
 demo-eureka-docker:
  build: 'C:\Users\Gaurav Garg\Downloads\demo-eureka-docker\demo-eureka-docker\'
  ports:
   - 9091:9091
 demo-eureka-producer:
  build: 'C:\Users\Gaurav Garg\Downloads\demo-eureka-producer\demo-eureka-producer\'
  ports:
   - 5656:5656
  links:
   - demo-eureka-docker
 demo-eureka-consumer:
  build: 'C:\Users\Gaurav Garg\Desktop\Eclipseworkspace\demo-eureka-consumer\'
  ports:
   - 5657:5657
  links:
   - demo-eureka-docker
  links:
    - demo-eureka-producer
  