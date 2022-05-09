const express = require('express');
const router = express.Router();

const authentification = require('../Middlewares/auth');
const multer = require('../Middlewares/multer-config');

const meubleController = require('../Controllers/meuble');

router.use((req, res, next) => {       // Ajout de headers pour éviter les erreurs cross, comme nos deux parties n'ont pas la même origine. Les requêtes sont automatiquement bloquées par le navigateur
    res.setHeader('Access-Control-Allow-Origin', '*'); // Accès depuis n'importe quelle origine
    res.setHeader('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content, Accept, Content-Type, Authorization');
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, PATCH, OPTIONS');
    next();
});

router.get('/', meubleController.getAllMeubles);
router.get('/:id', meubleController.getOneMeuble);
router.get('/type/:categorie', meubleController.getOneCategorie);
router.post('/', authentification.isAdministrator, multer, meubleController.createMeuble);
router.delete('/:id', authentification.isAdministrator, meubleController.deleteMeuble);

/*
router.put('/:id', auth, multer, stuffCtrl.modifyThing);
router.delete('/:id', auth, stuffCtrl.deleteThing);*/

module.exports = router;