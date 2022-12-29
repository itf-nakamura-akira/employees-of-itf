-- ユーザー
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000000BEC4324C9B9257EE300CFC"), 'yamanouchi', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 0, 'Administrator', 1, '山之内 貴彦');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000001BEC4324C9B9257EE300CFC"), 'user01', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 1, 'Manager', 1, 'ユーザー 01');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000002BEC4324C9B9257EE300CFC"), 'user02', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 2, 'Manager', 1, 'ユーザー 02');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000003BEC4324C9B9257EE300CFC"), 'user03', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 3, 'General', 1, 'ユーザー 03');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000004BEC4324C9B9257EE300CFC"), 'user04', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 4, 'General', 1, 'ユーザー 04');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000005BEC4324C9B9257EE300CFC"), 'user05', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 5, 'General', 1, 'ユーザー 05');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000006BEC4324C9B9257EE300CFC"), 'user06', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 6, 'General', 1, 'ユーザー 06');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000007BEC4324C9B9257EE300CFC"), 'user07', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 7, 'General', 1, 'ユーザー 07');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000008BEC4324C9B9257EE300CFC"), 'user08', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 8, 'General', 1, 'ユーザー 08');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000009BEC4324C9B9257EE300CFC"), 'user09', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 9, 'General', 1, 'ユーザー 09');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("000000000ABEC4324C9B9257EE300CFC"), 'user10', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 10, 'General', 1, 'ユーザー 10');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("000000000BBEC4324C9B9257EE300CFC"), 'user11', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 11, 'General', 1, 'ユーザー 11');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("000000000CBEC4324C9B9257EE300CFC"), 'user12', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 12, 'General', 1, 'ユーザー 12');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("000000000DBEC4324C9B9257EE300CFC"), 'user13', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 13, 'General', 1, 'ユーザー 13');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("000000000EBEC4324C9B9257EE300CFC"), 'user14', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 14, 'General', 1, 'ユーザー 14');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("000000000FBEC4324C9B9257EE300CFC"), 'user15', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 15, 'General', 1, 'ユーザー 15');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000010BEC4324C9B9257EE300CFC"), 'user16', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 16, 'General', 1, 'ユーザー 16');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000011BEC4324C9B9257EE300CFC"), 'user17', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 17, 'General', 1, 'ユーザー 17');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000012BEC4324C9B9257EE300CFC"), 'user18', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 18, 'General', 1, 'ユーザー 18');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000013BEC4324C9B9257EE300CFC"), 'user19', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 19, 'General', 1, 'ユーザー 19');
INSERT INTO users (id, account, password_hash, employee_no, system_authority, is_enabled, name) VALUES (UNHEX("0000000014BEC4324C9B9257EE300CFC"), 'user20', /* password */'{argon2@SpringSecurity_v5_8}$argon2id$v=19$m=16384,t=2,p=1$lGnuXr7ppRC33DBCL3drOA$/OazSBWZr+7OZ/uOZ0kz9oCo079oJ+fqDkhL3zmwo84', 20, 'General', 1, 'ユーザー 20');

-- 役職
INSERT INTO posts (name) VALUES ('一般社員');
INSERT INTO posts (name) VALUES ('主任');
INSERT INTO posts (name) VALUES ('係長');
INSERT INTO posts (name) VALUES ('課長');
INSERT INTO posts (name) VALUES ('次長');
INSERT INTO posts (name) VALUES ('部長');
INSERT INTO posts (name) VALUES ('本部長');
INSERT INTO posts (name) VALUES ('常務取締役');
INSERT INTO posts (name) VALUES ('専務取締役');
INSERT INTO posts (name) VALUES ('代表取締役社長');

-- ユーザーの役職
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('代表取締役社長', '専務取締役', '常務取締役') WHERE u.account = 'yamanouchi';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('本部長') WHERE u.account = 'user01';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('本部長') WHERE u.account = 'user02';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('部長') WHERE u.account = 'user03';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('部長') WHERE u.account = 'user04';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('部長') WHERE u.account = 'user05';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('次長') WHERE u.account = 'user06';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('次長') WHERE u.account = 'user07';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('次長') WHERE u.account = 'user08';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('課長') WHERE u.account = 'user09';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('課長') WHERE u.account = 'user10';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('課長') WHERE u.account = 'user11';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('係長') WHERE u.account = 'user12';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('係長') WHERE u.account = 'user13';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('主任') WHERE u.account = 'user14';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('主任') WHERE u.account = 'user15';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('主任') WHERE u.account = 'user16';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('主任') WHERE u.account = 'user17';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('一般社員') WHERE u.account = 'user18';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('一般社員') WHERE u.account = 'user19';
INSERT INTO posts_of_users(users_id, posts_id) SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('一般社員') WHERE u.account = 'user20';