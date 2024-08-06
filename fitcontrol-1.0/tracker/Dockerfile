FROM mongo

# Set environment variables for MongoDB user and admin credentials
ENV MONGO_INITDB_ROOT_USERNAME=rootuser
ENV MONGO_INITDB_ROOT_PASSWORD=rootpass
ENV MONGO_USERNAME=rootuser
ENV MONGO_PASSWORD=rootpass
ENV MONGO_DB=fitcontroldb

# Copy MongoDB initialization script to the container
COPY init-mongo.js /docker-entrypoint-initdb.d/

# Expose MongoDB port
EXPOSE 27017
