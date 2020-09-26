# mobile

In the cloud environment do the following steps:

# clone the repo 
git clone https://github.com/shobhakamath/mobile.git

# build the docker container
docker build -t mobile .
# run the container
docker run --name mobile-app -p8080:8080 -d mobile

# print the docker images
docker images 

# print the docker containers
docker ps -a

# checking the docker logs for debugging
docker logs mobile-app
