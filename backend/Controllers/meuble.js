const Meuble = require("../Models/Meuble");

exports.getAllMeubles = (req, res, next) => {
    console.log("Requête getAllMeubles");

    Meuble.find()
        .then(meubles => res.status(200).json(meubles))
        .catch(error => res.status(400).json({ error: error }));
}

exports.getOneMeuble = (req, res, next) => {
    console.log("Requête getOneMeuble");

    Meuble.findOne({ _id: req.params.id })
        .then(meuble => res.status(200).json(meuble))
        .catch(error => res.status(404).json({ error }));
}

exports.getOneCategorie = (req, res, next) => {
    console.log("Requête getOneCategorie");

    Meuble.find({ categorie: req.params.categorie })
        .then(categorie => res.status(200).json(categorie))
        .catch(error => res.status(404).json({ error }));
}

exports.createMeuble = (req, res, next) => {
    console.log("Requête createMeuble");

    const meubleObject = JSON.parse(req.body.meuble);
    delete meubleObject._id;
    delete req.body._id;

    const tabImagesUrl = [String];
    req.files.forEach(file => {
        tabImagesUrl.push(`${req.protocol}://${req.get('host')}/Images/${file.filename}`);
    });

    const meuble = new Meuble({
        ...meubleObject,     // Raccourci JS
        imagesUrl: tabImagesUrl
    });
    meuble.save()
        .then(() => res.status(201).json({ message: "Meuble enregistré" }))
        .catch(error => res.status(400).json({ error: error }));
}

exports.deleteMeuble = (req, res, next) => {
    console.log("Requête deleteMeuble");

    Meuble.findOne({ _id: req.params.id })
        .then(meuble => {
            if (!meuble) {
                res.status(404).json({
                error: 'Aucun meuble trouvé !'
                });
            } else {
                /*const filename = thing.imageUrl.split('/Images/')[1];
            fileSystem.unlink(`images/${filename}`, () => {
                Meuble.deleteOne({ _id: req.params.id })
                .then(() => res.status(200).json({ message: 'Meuble supprimé !'}))
                .catch(error => res.status(400).json({ error }));
            });*/

            Meuble.deleteOne({ _id: req.params.id })
            .then(() => res.status(200).json({ message: 'Meuble supprimé !'}))
            .catch(error => res.status(400).json({ error }));
            }       
        })
        .catch(error => res.status(500).json({ error }));
};

exports.updateMeuble = (req, res, next) => {
    console.log("Requête updateMeuble");

    Meuble.updateOne({ _id: req.params.id }, { ...req.body.meuble })
      .then(() => res.status(200).json({ message: 'Objet modifié !'}))
      .catch(error => res.status(400).json({ error }));
};