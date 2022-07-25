# solidity-contract-java-api

## Examples:

**Get NFT Contract Info**

uri: /contract/info
method: post
request:

```
{
    "contract_address":"0x81D5eC4c51ea0E0003158a690C7Dc0f09A697792",
    "chain_id":"0xa869"
}
```

response:

```
{
    "status": "OK",
    "responseTime": "2022-07-25 17:48:14",
    "data": {
        "address": "0x81D5eC4c51ea0E0003158a690C7Dc0f09A697792",
        "chainId": "0xa869",
        "symbol": "XER1",
        "title": "Xerians-G1.3",
        "standard": "erc721",
        "owner_address": "0x3aae417d4844a022ec6341d561496c491ca147d3"
    },
    "count": 0
}
```

<hr>

**Get NFT Total Supply**

uri: /contract/info
method: post
request:

```
{
    "contract_address":"0x81D5eC4c51ea0E0003158a690C7Dc0f09A697792",
    "chain_id":"0xa869"
}
```

response:
```
{
    "status": "OK",
    "responseTime": "2022-07-25 17:54:53",
    "data": {
        "balance": 4
    },
    "count": 0
}
```

<hr>

**Get User's NFT Balance**

uri: /contract/info
method: post
request:

```
{
    "contract_address":"0x81D5eC4c51ea0E0003158a690C7Dc0f09A697792",
    "chain_id":"0xa869",
    "wallet_address":"0x3aae417d4844a022ec6341d561496c491ca147d3"
}
```

response:

```
{
    "status": "OK",
    "responseTime": "2022-07-25 17:55:40",
    "data": {
        "balance": 1
    },
    "count": 0
}
```

<hr>

**Get NFT Royalty Amount**

uri: /contract/royalty
method: post
request:

```
{
    "contract_address":"0x81D5eC4c51ea0E0003158a690C7Dc0f09A697792",
    "chain_id":"0xa869",
    "token_id":0,
    "amount":100
}
```

response:

```
{
    "status": "OK",
    "responseTime": "2022-07-25 18:37:14",
    "data": {
        "receiver": "0x3aae417d4844a022ec6341d561496c491ca147d3",
        "royalty_amount": 5,
        "amount": 100
    },
    "count": 0
}
```
