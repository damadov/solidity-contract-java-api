package data;

import java.math.BigInteger;

public class ContractRequestParams {

	public String contract_address;
	public String chain_id;
	public String wallet_address;
	public BigInteger token_id;
	public BigInteger amount;
	
	
	public BigInteger getToken_id() {
		return token_id;
	}
	public void setToken_id(BigInteger token_id) {
		this.token_id = token_id;
	}
	public BigInteger getAmount() {
		return amount;
	}
	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}
	public String getContract_address() {
		return contract_address;
	}
	public void setContract_address(String contract_address) {
		this.contract_address = contract_address;
	}
	public String getChain_id() {
		return chain_id;
	}
	public void setChain_id(String chain_id) {
		this.chain_id = chain_id;
	}
	public String getWallet_address() {
		return wallet_address;
	}
	public void setWallet_address(String wallet_address) {
		this.wallet_address = wallet_address;
	}
	
	
}
