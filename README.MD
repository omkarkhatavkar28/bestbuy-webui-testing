<!-- PROJECT Bestbuy-webui-testing -->
 
<p align="center">  

 <h1 align="center">Bestbuy-WebUI-Testing</h1>  
  
 <p align="center">  
 Bestbuy-WebUI-Testing is a test suite which exercises the UI of Bestbuy Product Purchase Scenario
    <br />  
 </a>  
 <br />
  ·  
    <a href="https://github.com/omkarkhatavkar28/bestbuy-webui-testing/tree/master/test_report.png">Test Reports</a>
           ·       
       <a href="https://github.com/omkarkhatavkar28/bestbuy-webui-testing/tree/master/src/test/java/test">Tests</a>
  ·
    <a href="https://github.com/omkarkhatavkar28/bestbuy-webui-testing/issues">Request Feature</a>
 </p></p>



<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Main Features](#main-features)
* [Requirements](#requirements)
  * [Prerequisites](#prerequisites)
* [Quick Start](#quick-start)
* [Running UI Tests On a Docker Browser](#running-ui-tests-on-a-docker-browser)
* [Testing With Pytest](#testing-with-pytest)



<!-- ABOUT THE PROJECT -->
## About The Project

Bestbuy-WebUI-Testing is a test suite which exercises the UI for Bestbuy Product Purchase Scenario. Currently, it contains the UI Automation tests, Test Reports for Bestbuy Product Purchase Scenario UI.

<!-- MAIN FEATUERES -->
#### Main Features

-   Tests are written in Java8 Language with TestNG as the UnitTest framework to support the test creation.
-   Bestbuy-WebUI-Testing uses the Page Object Pattern to make tests more compact.
-  Tests are run locally with firefox and chrome browser support.
-   It contains support for Selenium Grid and Tests can be run on the remote host. This needs configuration change.
-  It contains docker-compose file create same infra locally.
- It can be used for parallel execution
- It contains the TestListener and Report is generated using with Extent Report Lib.

<!-- Requirements -->
## Requirements

You need Java8 and Maven configured your machine and make sure the paths are correctly placed.  

### Prerequisites
You can go through below references in case getting issues setting up prerequisites

- https://mkyong.com/java/how-to-install-java-jdk-on-ubuntu-linux/ 
- https://www.baeldung.com/install-maven-on-windows-linux-mac

## Quick Start

 - Clone the git repo
```bash
git clone https://github.com/omkarkhatavkar28/bestbuy-webui-testing.git
cd bestbuy-webui-testing
```
 - Download the required jars in .m2 repository folder for the Repo
```bash
mvn clean compile
```
 - We are using the DriverManger jar to place the correct chrome driver in your system, if Failed Please use below step.
 - Download appropriate chrome driver based your system from url https://chromedriver.chromium.org/downloads
  moved it into '/usr/bin' path

 - Execute the Tests using profile_id
```bash
mvn clean test -Denvironment=dev -Pui_testing
```
##   Running UI Tests On a Docker Browser
It is possible to run UI tests within a docker container. To do this:

 -   Install docker. It is provided by the  `docker`  package on Fedora and Red Hat.
 -   Make sure that Docker is up and running and the user that will run Bestbuy-webui-testing has permission to run docker commands. For more information check the docker installation guide  [https://docs.docker.com/engine/installation/](https://docs.docker.com/engine/installation/)
 -   Set  `target = remote` in the configuration file  `dev.properties`.

Once you’ve performed these steps, UI tests will no longer launch a web browser on your system. Instead, UI tests launch a web browser within a docker container and docker-compose file.

 - Clone the git repo
```bash
git clone https://github.com/omkarkhatavkar28/bestbuy-webui-testing.git
cd bestbuy-webui-testing
```

 - Start the docker instances with Docker Compose File

```bash
[root@okhatavk # docker-compose up -d
Creating bestbuy-webui-testing_hub_1 ... done
Creating bestbuy-webui-testing_chrome_1  ... done
Creating bestbuy-webui-testing_firefox_1 ... done
```

  - Execute the  tests
```bash
  mvn clean test -Denvironment=dev -Pui_testing
```

  ## Testing With More Options

- To run all tests:
```bash
    mvn clean test
```
It is possible to run a specific test:
```bash
    mvn test -Pui_testing -DTest=testPurchaseTheProductWithInvalidAddress
```

                                        
