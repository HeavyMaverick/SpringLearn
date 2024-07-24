<!DOCTYPE html>
<html>
<head>
    <title>SHARPSTORE</title>
</head>
<body>
<h1>SHARPSTORE</h1><hr>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Название товара: </b>${clothingItem.title}<br>
<b>Описание товара: </b>${clothingItem.description}<br>
<b>Цена: </b>${clothingItem.price}<br>
<b>Автор: </b>${clothingItem.user.name}<br>
<hr>
</body>
</html>