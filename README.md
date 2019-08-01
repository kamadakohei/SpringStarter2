# SpringStarter2
SpringでのCRUDアプリ作成

# 苦労した点
- たくさんのO/Rマッパーがあり、どれを使用すればよいのか迷った。
→SQLを直接書くJdbc templateを選んだが、APIが古い。bootiful sql templateが良さそう。


＜参考＞https://www.slideshare.net/masatoshitada7/java-or-jsug
　　　　https://www.slideshare.net/shintanimoto/spring-boot10

- DIの仕組みがわからず、エラー(No qualifying bean of type~)が出た際に困った。
→DIエラーあるあるだが、アノテーションを付け忘れていた。

- パッケージの切りかたがわからず困った。

- BootStrap,jQueryのjarファイルが最初上手く読み込めなかった。
→削除して入れ直したところ上手くいった。
、
