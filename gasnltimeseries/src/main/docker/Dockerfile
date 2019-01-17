FROM openjdk:latest
ENV APP_HOME /usr/apps
EXPOSE 8081 8778 9779
COPY maven $APP_HOME
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar *.jar"]