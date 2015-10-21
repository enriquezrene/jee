# jee
An useful project for begginers

If you want generate the project yourself, execute this command in terminal (You need have installed maven of course):
mvn archetype:generate -DarchetypeGroupId=org.jboss.spec.archetypes -DarchetypeArtifactId=jboss-javaee6-webapp-ear-blank-archetype

And answer the questions like this:

rene@rene-pc:~/Documents/rene/jee$ mvn archetype:generate -DarchetypeGroupId=org.jboss.spec.archetypes -DarchetypeArtifactId=jboss-javaee6-webapp-ear-blank-archetype
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] >>> maven-archetype-plugin:2.4:generate (default-cli) @ standalone-pom >>>
[INFO] 
[INFO] <<< maven-archetype-plugin:2.4:generate (default-cli) @ standalone-pom <<<
[INFO] 
[INFO] --- maven-archetype-plugin:2.4:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Interactive mode
[INFO] Archetype [org.jboss.spec.archetypes:jboss-javaee6-webapp-ear-blank-archetype:7.1.3.Final] found in catalog remote
Downloading: https://repo.maven.apache.org/maven2/org/jboss/spec/archetypes/jboss-javaee6-webapp-ear-blank-archetype/7.1.3.Final/jboss-javaee6-webapp-ear-blank-archetype-7.1.3.Final.jar
Downloaded: https://repo.maven.apache.org/maven2/org/jboss/spec/archetypes/jboss-javaee6-webapp-ear-blank-archetype/7.1.3.Final/jboss-javaee6-webapp-ear-blank-archetype-7.1.3.Final.jar (112 KB at 78.3 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/jboss/spec/archetypes/jboss-javaee6-webapp-ear-blank-archetype/7.1.3.Final/jboss-javaee6-webapp-ear-blank-archetype-7.1.3.Final.pom
Downloaded: https://repo.maven.apache.org/maven2/org/jboss/spec/archetypes/jboss-javaee6-webapp-ear-blank-archetype/7.1.3.Final/jboss-javaee6-webapp-ear-blank-archetype-7.1.3.Final.pom (6 KB at 20.1 KB/sec)
Define value for property 'groupId': : com.github
Define value for property 'artifactId': : demo
Define value for property 'version':  1.0-SNAPSHOT: : 1.0
Define value for property 'package':  com.github: : com.github.demo
[INFO] Using property: enterprise = false
[INFO] Using property: jboss-bom-enterprise-version = 1.0.4.Final-redhat-4
Confirm properties configuration:
**groupId: com.github**
**artifactId: demo**
**version: 1.0**
**package: com.github.demo**
enterprise: false
jboss-bom-enterprise-version: 1.0.4.Final-redhat-4
 Y: : y
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: jboss-javaee6-webapp-ear-blank-archetype:7.1.3.Final
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: com.github
[INFO] Parameter: artifactId, Value: demo
[INFO] Parameter: version, Value: 1.0
[INFO] Parameter: package, Value: com.github.demo
[INFO] Parameter: packageInPathFormat, Value: com/github/demo
[INFO] Parameter: package, Value: com.github.demo
[INFO] Parameter: version, Value: 1.0
[INFO] Parameter: groupId, Value: com.github
[INFO] Parameter: jboss-bom-enterprise-version, Value: 1.0.4.Final-redhat-4
[INFO] Parameter: artifactId, Value: demo
[INFO] Parameter: enterprise, Value: false
[INFO] Parent element not overwritten in /home/rene/Documents/rene/jee/demo/ejb/pom.xml
[INFO] Parent element not overwritten in /home/rene/Documents/rene/jee/demo/web/pom.xml
[INFO] Parent element not overwritten in /home/rene/Documents/rene/jee/demo/ear/pom.xml
[INFO] project created from Archetype in dir: /home/rene/Documents/rene/jee/demo
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 13:03.251s
[INFO] Finished at: Wed Oct 21 09:01:30 ECT 2015
[INFO] Final Memory: 18M/301M
[INFO] ------------------------------------------------------------------------

