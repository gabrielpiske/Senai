<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Cadastro de Produtos e Pedidos</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900&display=swap" rel="stylesheet">
    <style>
      body {
        font-family: Poppins, sans-serif;
        background-color: #2b2828;
        margin: 0;
        padding: 20px;
      }

      h1, h2, h3 {
        color: #ffffff;
        text-align: center;
      }

      .container {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        max-width: 900px;
        margin: auto;
      }

      form {
        background-color: #3b3a3a;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, .1);
        max-width: 400px;
        width: 100%;
        margin: 10px 0;
      }

      label {
        display: block;
        margin-bottom: 8px;
        color: #696868;
      }

      input[type="text"],
      input[type="number"],
      input[type="date"] {
        width: calc(100% - 20px);
        padding: 10px;
        margin-bottom: 12px;
        border-radius: 4px;
        background-color: #696868;
        border: none;
        color: #ccc;
      }

      input[type="submit"] {
        background-color: #4caf50;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
      }

      input[type="submit"]:hover {
        background-color: #45a049;
      }

      table {
        width: 100%;
        margin: 20px 0;
        border-collapse: collapse;
      }

      table, th, td {
        border: 1px solid #ddd;
        padding: 8px;
        color: #ccc;
      }

      th {
        background-color: #4caf50;
        color: white;
      }

      tr:nth-child(even) {
        background-color: #3b3a3a;
      }

      tr:hover {
        background-color: #696868;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>Cadastro de Produtos</h1>
      <form action="/produto" method="post">
        <label for="descricao">Descrição:</label>
        <input type="text" id="descricao" name="descricao" required />
        <label for="preco">Preço:</label>
        <input type="number" id="preco" step="0.01" name="preco" required />
        <input type="submit" value="Cadastrar Produto" />
      </form>

      <h1>Cadastro de Pedidos</h1>
      <form action="/pedido" method="post">
        <label for="dataPedido">Data do Pedido:</label>
        <input type="date" id="dataPedido" name="dataPedido" required />
        <label for="produtoId">ID do Produto:</label>
        <input type="number" id="produtoId" name="produto.id" required />
        <input type="submit" value="Cadastrar Pedido" />
      </form>
    </div>

    <h2>Produtos Cadastrados</h2>
    <table>
      <tr>
        <th>ID</th>
        <th>Descrição</th>
        <th>Preço</th>
      </tr>
      <c:forEach items="${produtos}" var="produto">
        <tr>
          <td>${produto.id}</td>
          <td>${produto.descricao}</td>
          <td>${produto.preco}</td>
        </tr>
      </c:forEach>
    </table>

    <h2>Pedidos Cadastrados</h2>
    <table>
      <tr>
        <th>ID</th>
        <th>Data do Pedido</th>
        <th>ID Produto</th>
      </tr>
      <c:forEach items="${pedidos}" var="pedido">
        <tr>
          <td>${pedido.id}</td>
          <td>${pedido.dataPedido}</td>
          <td>${pedido.produto.id}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
