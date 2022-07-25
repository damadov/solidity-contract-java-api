package data;

import java.math.BigInteger;

public class RoyaltyInfo {

	public String receiver;
	public BigInteger royalty_amount;
	public BigInteger amount;
	
	public String getReceiver() {
		return receiver;
	}

	public BigInteger getRoyalty_amount() {
		return royalty_amount;
	}

	public void setRoyalty_amount(BigInteger royalty_amount) {
		this.royalty_amount = royalty_amount;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	
	
}
