FROM ubuntu:latest

EXPOSE 8080

COPY target/lobby lobby
ENTRYPOINT ["/lobby"]