<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>感情分析</title>
</head>

<body>
<header>
<a href="./request">DetectedLanguage</a>
</header>
<h1>Sentimentを使うサイト</h1>

<h3>調べたい文字列を教えてください</h3>
<form method="POST" action="./sentimentresult">
<input type="TEXT" name="string" />
<input type="submit" />
</form>
</body>
</html>