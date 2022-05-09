const bcrypt = require('bcrypt');
const cookieParser = require('cookie-parser');
const jsonWebToken = require('jsonwebtoken');
const nodeMailer = require('nodemailer');
const nanoid = require('nanoid');

const User = require('../Models/User');

const transporter = nodeMailer.createTransport({
  host: process.env.HOST_MAIL,
  port: process.env.PORT_MAIL,
  secure: true, 
  auth: {
      user: process.env.USER_MAIL,
      pass: process.env.PASSWORD_MAIL
  }
});


exports.signup = (req, res, next) => {
    console.log("Requête signup");
    console.log(req.body.email);

    User.findOne({ email: req.body.email})
    .then(user => {

      if(user) {
        return res.status(400).json({ message: 'Adresse mail déjà utilisée !' })
      } 
      else {
        bcrypt.hash(req.body.password, 10)
        .then(hash => {
          const user = new User({
            email: req.body.email,
            password: hash,
            isAdministrator: false,
            isVerified: false,
            emailToken: nanoid.nanoid()
          });

          const mailOptions = {
            from: '"Verify your email" <rennes1fac@gmail.com>',
            to: user.email,
            subject: 'SIRIO - Verify your email',
            html: `<h2>${user.email} ! Nous vous remercions pour l'inscription sur notre site.</h2>
                    <h4> Veuillez vérifier votre email pour continuer...</h4>
                    <a href="http://${req.headers.host}/api/auth/verify-mail/${user.emailToken}">Cliquez ici</a>`
          }

          transporter.sendMail(mailOptions, (error, success) => {
            if (error) {
              console.log(error);
            } else {
              console.log('Email de confirmation envoyé !');
              user.save()
                .then(() => res.status(201).json({ message: 'Utilisateur créé !' }))
                .catch(error => res.status(400).json({ error }));
            }
          })   
      })
      .catch(error => res.status(500).json({ error }));
      }
    })
};

exports.verifyEmail = (req, res, next ) => {
  console.log("Requête verifyEmail");

  const token = req.params.token;

  User.findOne({ emailToken: token })
  .catch(error => res.status(404).json({ message: 'Utilisateur introuvable' }))
  .then(user => {
    user.emailToken = null;
    user.isVerified = true;

    user.save()
    .then(() => res.status(201).json({ message: 'Adresse email confirmée !' }))
    .catch(error => res.status(400).json({ error }));
  });
}

exports.createAdmin = (req, res, next) => {
  console.log("Requête createAdmin");

  bcrypt.hash(req.body.password, 10)
    .then(hash => {
      const user = new User({
        email: req.body.email,
        password: hash,
        isAdministrator: true,
        isVerified: true,
        emailToken: null
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
            
            if (!user.isVerified) {
              return res.status(401).json({ error: 'Adresse mail non confirmée' });
            }

            const cookie_auth = jsonWebToken.sign({ userId: user._id, isAdministrator: user.isAdministrator },'RANDOM_TOKEN_SECRET', { expiresIn: '24h' });
          
            res.cookie("cookie_auth", cookie_auth, {
              httpOnly: true
            });

            res.status(200).json( {message: "Utilisateur connecté" }).send();
          })
          .catch(error => res.status(500).json({ error }));
      })
      .catch(error => res.status(500).json({ error }));
};

exports.disconnect = (req, res, next) => {
  console.log("Requête disconnect");

  res.clearCookie("cookie_auth");
  res.status(200).json({ message: 'Utilisateur déconnecté !' });
};

exports.signupGoogle = (req, res, next) => {
    console.log(req.body)
}