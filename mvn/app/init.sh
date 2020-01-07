mvn -B archetype:generate \
  -DarchetypeGroupId=org.apache.maven.archetypes \
  # -DarchetypeArtifactId=maven-archetype-site \ #create documentation site
  # -DarchetypeArtifactId=maven-archetype-webapp \ #war
  -DgroupId=com.mycompany.app \
  -DartifactId=my-app
