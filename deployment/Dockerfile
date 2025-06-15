FROM eclipse-temurin:21-jdk-alpine
RUN adduser -D -H appuser
VOLUME /tmp
COPY *.jar PruebaTecnicaNequi.jar
ENV JAVA_OPTS=""
# Replace with a non-root user to avoid running the container with excessive privileges
USER appuser
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar PruebaTecnicaNequi.jar" ]
