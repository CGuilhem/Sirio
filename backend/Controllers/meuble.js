const Meuble = require("../Models/Meuble");

exports.getAllMeubles = (req, res, next) => {
    Meuble.find()
        .then(meubles => res.status(200).json(meubles))
        .catch(error => res.status(400).json({ error: error }));
}