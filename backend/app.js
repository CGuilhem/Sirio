const express = require('express');
const mongoose = require('mongoose');  // Pour grandement faciliter les lectures et écritures avec MongoDB
const cookieParser = require('cookie-parser');
require('dotenv').config();

//const path = require('path')

const meubleRoutes = require('./Routes/meuble')
const userRoutes = require('./Routes/user')
const paymentRoutes = require('./Routes/payment')

mongoose.connect(process.env.MONGODB,
  { useNewUrlParser: true,
    useUnifiedTopology: true })
.then(() => console.log('Connexion à MongoDB réussie !'))
.catch(() => console.log('Connexion à MongoDB échouée !'));

const app = express();

app.use(cookieParser()); // Pour la gestion des cookies
app.use(express.json()); // Pour pouvoir lire les corps des requêtes application/json

//app.use('/Images', express.static(path.join(__dirname, 'Images')));

app.use('/api/meuble', meubleRoutes);
app.use('/api/auth', userRoutes);
app.use('/api/payment', paymentRoutes);

module.exports = app; // Pour pouvoir l'utiliser depuis le serveur node