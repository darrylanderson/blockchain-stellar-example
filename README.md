# blockchain-stellar-example
Simple example of a REST API to interact with the Stellar blockchain network.

## Endpoints

`POST /keys` : Creates a random key pair with a secret seed and account id

`POST /accounts` : Creates an account on the Stellar test network using friendbot to fund the account with 1000 lumens

`GET /accounts/{accountId}` : Returns the account information and balances
