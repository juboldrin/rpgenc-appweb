function validateLogin() {
    var email = document.getElementsByName("email")[0].value;
    var password = document.getElementsByName("password")[0].value;
    if (email == "usuario@email.com" && password == "123456") {
        alert("Login efetuado com sucesso!");
        return true;
    } else {
        alert("Email ou senha incorretos!");
        return false;
    }
}
