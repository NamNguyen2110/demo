FROM --platform=linux/amd64 openjdk:11.0.7
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /usr/app/app.jar
ENV SPRING_PROFILES=dev
ENV DB_USERNAME=sa
ENV DB_PASSWORD=password
EXPOSE 8000
WORKDIR /usr/app
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES}", "-jar", "/usr/app/app.jar"]
