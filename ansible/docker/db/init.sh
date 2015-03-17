#!/bin/bash
echo "host all  all    10.0.0.0/8  trust" >> $PGDATA/pg_hba.conf
echo "host all  all    192.168.0.0/16  trust" >> $PGDATA/pg_hba.conf

#For production, only listen to selected ip addresses
echo "listen_addresses='*'" >> $PGDATA/postgresql.conf

#service postgresql restart
#psql --command "CREATE USER deploy WITH ENCRYPTED PASSWORD 'deploy' CREATEDB CREATEUSER CREATEROLE"