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

EXPOSE 5432

# Provision using ansible
RUN ansible-playbook multiplayermaze/ansible/main.yml -i multiplayermaze/ansible/inventories/local/hosts

#USER postgres

# Adjust PostgreSQL configuration so that remote connections to the
# database are possible. 
#RUN echo "host all  all  0.0.0.0/0  md5" >> /etc/postgresql/9.3/main/pg_hba.conf

# And add ``listen_addresses`` to ``/etc/postgresql/9.3/main/postgresql.conf``
#RUN echo "listen_addresses='*'" >> /etc/postgresql/9.3/main/postgresql.conf

# Set the default command to run when starting the container
CMD ["/usr/lib/postgresql/9.3/bin/postgres", "-D", "/var/lib/postgresql/9.3/main", "-c", "config_file=/etc/postgresql/9.3/main/postgresql.conf"]
