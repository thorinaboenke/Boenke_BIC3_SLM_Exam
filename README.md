# BIC3 Software Lifecycle Management Exam 

Thorina Boenke ic21b060

The goal is to implement a very simple REST API in JAVA, but configure and manage a whole CI/CD structure around the project, as well as using proper development procedures in git. (User-Stories, Requirements, etc.)

## Repository URL https://github.com/thorinaboenke/Boenke_BIC3_SLM_Exam

## User Stories

User Stories are managed via a Kanban Board in a GitHub Project. The status an issue can have are "To Do" "In Progress", "Done".

1. As a user I want to call the API with a percentage value and want to receive back the calculated grade.

**REQ-Definition:**

- A message is always returned when the user opens the URI path `/grade?percentage=<inputValue>`.
- The message content is the grade corresponding to the entered percentage value
- The message must not be empty
- The message content must be in a human readable format
- If invalid parameters are provided, the user should be informed with the message "invalid input"

**Example:**
Open `api/mark?percentage=49` => "5" 
**or** `api/mark?percentage=80` => "2"

2. As a developer I want to test an then implement the API path /api/mark

**Testcases:**
`GetMark` => Returns Status OK and calculated grade as content
`GetMarkWithInvalidParamter` => Returns Status OK and content 'invalid input'

3. As a developer I want to implement a continous integration and continous delivery pipeline (CI/CD) with Maven and Github Actions
   
**REQ-Definition:**

The actions should get started by either push or pull requests on the selected branch:

For the main branch:
```
on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]
```
An Ubuntu build container is used  to run the build job.

Maven is the dependency manager and jdk 17 is used.

```
steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven
    - name: Build with Maven
      run: mvn -B package --file pom.xml
```

The test are started with the build process of maven

```
    - name: Build with Maven
      run: mvn -B package --file pom.xml
```

The build artifact (executable jar) should be saved in the folder 'download'


```
    - name: Copy built jar
      run: mkdir download & cp target/*.jar download
    
    - name: Upload a Build Artifact
      uses: actions/upload-artifact@v2
      with:
        name: Main-Build
        path: download
```

4. As a developer i want to create a documentation for the whole project

**REQ-Definition:**

A README.md file in the repository contains information on 
- the user stories
- the repository URL
- the usage of the software

### KanBan Board
Issues are tracked in a github project Kanban Board. Issues can have the status "to do", "in progress" and "done". Issues and corresponding feature branches should each link to each other. (i.e. "This feature relates to issue #1" etc.)

### Branch History
There is a 'main' branch, a 'development' branch and feature branches. Features are developed on their respective feature branches and first merged into 'development'. A deployment to production environment would correspond to a merge of the changes of 'development' into 'main'.

No direct commits on main are allowed except for the initial commit and (for convenience) for modification of the documentation.

## Usage of the Software

The request with query parameters is typed directly into the browser url bar by the user.

The result is displayed in the browser window.
