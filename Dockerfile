FROM gradle:jdk8

MAINTAINER kevinvictorpinto@gmail.com 

RUN mkdir /home/gradle/playing-cards

WORKDIR /home/gradle/playing-cards

COPY . /home/gradle/playing-cards

RUN cd /home/gradle/playing-cards

RUN /usr/bin/gradle build

ENTRYPOINT ["java", "-jar", "./playing-cards-console-app/build/libs/playing-cards-console-app-1.0.0.jar"]

