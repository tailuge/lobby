# Lobby

Players join the Lobby to create a Game and await pairing.
(A project to play with GraalVM, docker and render.com hosting)

### Local use

* Swagger: http://localhost:8080/swagger-ui/index.html
* HAL: http://localhost:8080/explorer/index.html#uri=/
* Logs: http://localhost:8080/actuator/logfile

### GitHub action

Builds and deploys graalvm image to docker.io

https://hub.docker.com/repository/docker/tailuge/lobby

### Hosting

Docker container runs on render.com free tier (~3 min cold start)

* service: https://tailuge-lobby.onrender.com/test.html
* Swagger: https://tailuge-lobby.onrender.com/swagger-ui/index.html
* Logs: https://tailuge-lobby.onrender.com/actuator/logfile