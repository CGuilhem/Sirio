const express = require('express');
const mongoose = require('mongoose');  // Pour grandement faciliter les lectures et écritures avec MongoDB
//const path = require('path')

const meubleRoutes = require('./routes/meuble')

mongoose.connect('mongodb+srv://Go-fullstack:rxFpULW7t8iQ37v@go-fullstack.g95yy.mongodb.net/myFirstDatabase?retryWrites=true&w=majority',
  { useNewUrlParser: true,
    useUnifiedTopology: true })
.then(() => console.log('Connexion à MongoDB réussie !'))
.catch(() => console.log('Connexion à MongoDB échouée !'));

const app = express();


app.use(express.json()); // Pour pouvoir lire les corps des requêtes

//app.use('/Images', express.static(path.join(__dirname, 'Images')));

app.use('/api/meuble', meubleRoutes);

module.exports = app; // Pour pouvoir l'utiliser depuis le serveur node