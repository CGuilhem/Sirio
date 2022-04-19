const mongoose = require('mongoose');

const meubleSchema = mongoose.Schema({
  nom: { type: String, required: true },
  categorie: { type: String, required: true },
  description: { type: String, required: true },
  imagesUrl: { type: [String], required: true },
  prix: { type: Number, required: true },
  stock: { type: Number, required: true },
  note: { type: Number, required: true},
  userId: { type: String }
});

module.exports = mongoose.model('Meuble', meubleSchema);