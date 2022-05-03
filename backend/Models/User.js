const mongoose = require('mongoose');

const userSchema = mongoose.Schema({
    email: { type: String, required: true, unique: true },
    password: { type: String, required: true },
    isAdministrator: { type: Boolean, required: true },
    emailToken: { type: String },
    isVerified: { type: Boolean, required: true }
  });
  
  module.exports = mongoose.model('User', userSchema);