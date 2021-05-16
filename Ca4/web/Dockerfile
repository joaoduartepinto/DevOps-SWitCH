FROM tomcat

RUN apt-get update -y

RUN apt-get install -f

RUN apt-get install git -y

RUN apt-get install nodejs -y

RUN apt-get install npm -y

RUN mkdir -p /tmp/build

WORKDIR /tmp/build/

RUN git clone https://joaoswitch@bitbucket.org/Joao_Pinto_1201765/devops-20-21-1201765.git

WORKDIR /tmp/build/devops-20-21-1201765/Ca4/tut-basic-docker

RUN ./gradlew clean build

RUN cp ./build/libs/tut-basic-gradle-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080