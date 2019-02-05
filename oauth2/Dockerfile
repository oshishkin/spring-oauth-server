FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY build/libs/wemboo-oauth-1.0.0.jar app.jar
COPY h2/wemboo_db.mv.db h2/wemboo_db.mv.db
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
