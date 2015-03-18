# Maze server with multiplayer capabilities <br/>

# Environment setup
1. Install pip<br/>
<code>sudo apt-get install python-pip</code>
2. Install ansible<br/>
<code>sudo pip install ansible</code>
3. Create / update the environmentbr/>
<code>multiplayermaze/ansible$ sudo ansible-playbook main.yml -i inventories/local/hosts</code>
4. Run the DB server<br/>
<code>$ sudo docker run -ti quitevis/db</code>

# Dev Workflow
1. Edit code
2. Stop dockerized container
2. Run ansible
4. Start dockerized container

# Tips
1. Docker
SSH to docker container <br/>
<code>sudo docker run -ti -p 5432:5432 quitevis/db /bin/bash</code>

2. Delete all docker containers<br/>
<code>sudo docker rm -f $(sudo docker ps -qa)</code>

3. Delete all docker images<br/>
<code>sudo docker rmi $(sudo docker images -qa)</code>

# Sprint Board
https://trello.com/b/gGWLzccd/

# CI
https://travis-ci.org/lordbritishix/multiplayermaze/
[![Build Status](https://travis-ci.org/lordbritishix/multiplayermaze.svg?branch=master)](https://travis-ci.org/lordbritishix/multiplayermaze)
