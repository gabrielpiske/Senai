document.getElementById('addButton').addEventListener('click', handleAddButtonClick);
document.getElementById('clearButton').addEventListener('click', clearForm);
document.querySelectorAll('#userForm input').forEach(input => input.addEventListener('input', updateButtonStates));

function handleAddButtonClick() {
    if (!isFormValid()) {
        alert("Por favor, preencha todos os campos antes de adicionar.");
        return;
    }

    addUserToTable(getFormData());
    clearForm();
    updateButtonStates();
}

function isFormValid() {
    return Array.from(document.querySelectorAll('#userForm input')).every(input => input.value.trim() !== "");
}

function getFormData() {
    return {
        name: document.getElementById('name').value.trim(),
        email: document.getElementById('email').value.trim(),
        phone: document.getElementById('phone').value.trim(),
        address: document.getElementById('address').value.trim(),
        city: document.getElementById('city').value.trim(),
        state: document.getElementById('state').value.trim()
    };
}

function addUserToTable({ name, email, phone, address, city, state }) {
    const table = document.getElementById('userTable').getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();

    [name, email, phone, address, city, state].forEach((value, index) => newRow.insertCell(index).innerText = value);
}

function clearForm() {
    document.getElementById('userForm').reset();
}

function updateButtonStates() {
    const isFormFilled = Array.from(document.querySelectorAll('#userForm input')).some(input => input.value.trim() !== "");
    document.getElementById('addButton').disabled = !isFormFilled;
    document.getElementById('clearButton').disabled = !isFormFilled;
}