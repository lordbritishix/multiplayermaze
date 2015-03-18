FROM ansible/ubuntu14.04-ansible:latest

MAINTAINER Jim Quitevis <jim.quitevis@gmail.com>

WORKDIR /src
ADD ansible ansible

EXPOSE 5432

WORKDIR /src/ansible
RUN ansible-playbook docker_main.yml -i inventories/local/hosts 

USER postgres
CMD ["/usr/lib/postgresql/9.3/bin/postgres", "-D", "/var/lib/postgresql/9.3/main", "-c", "config_file=/etc/postgresql/9.3/main/postgresql.conf"]