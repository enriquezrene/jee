# JEE - An example project for begginers

If you want generate the project yourself, execute this command in terminal (You need have installed maven of course):

mvn archetype:generate -DarchetypeGroupId=org.jboss.spec.archetypes -DarchetypeArtifactId=jboss-javaee6-webapp-ear-blank-archetype

And answer the questions like this:

<pre>
rene@rene-pc:~/Documents/rene/jee$ mvn archetype:generate -DarchetypeGroupId=org.jboss.spec.archetypes -DarchetypeArtifactId=jboss-javaee6-webapp-ear-blank-archetype
...
Define value for property 'groupId': : com.github
Define value for property 'artifactId': : demo
Define value for property 'version':  1.0-SNAPSHOT: : 1.0
Define value for property 'package':  com.github: : com.github.demo
...
jboss-bom-enterprise-version: 1.0.4.Final-redhat-4
Y: : y
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: jboss-javaee6-webapp-ear-blank-archetype:7.1.3.Final
...
</pre>

