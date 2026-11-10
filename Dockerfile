# Buoc 1: Build ung dung Java Web
FROM maven:3.10-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -B clean package -DskipTests

# Buoc 2: Chay ung dung bang Tomcat 10.1
FROM tomcat:10.1-jre17-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /app/target/baitapchuong2.war /usr/local/tomcat/webapps/ROOT.war

ENV PORT=8080
EXPOSE 8080

CMD ["catalina.sh", "run"]
