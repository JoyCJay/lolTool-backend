# Build
mvn package docker:build

# Run
docker run -p 9090:9090 -t joycjay/lol-loupe:v1

# Hint
docker stop <CONTAINER ID>
docker rm <CONTAINER ID>
docker rmi <IMAGE ID>

docker tag joycjay/lol-loupe joycjay/lol-loupe:v1
docker rmi joycjay/lol-loupe:latest
docker push joycjay/lol-loupe:v1