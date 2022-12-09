const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const config = require('config');
const fs = require("fs");

let data = require("../data.json");

// MIDDLEWARES
app.use(bodyParser.json());

app.get('/listar', function (req, res, next) {
    
    res.status(200).json(data);
});

function randomIntFromInterval(min, max) { // min and max included 
    return Math.floor(Math.random() * (max - min + 1) + min)
}

app.post('/criar', function (req, res, next) {
    // req body
    const id = randomIntFromInterval(000000, 999999);
    const {nome, curso, senha, sem, type} = req.body; //, curso, senha, sem, type
    const user = {nome: nome, curso: curso, senha: senha, sem: sem, id: id, type: type};
    data.push(user);
    fs.writeFile("data.json", JSON.stringify(data), err => {
        if (err) throw err;
    });

    res.status(200).json(["Cadastrado com sucesso", id]);
});

// SETANDO VARIÁVEIS DA APLICAÇÃO
app.set('port', process.env.PORT || config.get('server.port'));

const port = app.get('port');

// RODANDO NOSSA APLICAÇÃO NA PORTA SETADA
app.listen(port, () => {
  console.log(`Servidor rodando na porta ${port}`)
});