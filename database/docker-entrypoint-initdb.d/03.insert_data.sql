-- ユーザー
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('yamanouchi', 'hashed_password', 0, 'Administrator', 1, '山之内 貴彦');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user01', 'hashed_password', 1, 'Manager', 1, 'ユーザー 01');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user02', 'hashed_password', 2, 'Manager', 1, 'ユーザー 02');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user03', 'hashed_password', 3, 'General', 1, 'ユーザー 03');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user04', 'hashed_password', 4, 'General', 1, 'ユーザー 04');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user05', 'hashed_password', 5, 'General', 1, 'ユーザー 05');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user06', 'hashed_password', 6, 'General', 1, 'ユーザー 06');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user07', 'hashed_password', 7, 'General', 1, 'ユーザー 07');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user08', 'hashed_password', 8, 'General', 1, 'ユーザー 08');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user09', 'hashed_password', 9, 'General', 1, 'ユーザー 09');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user10', 'hashed_password', 10, 'General', 1, 'ユーザー 10');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user11', 'hashed_password', 11, 'General', 1, 'ユーザー 11');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user12', 'hashed_password', 12, 'General', 1, 'ユーザー 12');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user13', 'hashed_password', 13, 'General', 1, 'ユーザー 13');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user14', 'hashed_password', 14, 'General', 1, 'ユーザー 14');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user15', 'hashed_password', 15, 'General', 1, 'ユーザー 15');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user16', 'hashed_password', 16, 'General', 1, 'ユーザー 16');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user17', 'hashed_password', 17, 'General', 1, 'ユーザー 17');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user18', 'hashed_password', 18, 'General', 1, 'ユーザー 18');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user19', 'hashed_password', 19, 'General', 1, 'ユーザー 19');
INSERT INTO users (account, password_hash, employee_no, system_authority, is_enabled, name) VALUES ('user20', 'hashed_password', 20, 'General', 1, 'ユーザー 20');

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