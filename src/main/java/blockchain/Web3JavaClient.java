package blockchain;


import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.contracts.eip20.generated.ERC20;
import org.web3j.contracts.eip721.generated.ERC721Enumerable;
import org.web3j.contracts.eip721.generated.ERC721Metadata;

import blockchain.XERC721;
import blockchain.XERC721.RoyaltResponse;
import blockchain.XERC721.TransferEventResponse;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;
import org.web3j.protocol.parity.methods.response.ParityExportAccount;
import org.web3j.protocol.parity.methods.response.ParityTracesResponse;
import org.web3j.protocol.parity.methods.response.Trace;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.FastRawTransactionManager;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.response.NoOpProcessor;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import data.Contract;
import data.RoyaltyInfo;
import tools.appConfig;
import tools.appendPool;
import tools.console;
import tools.validation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Web3JavaClient {
   
 
 public Contract getNFTContractInfo(String contractAddress,String chain_id) {
 	
	 
	 
 	try {
 		Web3jService service1 = new HttpService(validation.chainRPC(chain_id));
	 	Web3j web3j1 = Web3j.build(service1);
	 	
	 	 BigInteger privkey = new BigInteger(appConfig.ownerPrv, 16);
	      ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
	      Credentials credentials = Credentials.create(ecKeyPair);
	      NoOpProcessor processor = new NoOpProcessor(web3j1);
	      GasProvider provider = new GasProvider();
	      
	      TransactionManager txManager = new FastRawTransactionManager( web3j1, credentials,processor);
      tools.console.println("Contract connection...");
      XERC721 token = XERC721.load(contractAddress, web3j1, txManager, provider	);
      

      String symbol = token.symbol().send();
      String name = token.name().send();
      String owner = token.owner().send();
      tools.console.println(symbol+" - "+name);
      //BigInteger supply = token.totalSupply().send();
      
      Contract contract = new Contract();
      contract.setChainId(chain_id);
      contract.setTitle(name);
      contract.setSymbol(symbol);
      //contract.setSupply(supply);
     contract.setOwner_address(owner);
     contract.setAddress(contractAddress);
      
      return contract;
      
 	}catch(Exception ex) {
 		tools.console.println("Get NFT Info Chain Error:"+ex.getMessage());
 		return null;
 	}
      
 }
public BigInteger getNFTSupply(String contractAddress,String chain_id) {
 	
	 
	 
 	try {
 		Web3jService service1 = new HttpService(validation.chainRPC(chain_id)); 
	 	Web3j web3j1 = Web3j.build(service1);
	 	
	 	 BigInteger privkey = new BigInteger(appConfig.ownerPrv, 16);
	      ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
	      Credentials credentials = Credentials.create(ecKeyPair);
	      NoOpProcessor processor = new NoOpProcessor(web3j1);
	      GasProvider provider = new GasProvider();
	      
	      TransactionManager txManager = new FastRawTransactionManager( web3j1, credentials,processor);
      tools.console.println("Contract connection...");
      ERC721Enumerable token = ERC721Enumerable.load(contractAddress, web3j1, txManager, provider	);
      

      BigInteger supply = token.totalSupply().send();
      
      tools.console.println("Supply:"+supply.toString());
      
      return supply;
      
 	}catch(Exception ex) {
 		tools.console.println("Get NFT Info Chain Error:"+ex.getMessage());
 		return null;
 	}
      
 }
 public Contract getNFTtoken(String contractAddress,String chain_id) {
 	
	 
	 
 	try {
 		Web3jService service1 = new HttpService(validation.chainRPC(chain_id));
	 	Web3j web3j1 = Web3j.build(service1);
	 	
	 	 BigInteger privkey = new BigInteger(appConfig.ownerPrv, 16);
	      ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
	      Credentials credentials = Credentials.create(ecKeyPair);
	      NoOpProcessor processor = new NoOpProcessor(web3j1);
	      GasProvider provider = new GasProvider();
	      
	      TransactionManager txManager = new FastRawTransactionManager( web3j1, credentials,processor);
      tools.console.println("Contract connection...");
      XERC721 token = XERC721.load(contractAddress, web3j1, txManager, provider	);
      

      String symbol = token.symbol().send();
      String name = token.name().send();
      String owner = token.owner().send();
      tools.console.println(symbol+" - "+name);
      //BigInteger supply = token.totalSupply().send();
      
      Contract contract = new Contract();
      contract.setChainId(chain_id);
      contract.setTitle(name);
      contract.setSymbol(symbol);
      //contract.setSupply(supply);
     contract.setOwner_address(owner);
     contract.setAddress(contractAddress);
      
      return contract;
      
 	}catch(Exception ex) {
 		tools.console.println("Get NFT Info Chain Error:"+ex.getMessage());
 		return null;
 	}
      
 }
    
    
 public Boolean isApprovedForAll(String address,String owner,String operator,String chain_id) {
    	
    	try {
    	 
		Web3jService service1 = new HttpService(validation.chainRPC(chain_id)); 
   	 	Web3j web3j1 = Web3j.build(service1);
   	 	
   	 	 BigInteger privkey = new BigInteger(appConfig.ownerPrv, 16);
   	      ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
   	      Credentials credentials = Credentials.create(ecKeyPair);
   	      NoOpProcessor processor = new NoOpProcessor(web3j1);
   	      GasProvider provider = new GasProvider();
   	      
   	      TransactionManager txManager = new FastRawTransactionManager( web3j1, credentials,processor);
         tools.console.println("Contract connection...");
         XERC721 nftContract = XERC721.load(address, web3j1, txManager, provider);

         Boolean resp = nftContract.isApprovedForAll(owner, operator).send();
      
         tools.console.println("isApprovedForAll:"+resp.toString());
         
         return resp;
         
    	}catch(Exception ex) {
    		tools.console.println(ex.getMessage());
    		return false;
    	}
         
    }
 
 public Boolean getApproved(String address,String operator,BigInteger tokenId,String chain_id) {
	 	
	 	try {
	 	 
	 		Web3jService service1 = new HttpService(validation.chainRPC(chain_id)); 
		 	Web3j web3j1 = Web3j.build(service1);
		 	
		 	 BigInteger privkey = new BigInteger(appConfig.ownerPrv, 16);
		      ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
		      Credentials credentials = Credentials.create(ecKeyPair);
		      NoOpProcessor processor = new NoOpProcessor(web3j1);
		      GasProvider provider = new GasProvider();
		      
		      TransactionManager txManager = new FastRawTransactionManager( web3j1, credentials,processor);
	      tools.console.println("Contract connection...");
	      XERC721 nftContract = XERC721.load(address, web3j1, txManager, provider);

	      String resp = nftContract.getApproved(tokenId).send();

	      tools.console.println("getApproved:"+resp);
	      
	      if(resp.toLowerCase().equals(operator.toLowerCase()))
	    	  return true;
	      else
	    	  return false;
	      
	 	}catch(Exception ex) {
	 		tools.console.println(ex.getMessage());
	 		return false;
	 	}
	      
	 }
 
 public String ownerOf(String address,BigInteger tokenId,String chain_id) {
	 	
	 	try {
	 		Web3jService service1 = new HttpService(validation.chainRPC(chain_id)); 
	 	Web3j web3j1 = Web3j.build(service1);
	 	
	 	 BigInteger privkey = new BigInteger(appConfig.ownerPrv, 16);
	      ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
	      Credentials credentials = Credentials.create(ecKeyPair);
	      NoOpProcessor processor = new NoOpProcessor(web3j1);
	      GasProvider provider = new GasProvider();
	      
	      TransactionManager txManager = new FastRawTransactionManager( web3j1, credentials,processor);
	      tools.console.println("Contract connection...");
	      XERC721 nftContract = XERC721.load(address, web3j1, txManager, provider);

	      String owner = nftContract.ownerOf(tokenId).send();
	      
	      tools.console.println("ownerOf:"+owner);
	      
	      return owner;
	      
	 	}catch(Exception ex) {
	 		tools.console.println(ex.getMessage());
	 		return null;
	 	}
	      
	 }
 
 public String getTokenURI(String address,BigInteger tokenId,String chain_id) {
	 	
	 	try {
	 	 
	 		Web3jService service1 = new HttpService(validation.chainRPC(chain_id)); // put fullnode url here
		 	Web3j web3j1 = Web3j.build(service1);
		 	
		 	 BigInteger privkey = new BigInteger(appConfig.ownerPrv, 16);
		      ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
		      Credentials credentials = Credentials.create(ecKeyPair);
		      NoOpProcessor processor = new NoOpProcessor(web3j1);
		      GasProvider provider = new GasProvider();
		      
		      TransactionManager txManager = new FastRawTransactionManager( web3j1, credentials,processor);
	      tools.console.println("Contract connection...");
	     // XERC721 nftContract = XERC721.load(address, web3j, txManager, provider);
	      ERC721Metadata nftContract = ERC721Metadata.load(address, web3j1, txManager, provider);

	      String tokenUri = nftContract.tokenURI(tokenId).send();
	      tools.console.println("tokenURI:"+tokenUri);
	      
	      return tokenUri;
	      
	 	}catch(Exception ex) {
	 		tools.console.println(ex.getMessage());
	 		return null;
	 	}
	      
	 }

 
 public BigInteger getNFTBalance(String address,String wallet,String chain_id) {
    	
    	try {
    	 
    		Web3jService service1 = new HttpService(validation.chainRPC(chain_id)); // put fullnode url here
		 	Web3j web3j1 = Web3j.build(service1);
		 	
		 	 BigInteger privkey = new BigInteger(appConfig.ownerPrv, 16);
		      ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
		      Credentials credentials = Credentials.create(ecKeyPair);
		      NoOpProcessor processor = new NoOpProcessor(web3j1);
		      GasProvider provider = new GasProvider();
		      
		      TransactionManager txManager = new FastRawTransactionManager( web3j1, credentials,processor);
         tools.console.println("Contract connection...");
         XERC721 nftContract = XERC721.load(address, web3j1, txManager, provider);

         BigInteger balance = nftContract.balanceOf(wallet).send();
         tools.console.println("NFT Balance:"+balance.toString());
         
         return balance;
    	}catch(Exception ex) {
    		tools.console.println(ex.getMessage());
    		return null;
    	}
         
    }

 public RoyaltyInfo getRoyaltyInfo(String address,BigInteger tokenId, BigInteger amount,String chain_id) {
 	
 	try {
 		Web3jService service1 = new HttpService(validation.chainRPC(chain_id));
	 	Web3j web3j1 = Web3j.build(service1);
	 	
	 	 BigInteger privkey = new BigInteger(appConfig.ownerPrv, 16);
	      ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
	      Credentials credentials = Credentials.create(ecKeyPair);
	      NoOpProcessor processor = new NoOpProcessor(web3j1);
	      GasProvider provider = new GasProvider();
	      
	      TransactionManager txManager = new FastRawTransactionManager( web3j1, credentials,processor);
      tools.console.println("Contract connection...");
      XERC721 token = XERC721.load(address, web3j1, txManager, provider);
  
      Tuple2<String, BigInteger> resp = token.royaltyInfo(tokenId, amount).send();
      
      RoyaltyInfo royal = new RoyaltyInfo();
      royal.setReceiver(resp.getValue1());
      royal.setAmount(amount);
      royal.setRoyalty_amount(resp.getValue2());
      
      tools.console.println("Royalty Amount:"+ resp.getValue2().toString());
      
      return royal;
      
 	}catch(Exception ex) {
 		tools.console.println(ex.getMessage());
 		return null;
 	}
      
 }
 
 public String[] getContractOwners(String address,String chain_id) {
	 	
	 String[] items = null;
	 ArrayList<String> owners = new ArrayList<String>(100);
	int cnt = 0;
	 	try {
	 		Web3jService service1 = new HttpService(validation.chainRPC(chain_id));
		 	Web3j web3j1 = Web3j.build(service1);
		 	
		 	 BigInteger privkey = new BigInteger(appConfig.ownerPrv, 16);
		      ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
		      Credentials credentials = Credentials.create(ecKeyPair);
		      NoOpProcessor processor = new NoOpProcessor(web3j1);
		      GasProvider provider = new GasProvider();
		      
		      TransactionManager txManager = new FastRawTransactionManager( web3j1, credentials,processor);
	      tools.console.println("Contract connection...");
	      XERC721 nft = XERC721.load(address, web3j1, txManager, provider);
	  
	    
	      EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST, address);
	
	     
	      nft.transferEventFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
	      	.doOnError(error -> System.err.println("The error message is: " + error.getMessage()))    
	      	.subscribe(eventResponse -> appendPool.appendString(items, "1")             

	      	);
	      if(items!=null)
	    	  tools.console.println("Count:"+items.length);
	      
	    return items;
	      
	 	}catch(Exception ex) {
	 		tools.console.println(ex.getMessage());
	 		return null;
	 	}
	      
	 }
 
 

}
