# JPA - concepts related to entity manager

## Main annotation
Mark the class as managed by the container:
<pre>
@ManagedBean
</pre>

## Annotations for define the scope

Demo page:
<pre>
http://localhost:8080/demo-web/scopes.jsf
</pre>


###@RequestScoped
When you press the button, the info message should be printed

<pre>
@ManagedBean
@RequestScoped
public class RequestController extends CommonController {

    private static final Logger LOG = Logger.getLogger(RequestController.class);

    public RequestController() {
        LOG.info(RequestController.class.getName() + "...");
    }
}
</pre>

Output:
<pre>
09:07:00,015 INFO  [com.github.demo.scopes.RequestController] (http--127.0.0.1-8080-1) com.github.demo.scopes.RequestController...
09:07:10,030 INFO  [com.github.demo.scopes.RequestController] (http--127.0.0.1-8080-1) com.github.demo.scopes.RequestController...
09:07:10,752 INFO  [com.github.demo.scopes.RequestController] (http--127.0.0.1-8080-1) com.github.demo.scopes.RequestController...
</pre>

###@ViewScoped
When you press F5 button, and then press view button the info message should be printed only one time:

<pre>
@ViewScoped
@ManagedBean
public class ViewController extends CommonController {

    private static final Logger LOG = Logger.getLogger(ViewController.class);

    public ViewController() {
        LOG.info(ViewController.class.getName() + "...");
    }
}
</pre>

Output pressing the button n-times:
<pre>
09:17:16,984 INFO  [com.github.demo.scopes.ViewController] (http--127.0.0.1-8080-1) com.github.demo.scopes.ViewController...
</pre>

NOTE: If you press the F5 button and then press view-button, only one time the message should be printed


###@SessionScoped
When you open the browser, then press session-button, only one time the message should be printed

<pre>
@SessionScoped
@ManagedBean
public class SessionController extends CommonController {

    private static final Logger LOG = Logger.getLogger(SessionController.class);

    public SessionController() {
        LOG.info(SessionController.class.getName() + "...");
    }
}
</pre>

Output when you press button and refresh the page n-times:
<pre>
09:23:50,456 INFO  [com.github.demo.scopes.SessionController] (http--127.0.0.1-8080-1) com.github.demo.scopes.SessionController...
</pre>

###@ApplicationScoped
When you request the page in any browser and then press the button, the info message should be printed

<pre>
@ApplicationScoped
@ManagedBean
public class ApplicationController extends CommonController {

    private static final Logger LOG = Logger.getLogger(ApplicationController.class);

    public ApplicationController() {
        LOG.info(ApplicationController.class.getName() + "...");
    }
}
</pre>

Output:
<pre>
09:32:40,288 INFO  [com.github.demo.scopes.ApplicationController] (http--127.0.0.1-8080-1) com.github.demo.scopes.ApplicationController...
</pre>

## Binding
Show and gather info from the web page:

<pre>
Show:   getters
Gather: setters
</pre>

Demo page:
<pre>
http://localhost:8080/demo-web/getset.jsf
</pre>

Controller:
<pre>
@ManagedBean
@RequestScoped
public class BindingController {

    private static final Logger LOG = Logger.getLogger(BindingController.class);

    private String name;
    private Department department;

    public BindingController() {
        department = new Department();
    }

    public void ok() {
        LOG.info("name: " + name);
        LOG.info("Department values: " + department.getId() + "@" + department.getName());
    }

    public void setName(String name) {
        LOG.info("set name");
        this.name = name;
    }

    public void setDepartment(Department department) {
        LOG.info("set dep");
        this.department = department;
    }

    public String getName() {
        LOG.info("get name");
        return this.name;
    }

    public Department getDepartment() {
        LOG.info("get dep");
        return this.department;
    }
}
</pre>

JSF Page:
<pre>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core">
<h:head>

</h:head>
<h:body>
	<h:form>
		<h:panelGrid columns="2">
			<h:outputText value="Name:" />
			<h:inputText value="#{bindingController.name}"></h:inputText>
			
			<h:outputText value="Dep id:" />
			<h:inputText value="#{bindingController.department.id}"></h:inputText>
			<h:outputText value="Dep name:" />
			<h:inputText value="#{bindingController.department.name}"></h:inputText>
		</h:panelGrid>
		<h:commandButton value="OK" action="#{bindingController.ok}" />
	</h:form>
</h:body>
</html>
</pre>

Output
<pre>
09:40:38,342 INFO  [com.github.demo.binding.BindingController] (http--127.0.0.1-8080-1) get name
09:40:38,344 INFO  [com.github.demo.binding.BindingController] (http--127.0.0.1-8080-1) get dep
09:40:38,346 INFO  [com.github.demo.binding.BindingController] (http--127.0.0.1-8080-1) get dep
</pre>

## Lifecycle

log4j
```xml 
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>
```

How to use the logger:
<pre>
private static final Logger LOG = Logger.getLogger(MyService.class);
</pre>

## Persisting data
####@PersistenceContext

####javax.persistence.EntityManager

<pre>
	@PersistenceContext
	private EntityManager em;
</pre>


If you have more than one persistence unit:
<pre>
	@PersistenceContext(unitName="Name of persistence unit: DemoPU")
	private EntityManager em;
</pre>

## Basic methods
em use object instances


We will use a Department instance, because is an object :)

<pre>
	Department extends java.lang.Object
</pre>

####em.persist(department);
<pre>
16:35:46,771 INFO  [com.github.demo.em.MyController] (http--127.0.0.1-8080-1) MyController is being created
16:35:46,772 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: select tbl.next_val from hibernate_sequences tbl where tbl.sequence_name=? for update
16:35:46,773 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: update hibernate_sequences set next_val=?  where next_val=? and sequence_name=?
16:35:46,774 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: insert into tbl_department (dep_name, dep_id) values (?, ?)
</pre>

####em.merge(department);
<pre>
16:35:10,907 INFO  [com.github.demo.em.MyController] (http--127.0.0.1-8080-1) MyController is being created
16:35:10,908 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: select department0_.dep_id as dep1_16_0_, department0_.dep_name as dep2_16_0_ from tbl_department department0_ where department0_.dep_id=?
16:35:10,909 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: update tbl_department set dep_name=? where dep_id=?
</pre>

####em.remove(department);
<pre>
16:36:29,787 INFO  [com.github.demo.em.MyController] (http--127.0.0.1-8080-1) MyController is being created
16:36:29,788 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: select department0_.dep_id as dep1_16_0_, department0_.dep_name as dep2_16_0_ from tbl_department department0_ where department0_.dep_id=?
16:36:29,789 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: delete from tbl_department where dep_id=?
</pre>

## Query data
You have two main options to query data

Using JPQL
####em.createQuery("SELECT d FROM Department d")
<pre>
16:37:06,647 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: select department0_.dep_id as dep1_16_, department0_.dep_name as dep2_16_ from tbl_department department0_
16:37:06,648 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 1: accounting
16:37:06,648 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 2: technology
16:37:06,648 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 4: technology
16:37:06,649 INFO  [com.github.demo.em.MyService] (http--127.0.0.1-8080-1) 5: technology
</pre>


Using native queries (plain sql)
####em.createNativeQuery("select * from tbl_department")
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

To run JBoss AS:
<pre>
sh JBOSS_HOME/bin/standalone.sh
</pre>

Login to database console:
<pre>
http://localhost:8080/h2console/
</pre>

<pre>
Driver Class: 	org.h2.Driver
JDBC URL:	jdbc:h2:mem:test;DB_CLOSE_DELAY=-1
User Name:	sa
Password:	sa
</pre>

Review how the information is being persisted
