FROM openjdk:8-jre

VOLUME /tmp

ADD Demo-0.0.1-SNAPSHOT.jar bot.jar

RUN bash -c 'touch /demo.jar'

# install curl
RUN apt-get -y -qq update && \
	apt-get install -y -qq curl && \
	apt-get clean

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/demo.jar"]
