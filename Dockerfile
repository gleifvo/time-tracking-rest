FROM openjdk:8u171-jdk as builder

ARG ROOT_DIR=/app

COPY . $ROOT_DIR
WORKDIR $ROOT_DIR
RUN ./gradlew bootRepackage

FROM openjdk:8u171-jre

ARG ROOT_DIR=/app

COPY --from=builder $ROOT_DIR/build/libs/*.jar .
CMD java -jar *.jar