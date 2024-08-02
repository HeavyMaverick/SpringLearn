<!DOCTYPE html>
<html>
<head>
    <title>SHARPSTORE</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

<div class="wrapper bg-white">
    <div class="h2 text-center">Creativity</div>
    <div class="h4 text-muted text-center pt-2">Enter your login details</div>
    <form class="pt-3">
        <div class="form-group py-2">
            <div class="input-field">
                <span class="far fa-user p-2"></span>
                <input type="text" placeholder="Username or Email Address" required class="">
            </div>
        </div>
        <div class="form-group py-1 pb-2">
            <div class="input-field">
                <span class="fas fa-lock p-2"></span>
                <input type="text" placeholder="Enter your Password" required class="">
                <button class="btn bg-white text-muted">
                    <span class="far fa-eye-slash"></span>
                </button>
            </div>
        </div>
        <div class="d-flex align-items-start">
            <div class="remember">
                <label class="option text-muted"> Remember me
                    <input type="radio" name="radio">
                    <span class="checkmark"></span>
                </label>
            </div>
            <div class="ml-auto">
                <a href="#" id="forgot">Forgot Password?</a>
            </div>
        </div>
        <button class="btn btn-block text-center my-3">Log in</button>
        <div class="text-center pt-3 text-muted">Not a member? <a href="#">Sign up</a></div>
    </form>
</div>

<h1>SHARPSTORE</h1><hr>
<h4>Авторизация</h4>
<form action="/login" method="post">
    Эл. почта: <input type="email" name="username"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
</form>
<a href="/registration">Зарегистрироваться</a>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>


</html>