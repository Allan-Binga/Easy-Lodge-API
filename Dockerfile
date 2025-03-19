#JDK 23 image
FROM openjdk:23-jdk-slim

# Create group and system user
RUN addgroup --system spring && adduser --system --ingroup spring binga

# Switch to non-root user
USER binga

#Argument
ARG JAR_FILE=target/*.jar

#Copy
COPY ${JAR_FILE} app.jar

#Run Applications
ENTRYPOINT ["java","-jar","/app.jar"]
