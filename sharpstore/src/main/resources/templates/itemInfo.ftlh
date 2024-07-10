<!DOCTYPE html>
<html lang="ru">
<head>
    <title>SHARP STORE</title>
</head>
<body>
<h1>Молодой бренд. Sample TEXT</h1><hr>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="120px"/><br><br>
</#list>


<b>Название товара: </b>${clothingItem.title}<br>
<b>Описание: </b>${clothingItem.description}<br>
<b>Материал: </b>${clothingItem.material}<br>
<b>Цена: </b>${clothingItem.price}<br>
<b>Коллекция: </b>${clothingItem.collection}<br>
<b>Количество штук: </b>${clothingItem.quantity}<br>
<hr>
<form action="/item/delete/${clothingItem.id}" method="post">
    <input type="submit" value="Удалить товар">
</form>
</body>
</html>