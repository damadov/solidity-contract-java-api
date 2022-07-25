
package blockchain;

import java.math.BigInteger;

import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

public class GasProvider extends StaticGasProvider {
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(8_000_000); //Convert.toWei("1", Unit.GWEI).toBigInteger();;
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(25_000_000_000L);

    public GasProvider() {
        super(GAS_PRICE, GAS_LIMIT);
    }
}
