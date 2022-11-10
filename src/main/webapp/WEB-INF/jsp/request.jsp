<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>言語識別</title>
</head>

<body>
<header>
<a href="./sentimentRequest">Sentiment</a>
</header>
<h1>DetectedLanguageを使うサイト</h1>

<h3>調べたい文字列を教えてください</h3>
<form method="POST" action="./result">
<input type="TEXT" name="string" />
<input type="submit" />
</form>
</body>
</html>