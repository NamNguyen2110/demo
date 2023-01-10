cd ..
cd ..
mvn clean package -DSPRING_PROFILE=dev
docker build -f deployment/docker/Dockerfile -t australia-assignment:latest .
docker rm -f australia-assignment
# Choose 1 or 2
#1) run docker container
docker run -d australia-assignment:latest australia-assignment
#2) run docker-compose
#cd ./deployment/docker
#docker-compose down
#docker-compose up -d