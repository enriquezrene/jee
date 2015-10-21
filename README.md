# JPA - Basic concepts

## Table info
@Entity
@Table

## PK info
@Id
@GeneratedValue

## Column info
@Column

## Relations info
@OneToMany
@ManyToOne

Change to demo dir:
cd /path/.../demo

<pre>
mvn clean
mvn install

cp ear/target/demo-ear.ear /path/to/jboss-as-7.1.1.Final/standalone/deployments/

JBOSS_HOME: /path/to/jboss-as-7.1.1.Final/
</pre>

To visualize the tables, JBOSS_HOME/standalone/deployments has the h2console.war

To run JBoss AS
sh JBOSS_HOME/bin/standalone.sh

login to database console:
http://localhost:8080/h2console/

Driver Class: 	org.h2.Driver
JDBC URL:	jdbc:h2:mem:test;DB_CLOSE_DELAY=-1
User Name:	sa
Password:	sa

Then you can see the tables:
-HIBERNATE_SEQUENCES 	(To generate PKs)
-TBL_DEPARTMENT 	
-TBL_EMPLOYEE 		(FK with TBL_DEPARTMENT)


Artifact to avoid write dummy code:

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.16.6</version>
		</dependency>
