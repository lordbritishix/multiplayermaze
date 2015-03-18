FROM ansible/ubuntu14.04-ansible:latest

MAINTAINER Jim Quitevis <jim.quitevis@gmail.com>

WORKDIR /src

RUN rm -f master.zip
RUN rm -rf multiplayermaze-master

RUN apt-get install -y --force-yes curl
RUN apt-get install -y --force-yes unzip

RUN curl -LOk https://github.com/lordbritishix/multiplayermaze/archive/master.zip
RUN unzip master.zip

WORKDIR /src/multiplayermaze-master/ansible

RUN ansible-playbook docker_main.yml -i inventories/local/hosts

USER postgres

CMD ["/usr/lib/postgresql/9.3/bin/postgres", "-D", "/var/lib/postgresql/9.3/main", "-c", "config_file=/etc/postgresql/9.3/main/postgresql.conf"]
