FROM openjdk:latest
ENV APP_HOME /usr/apps
ENV MSG_1 ${mock.message}
ENV MSG_2 ${dummy.message}
EXPOSE 8080 8778 9779
COPY maven $APP_HOME
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar *.jar"]