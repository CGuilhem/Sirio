const jsonWebToken = require('jsonwebtoken');

exports.isAuthenticated = (req, res, next) => {
    try {
        //const token = req.headers.authorization.split(' ')[1]; // Pour enlever le mot BEARER au début de la requête
        // const userId = decodedToken.userId;
        // req.auth = { userId }; // raccourci js pour attribuer la valeur d'une variable à une clé du même nom
        // console.log(req.auth);
        // console.log(req.body.userId)
        // console.log(decodedToken.isAdministrator)
        const token = req.cookies.cookie_auth
        const decodedToken = jsonWebToken.verify(token, 'RANDOM_TOKEN_SECRET');
        
        next();
    } catch (error) {
        res.clearCookie("cookie_auth");
        res.status(401).json({ error: 'Requête non authentifiée !' });
    }
}

exports.isAdministrator = (req, res, next) => {
    try {
        const token = req.headers.authorization.split(' ')[1]; // Pour enlever le mot BEARER au début de la requête
        const decodedToken = jsonWebToken.verify(token, 'RANDOM_TOKEN_SECRET');
        const userId = decodedToken.userId;
        const isAdministrator = decodedToken.isAdministrator;
        req.auth = { userId }; // raccourci js pour attribuer la valeur d'une variable à une clé du même nom
        if (req.body.userId && req.body.userId != userId) {
            throw 'User ID non valable !';
        } else {
            if (isAdministrator) {
                next();
            } else {
                throw 'User n\'est pas un administrateur !';
            }
            
        }
    } catch (error) {
        res.status(401).json({ error: error | 'Requête non authentifiée !' });
    }
}