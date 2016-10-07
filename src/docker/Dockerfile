FROM clubos/baseserver
RUN mkdir -p /var/www/localSQS
ADD LocalSQS.yml /var/www/localSQS
ADD local-sqs-1.0-SNAPSHOT.jar /var/www/localSQS
EXPOSE 8080
WORKDIR /var/www/localSQS
ENTRYPOINT ["java", "-jar","local-sqs-1.0-SNAPSHOT.jar", "server", "LocalSQS.yml"]
