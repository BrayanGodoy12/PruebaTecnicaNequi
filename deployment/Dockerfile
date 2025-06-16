FROM eclipse-temurin:21-jdk-alpine

# Crea el usuario
RUN adduser -D -H appuser

# Instala herramientas necesarias
RUN apk update && apk add --no-cache ca-certificates openssl

# Copia el JAR y el certificado
COPY *.jar PruebaTecnicaNequi.jar
COPY rds-exact.pem /tmp/rds-exact.pem

# Importar el certificado en el keystore
RUN keytool -import -noprompt \
    -trustcacerts \
    -alias rds-cert \
    -file /tmp/rds-exact.pem \
    -keystore $JAVA_HOME/lib/security/cacerts \
    -storepass changeit

ENV JAVA_OPTS=""
USER appuser

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar PruebaTecnicaNequi.jar" ]
