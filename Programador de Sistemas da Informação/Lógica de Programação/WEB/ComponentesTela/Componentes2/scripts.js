function exibirSelecionados(){
    var checkBoxes = document.querySelectorAll('input[type="checkbox"]:checked');
    var checkValues = [];

    checkBoxes.forEach((checkBox) => {
        checkValues.push(checkBox.value);
    });

    var radioButtons = document.querySelectorAll('input[name="experience"]:checked');
    var radioValue = radioButtons.length > 0 ? radioButtons[0].value : "Nenhum";

    var selectValue = document.getElementById("country").value || "Nenhum";

    var output = document.getElementById("output");
    output.innerHTML = "<strong>Navegadores Selecionados:</strong>" + 
    (checkValues.length > 0 ? checkValues.join(",") : "Nenhuma") +
    "<br><strong>Nivel de Experiência:</strong>" + radioValue +
    "<br><strong>País Selecionado:</strong>" + selectValue;
}