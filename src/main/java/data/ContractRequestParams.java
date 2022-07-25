package data;

public class ContractRequestParams {

	public String contract_address;
	public String chain_id;
	public String wallet_address;
	
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
