<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Генерация паролей</title>
</head>
<style>
    label {
        display: inline-block;
    }
    div {
        width: 150px;
    }
    button {
        margin-top: 5px;
    }
</style>
<body>
    <h3>Генерация паролей</h3>
    <div class="details" style="display: block">
        <label id="length">Длина пароля <input style="width: 35px" type="number" minlength="5" maxlength="30"></label>
        <label id="lower">Строчные буквы <input type="checkbox" style="width: 15px; height: 15px"></label>
        <label id="upper">Заглавные буквы <input type="checkbox" style="width: 15px; height: 15px"></label>
        <label id="punctuation">Символы <input type="checkbox" style="width: 15px; height: 15px; margin-right: 50px"></label>
        <label id="digits">Цифры <input type="checkbox" style="width: 15px; height: 15px"></label>
    </div>
    <button id="generate">Сгенерировать пароль</button>
</body>
<script>
    let generate = document.getElementById('generate');
    generate.onclick = () => {
        let length = document.getElementById('length').children[0].value;
        let lower = document.getElementById('lower').children[0].checked;
        let upper = document.getElementById("upper").children[0].checked;
        let digits = document.getElementById('digits').children[0].checked;
        let punctuation = document.getElementById('punctuation').children[0].checked;
        location.href='${pageContext.request.contextPath}' + '/generate?length=' + length + "&l="
            + lower + "&u=" + upper + "&d=" + digits + "&p=" + punctuation;
    }
</script>
</html>