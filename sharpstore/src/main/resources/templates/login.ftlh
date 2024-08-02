<!DOCTYPE html>
<html>
<head>
    <title>SHARPSTORE</title>
</head>
<body>
<h1>SHARPSTORE</h1><hr>
<h4>Авторизация</h4>
<form action="/login" method="post">
    Эл. почта: <label>
        <input type="email" name="username">
    </label><br><br>
    Пароль: <label>
        <input type="password" name="password">
    </label><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
</form>
<a href="/registration">Зарегистрироваться</a>
<#if error??>
    <h2 style="color: red">${error}</h2>
</#if>
</body>
</html>