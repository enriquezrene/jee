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
```xml
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
```

Output
<pre>
09:40:38,342 INFO  [com.github.demo.binding.BindingController] (http--127.0.0.1-8080-1) get name
09:40:38,344 INFO  [com.github.demo.binding.BindingController] (http--127.0.0.1-8080-1) get dep
09:40:38,346 INFO  [com.github.demo.binding.BindingController] (http--127.0.0.1-8080-1) get dep
</pre>

Enter data in the form:
http://localhost:8080/demo-web/getset.jsf
<pre>
Name:       value for name field
Dep id:     123
Dep name:   some dep name
</pre>

Then press submit button:
<pre>
15:22:22,746 INFO  [com.github.demo.binding.BindingController] (http--127.0.0.1-8080-1) name: value for name field
15:22:22,747 INFO  [com.github.demo.binding.BindingController] (http--127.0.0.1-8080-1) Department values: 123@some dep name
</pre>

###EJB Integration

InfoController
<pre>

</pre>

###Dependency Injection

Construct
<pre>

    @EJB
    private MyService myService;
    
    public InfoController() {
        LOG.info("INJECTED FIELD: " + myService);
    }
    
    ...
</pre>
Output:
<pre>
15:27:00,566 INFO  [com.github.demo.ejbintegration.InfoController] (http--127.0.0.1-8080-1) INJECTED FIELD: null
</pre>

@PosContruct
<pre>

    @EJB
    private MyService myService;
    
    ...
    
    @PostConstruct
    public void ini() {
        LOG.info("INJECTED FIELD: " + myService);
        departments = myService.listDepartments();
    }
    
    ...
</pre>
Output:
<pre>
15:27:00,567 INFO  [com.github.demo.ejbintegration.InfoController] (http--127.0.0.1-8080-1) INJECTED FIELD: Proxy for view class: com.github.demo.em.MyService of EJB: MyService
15:27:00,629 INFO  [stdout] (http--127.0.0.1-8080-1) Hibernate: select department0_.dep_id as dep1_25_, department0_.dep_name as dep2_25_ from tbl_department department0_
</pre>

###Binding components:

###Get row from table:

```xml
<h:dataTable binding="#{infoController.table}"
            value="#{infoController.departments}" var="item">
```

<pre>
    public void selectDepartment() {
        Department department = (Department) table.getRowData();
        LOG.info("selected-value: " + department.getId() + ": " + department.getName());
    }
</pre>

Output:
<pre>
16:18:17,040 INFO  [com.github.demo.ejbintegration.InfoController] (http--127.0.0.1-8080-1) selected-value: 1: technology
</pre>


###Using "combo-box"

```xml
        <h:selectOneMenu value="#{infoController.selectedItem}">
            <f:selectItems value="#{infoController.departments}" var="item"
                itemLabel="#{item.name}" itemValue="#{item.id}" />
        </h:selectOneMenu>

```

###Using data table
```xml
    <h:dataTable binding="#{infoController.table}"
            value="#{infoController.departments}" var="item">
                <h:column>
                    <f:facet name="header">Id</f:facet>
                        #{item.id}
                        </h:column>
			<h:column>
				<f:facet name="header">Name</f:facet>
    				#{item.name}
   			</h:column>
			<h:column>
				<f:facet name="header">Name</f:facet>
    				#{item.name}
   			</h:column>
			<h:column>
				<f:facet name="header">seleccionar</f:facet>
				<h:commandButton value="select"
					action="#{infoController.selectDepartment}" />
			</h:column>
		</h:dataTable>

Running the example:

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
