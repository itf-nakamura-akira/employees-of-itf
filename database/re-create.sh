#!/usr/bin/bash

DATABASE=employees_of_itf

mysql --defaults-extra-file=./user.cnf < ./create_db.sql
mysql --defaults-extra-file=./user.cnf $DATABASE < ./docker-entrypoint-initdb.d/01.create_tables.sql
mysql --defaults-extra-file=./user.cnf $DATABASE < ./docker-entrypoint-initdb.d/02.insert_data.sql