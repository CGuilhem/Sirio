const bcrypt = require('bcrypt');
const jsonWebToken = require('jsonwebtoken');

const User = require('../Models/User');


exports.signup = (req, res, next) => {
    console.log("Requête signup");

    bcrypt.hash(req.body.password, 10)
      .then(hash => {
        const user = new User({
          email: req.body.email,
          password: hash,
          isAdministrator: false
        });
        user.save()
          .then(() => res.status(201).json({ message: 'Utilisateur créé !' }))
          .catch(error => res.status(400).json({ error }));
      })
      .catch(error => res.status(500).json({ error }));
};

exports.createAdmin = (req, res, next) => {
  console.log("Requête createAdmin");

  bcrypt.hash(req.body.password, 10)
    .then(hash => {
      const user = new User({
        email: req.body.email,
        password: hash,
        isAdministrator: true
      });
      user.save()
        .then(() => res.status(201).json({ message: 'Administrateur créé !' }))
        .catch(error => res.status(400).json({ error }));
    })
    .catch(error => res.status(500).json({ error }));
};

exports.login = (req, res, next) => {
    console.log("Requête login");

    User.findOne({ email: req.body.email })
      .then(user => {
        if (!user) {
          return res.status(401).json({ error: 'Utilisateur non trouvé !' });
        }
        bcrypt.compare(req.body.password, user.password)
          .then(valid => {
            if (!valid) {
              return res.status(401).json({ error: 'Mot de passe incorrect !' });
            }
            res.status(200).json({
              userId: user._id,
              token: jsonWebToken.sign(
                  { userId: user._id, isAdministrator: user.isAdministrator },
                  'RANDOM_TOKEN_SECRET',
                  { expiresIn: '24h' }
              )
            });
          })
          .catch(error => res.status(500).json({ error }));
      })
      .catch(error => res.status(500).json({ error }));
};

exports.signupGoogle = (req, res, next) => {
    console.log(req.body)
}