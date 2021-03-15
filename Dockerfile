FROM gradle:jdk11 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon 

FROM openjdk:11-jdk

ENV TZ=America/Sao_Paulo

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone \
    && apt-get update && apt-get install -y curl unzip tzdata

WORKDIR /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/springbootdemo.jar

EXPOSE 8080

EXPOSE 9090

CMD ["sh", "-c", "java -jar /app/springbootdemo.jar" ]