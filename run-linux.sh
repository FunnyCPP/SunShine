docker-compose down &&

cd authorization-service &&

mvn clean package -DskipTests &&

docker build -t sunshine/authorization-service . &&

docker-compose up -d

