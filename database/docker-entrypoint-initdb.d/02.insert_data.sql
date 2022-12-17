-- ユーザー
INSERT INTO users
    (account, password_hash, employee_no, name)
VALUES
    ('yamanouchi', 'hashed_password', 0, '山之内 貴彦'),
    ('user01', 'hashed_password', 1, 'ユーザー 01'),
    ('user02', 'hashed_password', 2, 'ユーザー 02'),
    ('user03', 'hashed_password', 3, 'ユーザー 03'),
    ('user04', 'hashed_password', 4, 'ユーザー 04'),
    ('user05', 'hashed_password', 5, 'ユーザー 05'),
    ('user06', 'hashed_password', 6, 'ユーザー 06'),
    ('user07', 'hashed_password', 7, 'ユーザー 07'),
    ('user08', 'hashed_password', 8, 'ユーザー 08'),
    ('user09', 'hashed_password', 9, 'ユーザー 09'),
    ('user10', 'hashed_password', 10, 'ユーザー 10'),
    ('user11', 'hashed_password', 11, 'ユーザー 11'),
    ('user12', 'hashed_password', 12, 'ユーザー 12'),
    ('user13', 'hashed_password', 13, 'ユーザー 13'),
    ('user14', 'hashed_password', 14, 'ユーザー 14'),
    ('user15', 'hashed_password', 15, 'ユーザー 15'),
    ('user16', 'hashed_password', 16, 'ユーザー 16'),
    ('user17', 'hashed_password', 17, 'ユーザー 17'),
    ('user18', 'hashed_password', 18, 'ユーザー 18'),
    ('user19', 'hashed_password', 19, 'ユーザー 19'),
    ('user20', 'hashed_password', 20, 'ユーザー 20');

-- 役職
INSERT INTO posts
    (name)
VALUES
    ('一般社員'),
    ('主任'),
    ('係長'),
    ('課長'),
    ('次長'),
    ('部長'),
    ('本部長'),
    ('常務取締役'),
    ('専務取締役'),
    ('代表取締役社長');

-- ユーザーの役職
INSERT INTO posts_of_users
    (users_id, posts_id)
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('代表取締役社長', '専務取締役', '常務取締役') WHERE u.account = 'yamanouchi' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('本部長') WHERE u.account = 'user01' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('本部長') WHERE u.account = 'user02' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('部長') WHERE u.account = 'user03' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('部長') WHERE u.account = 'user04' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('部長') WHERE u.account = 'user05' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('次長') WHERE u.account = 'user06' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('次長') WHERE u.account = 'user07' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('次長') WHERE u.account = 'user08' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('課長') WHERE u.account = 'user09' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('課長') WHERE u.account = 'user10' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('課長') WHERE u.account = 'user11' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('係長') WHERE u.account = 'user12' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('係長') WHERE u.account = 'user13' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('主任') WHERE u.account = 'user14' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('主任') WHERE u.account = 'user15' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('主任') WHERE u.account = 'user16' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('主任') WHERE u.account = 'user17' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('一般社員') WHERE u.account = 'user18' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('一般社員') WHERE u.account = 'user19' UNION ALL
SELECT u.id, p.id FROM users AS u LEFT JOIN posts p ON p.name IN ('一般社員') WHERE u.account = 'user20';