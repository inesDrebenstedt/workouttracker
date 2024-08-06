REM Build the Docker image
docker build -t fitcontrol-mongodb .

REM Run the Docker container
REM docker run --name fitcontrol-mongodb -d -p 27017:27017 mongo


 docker run --name fitcontrol-mongodb -d -p 27017:27017  -v %cd%/mongod.conf:/etc/mongod.conf mongo --config /etc/mongod.conf