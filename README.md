# multiplayermaze
Maze server with multiplayer capabilities


# Setting up the server locally
## Bootstrap
Install ansible <br />
<code>sudo apt-get install pip pip</code><br />
<code>sudo pip install ansible</code><br />

Install Docker <br />
<code>sudo apt-get install docker.io</code>

## Deploy
<code>multiplayermaze/docker$ sudo docker build -t quitevis/mazeserver .</code>

# Tips
SSH to docker container <br />
<code>sudo docker run -t -i quitevis/mazeserver /bin/bash</code>

View logs <br />
<code>sudo docker logs -f [container_name]</code>

Delete all docker containers<br/>
<code>sudo docker rm -f $(sudo docker ps -aq)</code>

Delete all docker images<br/>
<code>sudo docker rmi $(sudo docker images -q)</code>

# CI
https://travis-ci.org/lordbritishix/multiplayermaze/
