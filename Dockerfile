####################################################################################
# Imagem base das demais
####################################################################################

FROM andreptb/oracle-java:8-alpine AS base

WORKDIR /data/

ENV LC_ALL=C

RUN \
    apk update  && \
    apk add libstdc++



####################################################################################
# Imagem de build com gradle
####################################################################################

FROM base AS build

ADD . .

ARG ADDITIONAL_TASK_GRADLE

RUN \
    ./gradlew build ${ADDITIONAL_TASK_GRADLE} --info && \
    mv build/libs/*.jar app.jar



####################################################################################
# Imagem da execução da aplicação
####################################################################################

FROM base AS exec

COPY --from=build /data/app.jar app.jar

ARG PROFILES
ARG PORT
ARG SPRING_PROFILES_ACTIVE
ARG JAVA_OPTS
ARG SERVER_PORT
ARG PATH_JAR

ENV SPRING_PROFILES_ACTIVE ${SPRING_PROFILES_ACTIVE:-${PROFILES:-default}}
ENV JAVA_OPTS ${JAVA_OPTS:-'-Xmx2g'}
ENV SERVER_PORT ${SERVER_PORT:-${PORT:-9999}}

EXPOSE ${SERVER_PORT}

CMD java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar app.jar
