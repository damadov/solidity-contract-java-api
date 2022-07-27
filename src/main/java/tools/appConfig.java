package tools;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class appConfig {

	public static Boolean isLive=false;
	public static Boolean debugOn=false; 
	public static Boolean isProduction=false; 
	 
	  
	public static String xmlContentType = "text/xml;charset=utf-8";
	public static String jsonContentType = "application/json;charset=utf-8";
	public static Boolean isGZIP = true;
	public static String encoding = "UTF-8";
	public static String defaultCurr = "TRY";
	public static String defaultLang = "EN";
	public static String postgreTimeZone = "Europe/Istanbul";
	public static String defaultCountry = "TR";
	
	
	//DEV ... you should set your own credentials to related parameters.
	public static String tokenAddress = "";
	public static String tokenSymbol = "";
	public static String ownerAddress = "<your_wallet_address>";
	public static String ownerPrv = "<your_priv_key>"; 

	public static String chainId = "0xa869";
	public static long chain = 0xa869;
	public static String chainName = "Avalanche Fuji"; // "Avalanche Mainnet";
	public static String snowtraceUrl = "https://testnet.snowtrace.io";
	
	public static String chainStackNodeAVAX= "https://api.avax-test.network/ext/bc/C/rpc";
	public static String chainStackNodeBNB=  "https://data-seed-prebsc-1-s1.binance.org:8545/";
	public static String chainStackNodeMATIC=  "https://rpc-mumbai.maticvigil.com";
	public static String chainStackNodeETH=  "https://eth-goerli.g.alchemy.com/v2/Acxc-AGJyA5nTpopWn00riiGWZz1QpIy";
	
	public static int std_timeout = 60; //in seconds
	public static int mid_timeout = 120; //in seconds
	
	
	
	public static int approve_timelimit = 24; //Hours
	public static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
	public static SimpleDateFormat sdf_=new SimpleDateFormat("yyyy-MM-dd");  
	public static SimpleDateFormat sdf_tr=new SimpleDateFormat("dd.MM.yyyy");  
	public static SimpleDateFormat sdfDetail =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	public static DecimalFormat df = new DecimalFormat("###.##");
	public static String defaultDateFormat = "dd.mm.yyyy";
	


	
}

