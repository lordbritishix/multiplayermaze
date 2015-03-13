FROM ansible/ubuntu14.04-ansible
MAINTAINER Jim Quitevis <jim.quitevis@gmail.com>

RUN apt-get update

RUN apt-get install -y git

# Setup and copy ssh keys. Ensure that local id_rsa is already added to github
RUN mkdir /root/.ssh/
ADD id_rsa /root/.ssh/id_rsa
RUN touch /root/.ssh/known_hosts
RUN ssh-keyscan github.com >> /root/.ssh/known_hosts

# Clone the code
RUN git clone git@github.com:lordbritishix/multiplayermaze.git

# Provision using ansible
RUN ansible-playbook multiplayermaze/ansible/main.yml -i multiplayermaze/ansible/inventories/local/hosts

# Port mapping - map container port 9300 to host port 9200
EXPOSE 5432 5432
