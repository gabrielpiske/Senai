let socket;

function connectServer() {
    const serverIp = document.getElementById('serverIp').value;
    const username = document.getElementById('username').value;

    socket = new WebSocket(`ws://${serverIp}:3000`);

    // Evento disparado quando a conexão é estabelecida
    socket.onopen = () => {
        socket.send(JSON.stringify({ type: 'login', username }));
    };

    // Evento disparado quando uma mensagem é recebida do servidor
    socket.onmessage = (event) => {
        const data = JSON.parse(event.data);

        if (data.type === 'updateUsers') {
            const userList = document.getElementById('userList');
            userList.innerHTML = ''; // Limpa a lista existente

            data.users.forEach((user) => {
                if (user.username != "allusers") {
                    const option = document.createElement('option');
                    option.value = user.username;
                    // Exibe nome do usuário seguido do IP
                    option.innerText = `${user.username} (${user.ip})`;
                    userList.appendChild(option);
                }
            });
            const option = document.createElement('option');
            option.value = "Todos";
            option.innerText = "Todos";
            userList.appendChild(option);
        }

        if (data.from && data.message) {
            const chat = document.getElementById('chat');
            chat.innerHTML += `<p><strong>${data.from}:</strong> ${data.message}</p>`;
            const partes = data.message.split(":");
            const linha = parseInt(partes[1].substring(1));
            const coluna = parseInt(partes[0].substring(1));
            const tiro = partes[2];

            
            if (tiro.includes('FOGO')) {
                //alert("FOGO");
                marcaTiro(linha, coluna, "F");
            } else if (tiro.includes('AGUA')) {
                //alert("AGUA");
                marcaTiro(linha, coluna, "A");
            } else if (tiro.includes('TIRO')) {
                //alert("TIRO");
                checkBomb(linha, coluna);
            }
        }
    };
}

function sendFire() {
    if (!socket || socket.readyState !== WebSocket.OPEN) {
        alert("Erro: conexão com o servidor não está ativa!");
        return;
    }
    const message = document.getElementById('fire').value;
    const toUser = document.getElementById('userList').value;
    const username = document.getElementById('username').value;

    socket.send(JSON.stringify({
        type: 'message',
        from: username,
        to: toUser,
        message: message + ":TIRO"
    }));

    document.getElementById('fire').value = '';
}

function infoTiro(msg) {
    const toUser = document.getElementById('userList').value;
    const username = document.getElementById('username').value;

    socket.send(JSON.stringify({
        type: 'message',
        from: username,
        to: toUser,
        message: msg
    }));

    document.getElementById('tiro').value = '';
}

//-----------------------------------------------------------------------------------------------------------------------

const boardSize = 16;
const board = [];

let esquadra = {
    submarino: { size: 1, count: 4, color: 'blue' },
    cruzador: { size: 2, count: 3, color: 'green' },
    hidroaviao: { size: 3, count: 5, color: 'red' },
    encouracado: { size: 4, count: 2, color: 'purple' },
    portaAvioes: { size: 5, count: 1, color: 'orange' }
};

let itemEsquadraAtual = "submarino";
const playerEsquadra = [];
let qtdItemEsquadra = [4, 3, 5, 2, 1];

let jogoIniciado = false;
let currentDirection = 'horizontal';

// tabuleiro visual
function createBoard() {
    const boardContainer = document.getElementById('board');
    boardContainer.innerHTML = '';

    // Criar a matriz 16x16 do tabuleiro
    for (let row = 0; row < boardSize; row++) {
        board[row] = [];
        for (let col = 0; col < boardSize; col++) {
            const cell = document.createElement('div');
            cell.classList.add('cell');
            cell.dataset.row = row;
            cell.dataset.col = col;

            if (row === 0 && col > 0) {
                cell.textContent = String.fromCharCode(64 + col); // letras do alfabeto como titulo
                cell.classList.add('title');
            }
            if (col === 0 && row > 0) {
                cell.textContent = row;
                cell.classList.add('title');
            }

            cell.addEventListener('mousedown', (event) => onCellClick(event, row, col));
            board[row].push(cell);
            boardContainer.appendChild(cell);
        }
    }

}

function createBoardEnimie() {
    const boardContainer = document.getElementById('board2');
    boardContainer.innerHTML = '';

    const boardEnimie = [];

    for (let row = 0; row < boardSize; row++) {
        boardEnimie[row] = [];
        for (let col = 0; col < boardSize; col++) {
            const cell = document.createElement('div');
            cell.classList.add('cell2');
            cell.dataset.row = row;
            cell.dataset.col = col;

            // Adicionar letras na primeira linha e números na primeira coluna
            if (row === 0 && col > 0) {
                cell.textContent = String.fromCharCode(64 + col);
                cell.classList.add('title');
            }
            if (col === 0 && row > 0) {
                cell.textContent = row;
                cell.classList.add('title');
            }

            // Adicionar evento de clique para ataque
            cell.addEventListener('click', () => atirar(row, col));

            boardEnimie[row].push(cell);
            boardContainer.appendChild(cell);
        }
    }
}

function atirar(row, col) {
    if (row < 1 || col < 1) {
        alert("Coloque cordenadas Validas")
    } else {
        const cordenateInput = document.getElementById('fire');
        cordenateInput.value = `C${col}:L${row}`;
    }
}

// mudar o barco atual
function exchangeItem() {
    const shipOrder = ["submarino", "cruzador", "hidroaviao", "encouracado", "portaAvioes"];
    const currentIndex = shipOrder.indexOf(itemEsquadraAtual);

    itemEsquadraAtual = shipOrder[(currentIndex + 1) % shipOrder.length];
    alert(`Agora coloque o ${itemEsquadraAtual}.`);
}

// alterar direção do barco com base no clique do mouse
function onCellClick(event, row, col) {
    let qtd = esquadra[itemEsquadraAtual].count;

    if (event.button === 0) {
        currentDirection = "HORIZONTAL";
        alert("HORIZONTAL" + "\nLinha: " + row + "\nColuna: " + col);
    } else if (event.button === 2) {
        currentDirection = "VERTICAL"
        alert("VERTICAL" + "\nLinha: " + row + "\nColuna: " + col);
    }

    if (esquadra[itemEsquadraAtual].count === 0) {
        alert("Toda esquadra ja esta posicionada");
        return;
    }
    else {
        alert(currentDirection + ": " + "\nLinha: " + row + "\nColuna: " + col + "\n" + itemEsquadraAtual + "\nPosicionado 1 " + itemEsquadraAtual + " restam " + (qtd - 1));
        esquadra[itemEsquadraAtual].count--;
        placePart(row, col);
        if (esquadra[itemEsquadraAtual].count === 0) {
            exchangeItem();
        }
    }
}

function marcaTiro(row, col, tiro) {

    const newBomb = [];
    const msgTiro = tiro;

    document.querySelector(`.cell2[data-row="${row}"][data-col="${col}"]`).classList.add('tiro');
    const cell = document.querySelector(`.cell2[data-row="${row}"][data-col="${col}"]`);

    if (cell) {
        if (msgTiro === 'F') {
            cell.style.backgroundColor = 'green';

        } else if (msgTiro === 'A') {
            cell.style.backgroundColor = 'gray';
        }
    }

    else {
        alert("Célula não existe...")
    }

    newBomb.push({ row, col: col });
}

// colocar o barco
function placePart(row, col) {
    const itemSize = esquadra[itemEsquadraAtual].size;
    const itemColor = esquadra[itemEsquadraAtual].color;
    const newItem = [];

    // Lógica para o hidroavião
    if (itemEsquadraAtual === "hidroaviao") {
        if (currentDirection === "HORIZONTAL") {
            if (col + 1 >= boardSize || row + 1 >= boardSize || col - 1 < 1 || row < 1) {
                alert("Não é possível colocar o hidroavião aqui.");

                esquadra[itemEsquadraAtual].count++;

                return;
            }

            if (
                document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.contains('ship')
            ) {
                alert("Não é possível colocar o hidroavião aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }
            // Marca no tabuleiro como célula em uso
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.add('ship');  // Ponta
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).classList.add('ship'); // Asa esquerda
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.add('ship'); // Asa direita
            // Pinta a cor do hidroavião
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).style.backgroundColor = itemColor;  // Cor da ponta
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).style.backgroundColor = itemColor; // Cor da asa esquerda
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).style.backgroundColor = itemColor; // Cor da asa direita

            newItem.push({ row, col }, { row: row + 1, col: col - 1 }, { row: row + 1, col: col + 1 });


        } else if (currentDirection === "VERTICAL") {
            if (row + 1 >= boardSize || row - 1 < 1 || col < 1 || col + 1 >= boardSize) {
                alert("Não é possível colocar o hidroavião aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            if (
                document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row - 1}"][data-col="${col + 1}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + 1}"]`).classList.contains('ship')
            ) {
                alert("Não é possível colocar o hidroavião aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.add('ship'); // Ponta
            document.querySelector(`.cell[data-row="${row - 1}"][data-col="${col + 1}"]`).classList.add('ship'); // Asa superior
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.add('ship'); // Asa inferior
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).style.backgroundColor = itemColor; // Cor da ponta
            document.querySelector(`.cell[data-row="${row - 1}"][data-col="${col + 1}"]`).style.backgroundColor = itemColor; // Cor da asa superior
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).style.backgroundColor = itemColor; // Cor da asa inferior
            newItem.push({ row, col }, { row: row - 1, col: col + 1 }, { row: row + 1, col: col + 1 });
        }
    }

    else if (itemEsquadraAtual === "submarino") {
        if (currentDirection === "HORIZONTAL") {
            if ((col + itemSize - 1) >= boardSize || (row < 1) || col < 1) {
                alert("Não é possível colocar o submarino aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o submarino aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }

        } else if (currentDirection === "VERTICAL") {
            if ((row + itemSize - 1) >= boardSize || (col < 1) || (row < 1)) {
                alert("Não é possível colocar o submarino aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o submarino aqui.");

                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }

    else if (itemEsquadraAtual === "cruzador") {
        if (currentDirection === "HORIZONTAL") {
            if (col + itemSize - 1 >= boardSize || row < 1 || col < 1) {
                alert("Não é possível colocar o cruzador aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o cruzador aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }
        } else if (currentDirection === "VERTICAL") {
            if (row + itemSize - 1 >= boardSize || col < 1 || row < 1) {
                alert("Não é possível colocar o cruzador aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o cruzador aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }

    else if (itemEsquadraAtual === "encouracado") {
        if (currentDirection === "HORIZONTAL") {
            if (col + itemSize - 1 >= boardSize || col < 1 || row < 1) {
                alert("Não é possível colocar o encouraçado aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o encouraçado aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }
        } else if (currentDirection === "VERTICAL") {
            if (row + itemSize - 1 >= boardSize || row < 1 || col < 1) {
                alert("Não é possível colocar o encouraçado aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o encouraçado aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }

    else if (itemEsquadraAtual === "portaAvioes") {
        if (currentDirection === "HORIZONTAL") {
            if (col + itemSize - 1 >= boardSize || col < 1 || row < 1) {
                alert("Não é possível colocar o porta-aviões aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o porta-aviões aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }
        } else if (currentDirection === "VERTICAL") {
            if (row + itemSize - 1 >= boardSize || row < 1 || col < 1) {
                alert("Não é possível colocar o porta-aviões aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o porta-aviões aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }
}

function checkBomb(row, col) {
    if (document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.contains('ship')) {
        infoTiro('C' + col + ':L' + row + ':FOGO');
    }
    else {
        infoTiro('C' + col + ':L' + row + ':AGUA');
    }
}


window.onload = () => createBoard(), createBoardEnimie();
//window.onload = () => createBoardEnimie();