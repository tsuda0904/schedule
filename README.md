# スケジュール管理システム
## 概要
スケジュールを登録、削除、変更できるアプリです。ユーザー間でスケジュールの共有ができます。
<br>
## 機能一覧
### アカウント登録機能
![signup (1)](https://github.com/user-attachments/assets/a5ee1290-4557-4fc0-9e48-8e470cdc569c)
Sign In画面のcreate an accountより、Sign Up画面遷移します。
User Name、Email Address、Passwordを入力し、アカウントを作成します。

### サインイン・サインアウト機能
![login](https://github.com/user-attachments/assets/14a39bd2-2978-437e-a103-46b85bf91131)
Email Address、Passwordを入力し、Sign Inします。
登録されたroleに基づき、UserページかAdwinページを開きます。<br>
サインイン後、右上のsign outボタンよりサインアウトできます。
NotEmptyバリデーション機能により、メッセージが表示されます。

### 検索機能


### スケジュール登録機能
![scheduleregist](https://github.com/user-attachments/assets/59a6a90a-3ca5-484e-8700-f59cddef34ce)
Adwinユーザーでサインインした場合、「スケジュール編集」メニューが表示されます。
スケジュール編集画面より新規登録ボタンを押し、スケジュールを登録できます。
「日付」「時間」「会議名」「議題」「場所」を入力し、登録処理実行ボタンを押すと登録が完了し、TOPページとスケジュール編集ページに表示されます。


