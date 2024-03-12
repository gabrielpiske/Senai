let sliderElement = document.querySelector("#slider");
let buttonElement = document.querySelector("#button");

let sizePassoword = document.querySelector("#valor");
let password = document.querySelector("#password");

let containerPassoword = document.querySelector("#container-password");

let charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZçÇ0123456789!@#$%&*-/";
let novaSenha = "";

sizePassoword.innerHTML = sliderElement.value;
slider.oninput = function(){
    sizePassoword. innerHTML = this.value;
}

function generatePassword(){
    let pass = "";
    for(let i = 0, n = charset.length; i < sliderElement.value; ++i){
        pass += charset.charAt(Math.floor(Math.random() * n));
    }
    containerPassoword.classList.remove("hide");
    password.innerHTML = pass;
    novaSenha =pass;

}

function copyPassoword(){
    alert("Senha copiada com Sucesso!!")
    navigator.clipboard.writeText(novaSenha);
}