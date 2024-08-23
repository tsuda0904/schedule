# スケジュール管理システム
## 概要
スケジュールを登録、削除、変更できるアプリです。ユーザー間でスケジュールの共有ができます。
<br>
## 機能一覧
### アカウント登録機能
![signup (1)](https://github.com/user-attachments/assets/a5ee1290-4557-4fc0-9e48-8e470cdc569c)
Sign In画面のcreate an accountより、Sign Up画面遷移します。
User Name、Email Address、Passwordを入力し、アカウントを作成します。
<br>

### サインイン・サインアウト機能
![login](https://github.com/user-attachments/assets/14a39bd2-2978-437e-a103-46b85bf91131)
Email Address、Passwordを入力し、Sign Inします。
登録されたroleに基づき、UserページかAdwinページを開きます。<br>
サインイン後、右上のsign outボタンよりサインアウトできます。
NotEmptyバリデーション機能により、メッセージが表示されます。
<br>

### 検索機能
#### ユーザ検索
![searchuser](https://github.com/user-attachments/assets/aac79dcf-cf49-4ab6-88a5-44be882dde52)
フィールドに入力した文字を含むユーザが検索されます。
文字を入力せずSubmitボタンを押すと、バリデーションメッセージが表示されます。
<br>
<br>

#### スケジュール検索
![searchschedule](https://github.com/user-attachments/assets/66ef4cb7-961f-476e-9f16-4408c4ad79a6)
会議を１つ以上選択し、Submitボタンを押すと、該当のスケジュールのみ表示されます。
選択をせずにSubmitボタンを押すと、バリデーションメッセージが表示されます。
<br>

### 登録機能
#### ユーザ登録
![userregist](https://github.com/user-attachments/assets/62d1ef2b-65b6-4390-9fa0-d5f8bf82bd04)
新規ユーザ登録ボタンよりユーザを登録できます。必須項目を入力し、登録処理実行ボタンを押すとユーザ一覧に表示されます。そのほか「性別」「電話番号」「メールアドレス」「住所」「学科「役職」を登録できます。必須項目を入力せずに登録処理実行ボタンを押すと、バリデーションメッセージが表示されます。
<br>

#### スケジュール登録
![scheduleregist](https://github.com/user-attachments/assets/59a6a90a-3ca5-484e-8700-f59cddef34ce)
Adwinユーザーでサインインした場合、「スケジュール編集」メニューが表示されます。
スケジュール編集画面より新規登録ボタンを押し、スケジュールを登録できます。
「日付」「時間」「会議名」「議題」「場所」を入力し、登録処理実行ボタンを押すと登録が完了し、TOPページとスケジュール編集ページに表示されます。
<br>

### 編集機能
#### ユーザ編集
