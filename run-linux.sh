docker-compose down &&

cd authorization-service &&

mvn clean package -DskipTests &&

docker build -t sunshine/authorization-service . &&

cd .. &&

cd items-service &&

mvn clean package -DskipTests &&

docker build -t sunshine/items-service . &&

docker-compose up -d

