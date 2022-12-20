-- Project Name : noname
-- Date/Time    : 2022/12/21 1:04:04
-- Author       : AKIRA
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

-- 役職テーブル
drop table if exists posts cascade;

create table posts (
  id binary(16) default CONCAT(UNHEX(CONV(ROUND(UNIX_TIMESTAMP(CURRENT_TIMESTAMP(3)) * 1000), 10, 16)), RANDOM_BYTES(10)) not null comment 'ID'
  , name varchar(100) not null comment '役職'
  , insert_at datetime(3) default current_timestamp(3) not null comment 'データ挿入日時'
  , update_at datetime(3) on update current_timestamp(3) comment 'データ更新日時'
  , constraint posts_PKC primary key (id)
) comment '役職テーブル' ;

alter table posts add unique posts_IX1 (name) ;

-- ユーザーテーブル
drop table if exists posts_of_users cascade;

create table posts_of_users (
  id binary(16) default CONCAT(UNHEX(CONV(ROUND(UNIX_TIMESTAMP(CURRENT_TIMESTAMP(3)) * 1000), 10, 16)), RANDOM_BYTES(10)) not null comment 'ID'
  , users_id binary(16) not null comment 'ユーザーテーブルID'
  , posts_id binary(16) not null comment '役職テーブルID'
  , insert_at datetime(3) default current_timestamp(3) not null comment 'データ挿入日時'
  , update_at datetime(3) on update current_timestamp(3) comment 'データ更新日時'
  , constraint posts_of_users_PKC primary key (id)
) comment 'ユーザーテーブル' ;

alter table posts_of_users add unique posts_of_users_IX1 (users_id,posts_id) ;

-- ユーザーテーブル
drop table if exists users cascade;

create table users (
  id binary(16) default CONCAT(UNHEX(CONV(ROUND(UNIX_TIMESTAMP(CURRENT_TIMESTAMP(3)) * 1000), 10, 16)), RANDOM_BYTES(10)) not null comment 'ID'
  , account varchar(100) not null comment 'アカウント'
  , password_hash text not null comment 'ハッシュ化済みパスワード'
  , name varchar(100) not null comment '表示名'
  , employee_no mediumint comment '社員番号'
  , system_authority enum('Administrator','Manager', 'General') default 'General' not null comment 'システム権限:Administrator: 管理者
Manager: マネージャー
General: 一般'
  , is_enabled boolean default true not null comment '有効フラグ'
  , insert_at datetime(3) default current_timestamp(3) not null comment 'データ挿入日時'
  , update_at datetime(3) on update current_timestamp(3) comment 'データ更新日時'
  , constraint users_PKC primary key (id)
) comment 'ユーザーテーブル' ;

alter table users add unique users_IX1 (account) ;

alter table posts_of_users
  add constraint posts_of_users_FK1 foreign key (users_id) references users(id)
  on delete cascade
  on update cascade;

alter table posts_of_users
  add constraint posts_of_users_FK2 foreign key (posts_id) references posts(id)
  on delete cascade
  on update cascade;

