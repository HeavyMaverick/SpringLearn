<!DOCTYPE html>
<html lang="ru">
<head>
    <title>SHARP STORE</title>
</head>
<body>
<h1>Молодой бренд. Sample TEXT</h1><hr>
<h4>Свое производство, только качественные маериалы</h4>
<form action="/" method="get">
    Поиск по названию объявления: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list clothingItems as clothingItem>
    <div>
        <p><b>${clothingItem.title}</b> ${clothingItem.price}руб | <a href="/item/${clothingItem.id}">Подробнее...</a> </p>
    </div>
    <#else>
    <h3>Товаров нет.</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/item/create" method="post" enctype="multipart/form-data">
    Название айтема: <input type="text", name="title"><br><br>
    Описание айтема: <input type="text", name="description"><br><br>
    Материал айтема: <input type="text", name="material"><br><br>
    Цена айтема: <input type="number", name="price"><br><br>
    Коллекция одежды: <input type="text", name="collection"><br><br>
    Количество штук: <input type="number", name="quantity"><br><br>
    Первая фотография: <input type="file" name="file1"/><br><br>
    Вторая фотография: <input type="file" name="file2"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Добавить товар">
</form>
</body>
</html>