<!DOCTYPE html>
<html>
<head>
    <title>SHARPSTORE</title>
</head>
<body>
<h1>SHARPSTORE</h1><hr>
<h3>Подробная информация о пользователе ${user.name}</h3>
<b>Номер телефона: </b> ${user.phoneNumber}<br>
<b>Email: </b> ${user.email}<br>
<h4>Товары пользователя ${user.name}</h4>
<#list products as clothingItem>
    <div>
        <p><b>${clothingItem.title}</b> ${clothingItem.price} руб. | <a href="/clothingItem/${clothingItem.id}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Товаров нет</h3>
</#list>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>