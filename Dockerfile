FROM openjdk:11-jdk

ENV TZ=America/Sao_Paulo

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone \
    && apt-get update && apt-get install -y curl unzip tzdata

WORKDIR /app

COPY ./build/libs .

EXPOSE 8080

EXPOSE 9090

CMD ["sh", "-c", "java -jar springbootdemo.jar" ]