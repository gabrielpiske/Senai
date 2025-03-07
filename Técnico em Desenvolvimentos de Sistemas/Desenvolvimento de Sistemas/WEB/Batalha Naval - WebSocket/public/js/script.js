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
        cordenateInput.value = `L${row}:C${col}`;
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

window.onload = () => createBoard(), createBoardEnimie();
//window.onload = () => createBoardEnimie();