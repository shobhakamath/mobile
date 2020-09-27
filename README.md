The mobile service can be tested using  the following url:

https://mobilebrands.herokuapp.com/mobile/search?sim=esim returns valid response

https://mobilebrands.herokuapp.com/mobile/search?sim=esim&announceDate=2019 return empty values


Validation response :
https://mobilebrands.herokuapp.com/mobile/search?sim1=esim

{"errors":["sim1"],"message":"The request parameters are invalid"}

#Local testing

The application can be run locally by the following steps:

mvn clean install

mvn springboot:run

#Cloud testing

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
