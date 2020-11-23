# lolTool-backend
lo10 projet, une interface webservice
Application web répartie et architecture pour les services web.

• Développement d'une application répartie sur la base d'une analyse approfondie de l'architecture orientée Web Service qui supportera cette application.
• La construction et conception d'une base de données relationnelle et la connection entre le programme applicatif et la base de données

## Maven
- mvn clean
- mvn install
- mvn spring-boot:run

## Build
<!-- must run mvn install before  -->
mvn install
docker build --tag joycjay/lol-loupe:dev-back .

## Run
docker run -p 9090:9090 -t joycjay/lol-loupe:dev-back

## Hint
docker stop <CONTAINER ID>
docker rm <CONTAINER ID>
docker rmi <IMAGE ID>

docker tag joycjay/lol-loupe joycjay/lol-loupe:v1
docker rmi joycjay/lol-loupe:latest
docker push joycjay/lol-loupe:v1