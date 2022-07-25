# solidity-contract-java-api

## Examples:

<b>Get NFT Contract Info</b>

uri: /contract/info
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

<b>Get NFT Total Supply</b>

uri: /contract/info
request:

```
{
    "contract_address":"0x81D5eC4c51ea0E0003158a690C7Dc0f09A697792",
    "chain_id":"0xa869"
}
'''

response:
'''
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

<b>Get User's NFT Balance</b>

uri: /contract/info
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
