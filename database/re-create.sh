#!/usr/bin/bash

DATABASE=employees_of_itf

mysql --defaults-extra-file=./user.cnf < ./create_db.sql
mysql --defaults-extra-file=./user.cnf $DATABASE < ./docker-entrypoint-initdb.d/01.functions.sql
mysql --defaults-extra-file=./user.cnf $DATABASE < ./docker-entrypoint-initdb.d/02.create_tables.sql
mysql --defaults-extra-file=./user.cnf $DATABASE < ./docker-entrypoint-initdb.d/03.insert_data.sql