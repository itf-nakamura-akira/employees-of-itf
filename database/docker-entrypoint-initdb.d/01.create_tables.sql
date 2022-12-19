-- Project Name : noname
-- Date/Time    : 2022/12/20 0:18:44
-- Author       : AKIRA
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

-- 役職テーブル
drop table if exists posts cascade;

create table posts (
  id serial not null comment 'ID'
  , name varchar(100) not null comment '役職'
  , insert_at datetime default current_timestamp() not null comment 'データ挿入日時'
  , update_at datetime on update CURRENT_TIMESTAMP comment 'データ更新日時'
  , constraint posts_PKC primary key (id)
) comment '役職テーブル' ;

alter table posts add unique posts_IX1 (name) ;

-- ユーザーテーブル
drop table if exists posts_of_users cascade;

create table posts_of_users (
  id serial not null comment 'ID'
  , users_id bigint(20) unsigned not null comment 'ユーザーテーブルID'
  , posts_id bigint(20) unsigned not null comment '役職テーブルID'
  , insert_at datetime default current_timestamp() not null comment 'データ挿入日時'
  , update_at datetime on update CURRENT_TIMESTAMP comment 'データ更新日時'
  , constraint posts_of_users_PKC primary key (id)
) comment 'ユーザーテーブル' ;

alter table posts_of_users add unique posts_of_users_IX1 (users_id,posts_id) ;

-- ユーザーテーブル
drop table if exists users cascade;

create table users (
  id serial not null comment 'ID'
  , account varchar(100) not null comment 'アカウント'
  , password_hash text not null comment 'ハッシュ化済みパスワード'
  , employee_no smallint comment '社員番号'
  , system_authority enum('administrator','manager', 'general') default 'general' not null comment 'システム権限:administrator: 管理者
manager: マネージャー
general: 一般'
  , is_enabled boolean default true not null comment '有効フラグ'
  , name varchar(100) not null comment '表示名'
  , insert_at datetime default current_timestamp() not null comment 'データ挿入日時'
  , update_at datetime on update CURRENT_TIMESTAMP comment 'データ更新日時'
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

