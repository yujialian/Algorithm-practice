#### Testing
bash script: the script going to run inside the terminal shell without anything more. <br />
```
python3 -c "from tests0 import test_prime; test_prime(1,False)"
python -c "command": run the command
run script: ./scriptName.sh
```
python's build in `assert` command: <br />
            assert True <br />
            assert False Assertion Error <br />
check exit code: <br />
`echo $?`
0: ok 1: something went wrong <br />
Easier way: <br />
Framework unittest <br />
#### Unittest Methods
```
assertEqual
assertNotEqual
assertTrue
assertFalse
assertin
assertNotIn
```
#### Browser testing tool: Selenium

#### CI/CD: continuous integration and continuous delivery
continuous integration:<br />
```
  Frequent merges to main branch
  Automated unit Testing
```
Continuous delivery:<br />
```
Automated application deployment
```
#### CI TOOLS
```
CircleCI
Codeship
Jenkins
Travis CI...
```
#### Travis
```
When I push code to github, github going to notify travis, travis pull the code from GitHub, and run some test on it, let the GitHub know if the code is passing.
```
set up configuration file(YAML) <br />
key1: value1  <br />
key2: value2  <br />
key3:  <br />
      -item1  <br />
      -item2  <br />
      -item3  <br />
```
language: python
python:
    - 3.6
install:
    - pip install -r requirements.txt
script:
    - python manage.py test
```
### Docker: Create containers, isolate containers in order to let it only have the packages we need.
Virtual machine: slow. <br />
 Way it works: Infrastructure->Host OS->Docker->Bins/Libs->App B.<br />
 Docker going to build directly on the OS, have direct access to the OS currently running, Docker going to add addtional layer, to keep those container isolated from each other.<br />
 In another server, I just create the container and run the application.<br />

 ##### First step: <br />
 Dockerfile: The file going to define a docker image, instructions on how to create container the application going to living.<br />
 ```
 FROM python:3
 WORKDIR /usr/src/app
 ADD requirements.txt /usr/src/app
 RUN pip install -r requirements.txt
 ADD ./usr/src/app
```
#### docker-compose up: start my application using docker-compose: it's going to look at the docker-compose.yml file
By taking advantage of containerzation we can:
```
A: Simplify the process of combine the service together
B: Simplify the process of making sure the application is going to behave the same way across different places as well.
```
Get inside the container: docker exec -it docker-id: Run command, interact working with terminal bash -l <br />
