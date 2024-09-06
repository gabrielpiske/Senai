function adicionarTexto(){
    var inputText = document.getElementById("inputText").value;
    var textArea = document.getElementById("textArea");

    if(inputText.trim() !== ""){
        textArea.value += inputText + "\n";
        document.getElementById("inputText").value = "";
    } else { 
        alert("Por favor, digite algo na caisa de texto");
    }
}