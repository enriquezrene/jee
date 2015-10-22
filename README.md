# JPA - concepts related to entity manager

## Dependencies added
log4j 
'''xml
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>
'''

How to use the logger:
<pre>
private static final Logger LOG = Logger.getLogger(MyService.class);
</pre>

## Persisting data
@PersistenceContext
javax.persistence.EntityManager

@PersistenceContext
private EntityManager em;

@PersistenceContext(unitName="NameOfPU")
private EntityManager em;

## Basic methods
em use object instances
We will use a Department instance, because is an object :)
Department extends java.lang.Object

em.persist(department);
<pre>
16:35:46,771 INFO  [com.github.demo.em.MyController] (http--127.0.0.1-8080-1) MyController is being created
16:35:46,772 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: select tbl.next_val from hibernate_sequences tbl where tbl.sequence_name=? for update
16:35:46,773 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: update hibernate_sequences set next_val=?  where next_val=? and sequence_name=?
16:35:46,774 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: insert into tbl_department (dep_name, dep_id) values (?, ?)
</pre>

em.merge(department);
<pre>
16:35:10,907 INFO  [com.github.demo.em.MyController] (http--127.0.0.1-8080-1) MyController is being created
16:35:10,908 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: select department0_.dep_id as dep1_16_0_, department0_.dep_name as dep2_16_0_ from tbl_department department0_ where department0_.dep_id=?
16:35:10,909 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: update tbl_department set dep_name=? where dep_id=?
</pre>

em.remove(department);
<pre>
16:36:29,787 INFO  [com.github.demo.em.MyController] (http--127.0.0.1-8080-1) MyController is being created
16:36:29,788 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: select department0_.dep_id as dep1_16_0_, department0_.dep_name as dep2_16_0_ from tbl_department department0_ where department0_.dep_id=?
16:36:29,789 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: delete from tbl_department where dep_id=?
</pre>

## Query data
em.createQuery("SELECT d FROM Department d")
<pre>
16:37:06,647 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: select department0_.dep_id as dep1_16_, department0_.dep_name as dep2_16_ from tbl_department department0_
16:37:06,648 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 1: accounting
16:37:06,648 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 2: technology
16:37:06,648 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 4: technology
16:37:06,649 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 5: technology
</pre>

em.createNativeQuery("select * from tbl_department")
<pre>
16:37:06,649 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: select * from tbl_department
16:37:06,650 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 1: accounting
16:37:06,651 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 2: technology
16:37:06,651 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 4: technology
16:37:06,651 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 5: technology
</pre>

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

<pre>
Driver Class: 	org.h2.Driver
JDBC URL:	jdbc:h2:mem:test;DB_CLOSE_DELAY=-1
User Name:	sa
Password:	sa
</pre>

Then you can see the tables:
<pre>
-HIBERNATE_SEQUENCES 	(To generate PKs)
-TBL_DEPARTMENT 	
-TBL_EMPLOYEE 		(FK with TBL_DEPARTMENT)
</pre>

Artifact to avoid write dummy code:

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.16.6</version>
		</dependency>
