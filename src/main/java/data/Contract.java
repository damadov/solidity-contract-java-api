package data;

import java.math.BigInteger;

import com.google.gson.JsonObject;

import tools.validation.contractType;

public class Contract {
	public String address;
	public String chainId;
	public String chainHex;
	public String chainName;
	public String symbol;
	public String title;
	public JsonObject abiJson;
	public contractType standard = contractType.erc721;
	public BigInteger supply;
	public String owner_address;

	
	public String getOwner_address() {
		return owner_address;
	}
	public void setOwner_address(String owner_address) {
		this.owner_address = owner_address;
	}
	public BigInteger getSupply() {
		return supply;
	}
	public void setSupply(BigInteger supply) {
		this.supply = supply;
	}
	public String getChainHex() {
		return chainHex;
	}
	public void setChainHex(String chainHex) {
		this.chainHex = chainHex;
	}
	public contractType getStandard() {
		return standard;
	}
	public void setStandard(contractType standard) {
		this.standard = standard;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public JsonObject getAbiJson() {
		return abiJson;
	}
	public void setAbiJson(JsonObject abiJson) {
		this.abiJson = abiJson;
	}
	public String getChainId() {
		return chainId;
	}
	public void setChainId(String chainId) {
		this.chainId = chainId;
	}
	public String getChainName() {
		return chainName;
	}
	public void setChainName(String chainName) {
		this.chainName = chainName;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
