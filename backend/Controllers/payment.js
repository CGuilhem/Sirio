const req = require('express/lib/request');
const res = require('express/lib/response');

const stripe = require('stripe')(process.env.STRIPE_PRIVATE_KEY);

const storeItems = new Map([
    [1, { priceInCents: 10000, name: "Chaise SIRIO" }],
    [2, { priceInCents: 20000, name: "Bureau SIRIO" }],
])

exports.createCheckoutSession = async (req, res, next) => {
    console.log("Requête createCheckoutSession");
  
    try {
        const session = await stripe.checkout.sessions.create({
            payment_method_types: ['card'],
            mode: 'payment',
            line_items: req.body.items.map(item => {
                const storeItem = storeItems.get(item.id)
                return {
                    price_data: {
                        currency: "eur",
                        product_data: {
                        name: storeItem.name,
                        },
                        unit_amount: storeItem.priceInCents,
                    },
                    quantity: item.quantity,
                }
            }),
            success_url: `http://www.google.com`,
            cancel_url: `http://twitter.com`
        });
        res.json({ url: session.url })
    } catch (e) {
        res.status(500).json({ error: e.message})
    }
};