# First time for BWCE . We need to build bwce image first .Go to folder C:\tibco\bwce\2.4\docker and read the README file and do the steps.

1) Build an bwce project . Export the ear and in docker file add the simple below steps :-
	FROM bwce:latest
	ADD DemoDockerProject_1.0.0.ear .
	EXPOSE 8056

2) Open the prject and notice we are registering service in Eureka server and calling the other java microservice using the Eureka discovery . 
3) Debugging purpose :- To register service in Eureka at runtime or bw 6 :- Run>DebugConfigurations>Environment>Add new Variable with name =EUREKA_SERVER_URL, value =http://machinename:port.
 Make sure not to append /eureka in the end . I dont know why it does not work with that but in springboot we append in the /eureka in url.

4) Check in the eureka server if service has registered in the debug mode .

5) Notice the below docker-compose.yml file . Its present in GIT in demo-eureka-consumer code if required someday.
Container demo-eureka-docker: wrttien in spring boot . Its eureka server . Code is present in GIT.
Container demo-eureka-producer :- wrttien in spring boot . registered with eureka. Code is present in GIT.Backened code.
Container demo-eureka-consumer:- wrttien in spring boot . registered with  eureka server . it calls demo-eureka-producer.
Container demo-eureka-bwce: written in bwce . regisered with eureka.calls demo-eureka-consumer.notice the configuration of eureka server in the end of yaml file. Also in the
bwce code we are using the service name while calling demo-eureka-consumer instead of host port.links mentioned below really ar enot required . Just i mentioned
here to know which microservice is being linked to which without checking the code

version: '3.3'
services:
 demo-eureka-docker:
  build: 'C:\Users\Gaurav Garg\git\demo-eureka-docker\demo-eureka-docker\'
  ports:
   - 9091:9091
 demo-eureka-producer:
  build: 'C:\Users\Gaurav Garg\git\demo-eureka-docker\demo-eureka-producer\'
  ports:
   - 5656:5656
  links:
   - demo-eureka-docker
 demo-eureka-consumer:
  build: 'C:\Users\Gaurav Garg\git\demo-eureka-docker\demo-eureka-consumer\'
  ports:
   - 5657:5657
  links:
   - demo-eureka-docker
  links:
   - demo-eureka-producer
 demo-eureka-bwce:
  build: 'C:\Users\Gaurav Garg\workspace\bwce\EAR_DOCKER\'
  ports:
   - 8056:8056
  links:
   - demo-eureka-docker
  links:
   - demo-eureka-consumer
  environment:
   EUREKA_SERVER_URL: http://demo-eureka-docker:9091
   
   
  