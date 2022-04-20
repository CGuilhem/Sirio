const Meuble = require("../Models/Meuble");

exports.getAllMeubles = (req, res, next) => {
    Meuble.find()
        .then(meubles => res.status(200).json(meubles))
        .catch(error => res.status(400).json({ error: error }));
}

exports.getOneMeuble = (req, res, next) => {
    Meuble.findOne({ _id: req.params.id })
      .then(meuble => res.status(200).json(meuble))
      .catch(error => res.status(404).json({ error }));
}

exports.createMeuble = (req, res, next) => {
    const meubleObject = JSON.parse(req.body.meuble);
    delete meubleObject._id;
    delete req.body._id;
    const meuble = new Meuble({
        ...meubleObject,     // Raccourci JS
        imagesUrl: [`${req.protocol}://${req.get('host')}/images/${req.file.filename}`]          
    });
    meuble.save()
        .then(() => res.status(201).json({ message: "Meuble enregistré" }))
        .catch(error => res.status(400).json({ error: error }));
}