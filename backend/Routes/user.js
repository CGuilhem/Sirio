const express = require('express');
const router = express.Router();

const userController = require('../Controllers/user');

router.use((req, res, next) => {       // Ajout de headers pour éviter les erreurs cross, comme nos deux parties n'ont pas la même origine. Les requêtes sont automatiquement bloquées par le navigateur
    res.setHeader('Access-Control-Allow-Origin', '*'); // Accès depuis n'importe quelle origine
    res.setHeader('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content, Accept, Content-Type, Authorization');
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, PATCH, OPTIONS');
    next();
});

router.post('/signup', userController.signup);
router.post('/login', userController.login);

module.exports = router;