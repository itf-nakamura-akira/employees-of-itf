DROP DATABASE IF EXISTS employees_of_itf;
CREATE DATABASE employees_of_itf;

DROP DATABASE IF EXISTS employees_of_itf_test;
CREATE DATABASE employees_of_itf_test;
GRANT ALL ON employees_of_itf_test.* TO itf_user;
