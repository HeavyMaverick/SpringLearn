<!DOCTYPE html>
<html>
<head>
    <title>SHARPSTORE</title>
</head>
<body>
<h1>SHARPSTORE</h1>
<hr>
<#if user.email??>
    <h3>Имя пользователя: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Панель администратора</a>
    </#if>
<#else>
    <a href="/login">Войти</a></h1>
</#if>
<hr>
<h4>Молодой бренд одежды родом из сибири</h4>
<form action="/" method="get">
    Поиск по названию айтема: <input type="text" name="title">
    <input type="submit" value="Поиск"/>
</form>
<#list products as clothingItem>
    <div>
        <p><b>${clothingItem.title}</b> ${clothingItem.price} руб. | <a href="/clothingItem/${clothingItem.id}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Товаров нет</h3>
</#list>
<#if user.email??>
    <hr>
    <h3>Создать новый айтем</h3>
    <form action="/clothingItem/create" method="post" enctype="multipart/form-data">
        Название объявления: <input type="text" name="title"/><br><br>
        Описание объявления: <input type="text" name="description"/><br><br>
        Цена: <input type="number" name="price"/><br><br>
        Первая фотография: <input type="file" name="file1"/><br><br>
        Вторая фотография: <input type="file" name="file2"/><br><br>
        Третья фотография: <input type="file" name="file3"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить товар"/>
    </form>
</#if>
</body>
</html>