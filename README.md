General Information
====================
This project was highly inspired by [webdriver-testng-archetype](https://github.com/barancev/webdriver-testng-archetype) 
an awesome work by [Alexei Barantsev](https://github.com/barancev)

Selenium Framework Archetype
============================

This archetype generates a new Maven Selenium Project with pre-configured settings, with good practice that you can
use that gets you writing test quickly.
 
Libraries
-----------------------------------
 - [Selenium WebDriver](https://github.com/SeleniumHQ/selenium)
 
 - [TestNG](http://testng.org/doc/index.html).
 
 - [Rest Assured](http://rest-assured.io/)

To create a project from this archetype:

```
mvn archetype:generate -DarchetypeGroupId=uk.bongosway.selenium -DarchetypeArtifactId=selenium-framework-archetype -DarchetypeVersion=4.5 -DgroupId=<mygroupId> -DartifactId=<myartifactId>
```

where `mygroupId` is a group id of the project you are creating, and `myartifactId` is an artifact id of the project you are creating.

Project Structure
-----------------------------------

The project follows the standard Maven structure, so all the tests go in the `src/test/java` folder. Tests should
 inherit from the `TestBase` class for managing `Test fixtures`. 


`SampleTestIT` class (in `src/test/java`) is an example of a test class for testing. This
 class is simply modelling the behaviour expected from the sample web application, therefore does not contain any
  [PageObjects](https://github.com/SeleniumHQ/selenium/wiki/PageObjects) Classes or Methods.

Project Configuration
-----------------------------------

The project uses Maven profiles to set configuration parameters. There are three profile groups: 
 - browser e.g. `chrome`, `firefox`. default is `firefox`
 - environment e.g. `localhost`, `production` default is `localhost`
 - Grid. `grid`, `nogrid` default is `nogrid`
    - add properties for each profile like this:
    ```xml
   <profile>
      <id>nogrid</id>
      <properties>
        <grid.url></grid.url>
      </properties>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
   </profile> 
   ```

For example, to run tests in Chrome on the localhost without grid use this profile set:

```
mvn -P chrome,localhost,nogrid verify
```

The target application URL and the grid location should be specifies in the `pom.xml` file in the corresponding profiles.

Driver capabilities can be tuned in the files `src/test/resources/*.capabilities`.

