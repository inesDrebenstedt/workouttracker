REM do $ mvn package spring-boot:repackage first!!

REM Build the Docker image
docker build -t fitcontrol-backend:v1.0 .

REM Run the Docker container
 docker run --name fitcontrol-backend -d -p 8083:8083 -e SPRING_DATASOURCE_URL=jdbc:mariadb://172.17.0.2:3306/fitcontroldb -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=root fitcontrol-backend:v1.0
