# スケジュール管理システム
## 概要
スケジュールを登録、削除、変更できるアプリです。ユーザー間でスケジュールの共有ができます。
<br>
## 機能一覧
### アカウント登録機能
Sign In画面のcreate an accountより、Sign Up画面に遷移します。
User Name、Email Address、Passwordを入力し、アカウントを作成します。<br>
![signup (1)](https://github.com/user-attachments/assets/69d706bd-0c98-44f1-8558-ca256bb23ceb)
<br>

### サインイン・サインアウト機能
Email Address、Passwordを入力し、Sign Inします。
登録されたroleに基づき、UserページかAdwinページを開きます。<br>
サインイン後、右上のsign outボタンよりサインアウトできます。
NotEmptyバリデーション機能により、メッセージが表示されます。
<br>
![login](https://github.com/user-attachments/assets/14a39bd2-2978-437e-a103-46b85bf91131)
<br>

### 検索機能
#### ユーザ検索
フィールドに入力した文字を含むユーザが検索されます。
文字を入力せずSubmitボタンを押すと、バリデーションメッセージが表示されます。
<br>
![searchuser](https://github.com/user-attachments/assets/aac79dcf-cf49-4ab6-88a5-44be882dde52)
<br>

#### スケジュール検索
会議を１つ以上選択し、Submitボタンを押すと、該当のスケジュールのみ表示されます。
選択をせずにSubmitボタンを押すと、バリデーションメッセージが表示されます。
<br>
![searchschedule](https://github.com/user-attachments/assets/66ef4cb7-961f-476e-9f16-4408c4ad79a6)
<br>

### 登録機能
#### ユーザ登録
新規ユーザ登録ボタンよりユーザを登録できます。必須項目を入力し、登録処理実行ボタンを押すとユーザ一覧に表示されます。そのほか「性別」「電話番号」「メールアドレス」「住所」「学科「役職」を登録できます。必須項目を入力せずに登録処理実行ボタンを押すと、バリデーションメッセージが表示されます。
<br>
![userregist](https://github.com/user-attachments/assets/62d1ef2b-65b6-4390-9fa0-d5f8bf82bd04)
<br>

#### スケジュール登録
Adwinユーザでサインインした場合、「スケジュール編集」メニューが表示されます。
スケジュール編集画面より新規登録ボタンを押し、スケジュールを登録できます。
「日付」「時間」「会議名」「議題」「場所」を入力し、登録処理実行ボタンを押すと登録が完了し、TOPページとスケジュール編集ページに表示されます。
<br>
![scheduleregist](https://github.com/user-attachments/assets/59a6a90a-3ca5-484e-8700-f59cddef34ce)
<br>

### 編集機能
#### ユーザ編集
ユーザ一覧の利用者を押すとユーザ詳細が表示されます。ユーザ詳細画面より、登録情報の変更・削除が可能です。
<br>
![updateuser](https://github.com/user-attachments/assets/2ce91a49-1630-4b61-9d86-66f532cc5268)
<br>

#### スケジュール編集
Adwinユーザでサインインした場合、スケジュール編集画面より、スケジュールの変更・削除が可能です。
<br>
![updateschedule](https://github.com/user-attachments/assets/e7cb535e-21cc-4751-9a32-a5d97bee0f6f)
<br>

## データベース作成
```
CREATE DATABASE schedule;

USE schedule;

CREATE TABLE if not exists login_user (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	email VARCHAR(255),
	password VARCHAR(255),
	role VARCHAR(10),
	PRIMARY KEY (id)
);

create table if not exists role (
	id bigint(20) not null auto_increment,
	name varchar(255),
	primary key (id)
);

create table if not exists user (
	id bigint(20) not null auto_increment,
	last_name varchar(255),
	first_name varchar(255),
	birth date,
	sex varchar(10),
	tel varchar(50),
	mail varchar(255),
	address varchar(1000),
	course varchar(50),
	position varchar(50),
	user_registered date,
	primary key (id)
);

create table if not exists schedule (
	id bigint(20) not null auto_increment,
	day date,
	time time
	meeting varchar(255),
	meeting_name varchar(255),
	place varchar(255),
	schedule_registered date,
	primary key (id)
);

create table if not exists meeting (
	id bigint(20) not null auto_increment,
	meeting varchar(255),
	primary key (id)
);
```
