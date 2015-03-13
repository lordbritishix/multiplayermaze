# multiplayermaze
Maze server with multiplayer capabilities

# Bootstrap
Install ansible <br />
<code>sudo easy_install pip</code><br />
<code>sudo pip install ansible</code><br />
<code>sudo pip install docker-py</code><br />
<code>sudo pip install --upgrade ansible</code><br />

Install Docker <br />
<code>sudo apt-get install docker.io</code>

# Deploy
<code>multiplayermaze/docker$ sudo docker build -t quitevis/mazeserver .</code>

# Tips
SSH to docker container <br />
<code>docker attach [container_id]</code>

View logs <br />
<code>sudo docker logs -f [container_name]</code>

Delete all docker containers<br/>
<code>sudo docker rm -f $(sudo docker ps -aq)</code>

Delete all docker images<br/>
<code>sudo docker rmi $(sudo docker images -q)</code>

# CI
https://travis-ci.org/lordbritishix/multiplayermaze/
