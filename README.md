# Springboot demo application

Springboot scaffold application with a simple endpoint and actuator exposed metrics Application is exposed on port 8080

## Endpoints

* GET / => displays application name and version

* GET /hello?name=<any name> => returns a greeting based on name parameter

## Monitoring

Actuator metrics are exposed on port 9090

# How to build:

First, clone this repo: https://github.com/umovme/umovme-scaffold and run:

```docker build -t umovmetraining/umovme-scaffold```

# How to push:

Login Docker hub: ```docker login```

Push the image:

```docker push umovmetraining/umovme-scaffold```

# How to run:

In the server, run:

```docker pull umovmetraining/umovme-scaffold```

And:

```docker run -d -p 80:8080 -p 9090:9090 umovmetraining/umovme-scaffold```

Note: We will expose the tcp ports 80 and 9090, the first we will use for web access and the second to Prometheus Scrap.

# How to test

Access in your browser: http://server-ip if App name and version apresent to you, so it's works!

You can access too: http://server-ip/hello?name=<any name> if Hello <any name> apresent to you, so it's works!

Access too: http://server-ip:9090/metrics and all the metrics for this app will showing