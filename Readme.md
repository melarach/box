## The box has multiple modes

- R : Rest mode
- S : Secure mode : *base64*

## Your mission
- Fork this repo 
- Fix all red tests
- Implements the boxapp.Box Api using spring boot, ONE api must be implemented
  - decrypt a box content and return the json result
    
## Optional mission
Wrap all the code into a docker image a push it to docker Hub

## I finished, what should i do ?
email the github repo with dockerhub repo if you did it to : *boufnichel.mohamed@gmail.com* 

## to start correctly the projet, what should i do ?
- mvn dockerfile:build // to build
- Run: docker run -p 8080:8080 --rm mouhcineee/test:0.0.1-SNAPSHOT //to run
- mvn dockerfile:push -Ddockerfile.useMavenSettingsForAuth=true // to push image to server

---
- add server authentification to $MAVEN_HOME/settings.xml

`<server>
<id>docker.io</id>
<username>login</username>
<password>password</password>
</server>`
