# Selenium Grid using Docker

## Description
- This project about how to run parallel test using **Selenium Grid** and **Docker**. This project performs basic google search and validate the page title.
- Dependencies : 
    - Selenium
    - TestNG
    - Log4J


## Installation

### Docker Setup
> What is Docker?
- An open-source project that automates the deployment of software applications inside containers by providing an additional layer of abstraction and automation of OS-level virtualization on Linux.

1. Download [Docker Toolbox](https://docs.docker.com/toolbox/overview/) for Windows
2. After installation type `docker --version` command to the command prompt to ensure that Docker successfully installed to our system or not.
<p align="center">
    <img src="./resources/1_version.png">
</p>

3. You need a *Docker machine* to install and run Docker on Mac or Windows. *docker machine* is a tool that lets you install *Docker Engine* on virtual hosts and manage the hosts with `docker-machine` commands.
- You can list available Docker machines by typing `docker-machine ls`
<p align="center">
    <img src="./resources/2_machinelist.png">
</p>

4. There is no Docker machine so we need to create new one.
    `docker-machine create --driver virtualbox default`. This command downloads a lightweight Linux distribution with the Docker daemon and creates and starts a VirtualBox VM with Docker running. Now you can see the installed Docker machine through `docker-machine ls` command.
<p align="center">
    <img src="./resources/3_machinelist.png">
</p>

5. You need to connect your shell to the new machine so type this command `eval "$(docker-machine env default)"`. If you are using **cmd.exe** or **Windows Powershell** 'eval' command is not defined so you sould use Docker Quickstart Terminal or **git-bash.exe**.

### Selenium Grid

1. Firstly, you should get necessary images for Docker and Selenium grid integration. You can see existing images for Docker container by typing `docker images` command. For this project we need  Selenium Hub and browser node images:
    - `docker pull selenium/hub`
    - `docker pull selenium/node-chrome`
    - `docker pull selenium/node-firefox`
<p align="center">
    <img src="./resources/4_gridimages.png">
</p>

2. After all installation, you can run your images at a new **Docker Container**. First we need to create and run Selenium Grid Container.
    - `docker run -d -P --name selenium-hub selenium/hub` creates a new container which name is **selenium-hub**. You can specify port number by `-p [NEW_PORT]:4444`.
	- `docker container ls` list your Docker containers and you can see the selenium-hub container.
<p align="center">
    <img src="./resources/5_containerlist.png">
</p>

3. To access the **Selenium Grid Hub page** from your browser, you should enter this URL `http://[docker_machine_ip:PORT]` . *E.g. http://192.168.99.100:32768/*
   - To learn **docker machine ip** type this command : `docker-machine ip`

4. Now you should register chrome and firefox nodes to the hub. You should create a new container for each nodes:
	- `docker run -d --link selenium-hub:hub selenium/node-firefox`
	- `docker run -d --link selenium-hub:hub selenium/node-chrome`

5. Check the current containers : 
    - `docker container ls` or processes `docker ps`. 
    - You can see the chrome and firefox node from your browser.
<p align="center">
    <img src="./resources/6_gridpage.png">
</p>