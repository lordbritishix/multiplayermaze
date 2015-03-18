# multiplayermaze
Maze server with multiplayer capabilities


# Environment setup
## Install pip
<code>sudo apt-get install python-pip</code>
## Install ansible
<code>sudo pip install ansible</code>
## Create / update the environment
<code>multiplayermaze/ansible$ sudo ansible-playbook main.yml -i inventories/local/hosts</code>
## Run the DB server
<code>$ sudo docker run -ti quitevis/db</code>

# Tips
## Docker
SSH to docker container <br/>
<code>sudo docker run -ti -p 5432:5432 quitevis/db /bin/bash</code>

Delete all docker containers<br/>
<code>sudo docker rm -f $(sudo docker ps -qa)</code>

Delete all docker images<br/>
<code>sudo docker rmi $(sudo docker images -qa)</code>

# CI
https://travis-ci.org/lordbritishix/multiplayermaze/
