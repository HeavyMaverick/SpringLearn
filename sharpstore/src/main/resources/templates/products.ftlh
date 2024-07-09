<!DOCTYPE html>
<html lang="ru">
<head>
    <title>SHARP STORE</title>
</head>
<body>
<h1>Молодой бренд. Sample TEXT</h1><hr>
<h4>Свое производство, только качественные маериалы</h4>
<#list clothingItems as clothingItem>
    <div>
        <p><b>${clothingItem.title}</b>${clothingItem.price} руб | <a href="/item/${clothingItem.id}">Подробнее...</a> </p>
    </div>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/item/create" method="post">
    Название айтема: <input type="text", name="title"><br><br>
    Описание айтема: <input type="text", name="description"><br><br>
    Материал айтема: <input type="text", name="material"><br><br>
    Цена айтема: <input type="number", name="price"><br><br>
    Коллекция одежды: <input type="text", name="collection"><br><br>
    Количество штук: <input type="number", name="quantity"><br><br>
    <input type="submit" value="Добавить товар">
</form>
</body>
</html>