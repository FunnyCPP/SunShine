docker-compose down &&

cd authorization-service &&

mvn clean package -DskipTests &&

cp target/authorization-service-0.0.1-SNAPSHOT.jar authorization-service-0.0.1-SNAPSHOT.jar &&

docker build -t sunshine/authorization-service . &&

docker-compose up -d

