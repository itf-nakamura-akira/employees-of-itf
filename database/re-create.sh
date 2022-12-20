#!/usr/bin/bash

mysql --defaults-extra-file=./user.cnf < ./create_db.sql

for i in 'employees_of_itf' 'employees_of_itf_test'
do
    mysql --defaults-extra-file=./user.cnf ${i} < ./docker-entrypoint-initdb.d/01.functions.sql
    mysql --defaults-extra-file=./user.cnf ${i} < ./docker-entrypoint-initdb.d/02.create_tables.sql
    mysql --defaults-extra-file=./user.cnf ${i} < ./docker-entrypoint-initdb.d/03.insert_data.sql
done
