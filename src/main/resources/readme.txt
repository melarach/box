mvn dockerfile:build // to build
Run: docker run -p 8080:8080 --rm mouhcineee/test:0.0.1-SNAPSHOT //to run
mvn dockerfile:push -Ddockerfile.useMavenSettingsForAuth=true // to push image to server



---
add server authentification to $MAVEN_HOME/settings.xml
<server>
  <id>docker.io</id>
  <username>login</username>
  <password>password</password>
</server>