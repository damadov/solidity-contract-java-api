package tools;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.*;



public class requestTool {

	public static String reqStr = "";
	public static String resStr = "";
	private static String reqCookie = "";
	private static String resCookie = "";
	

	

	
	
	public static HttpServletResponse setCORS(HttpServletResponse response,Boolean isSet) {
		try {
			

			if(appConfig.isProduction) {
				response.setHeader("Access-Control-Allow-Origin", "*");
			    response.setHeader("Access-Control-Allow-Credentials", "true");
			    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT,PATCH");
			    response.setHeader("Access-Control-Max-Age", "3600");
			    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization-Key,wallet,app-language,chain-id");
			    response.setHeader("Access-Control-Expose-Headers", "Authorization-Key,wallet,app-language,chain-id");
			}
			else if(isSet) {
				response.setHeader("Access-Control-Allow-Origin", "*");
			    response.setHeader("Access-Control-Allow-Credentials", "true");
			    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT,PATCH");
			    response.setHeader("Access-Control-Max-Age", "3600");
			    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization-Key,wallet,app-language,chain-id");
			    response.setHeader("Access-Control-Expose-Headers", "Authorization-Key,wallet,app-language,chain-id");
			    
			}else {
				response.setHeader("Access-Control-Allow-Origin", "*");
			    response.setHeader("Access-Control-Allow-Credentials", "true");
			    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT,PATCH");
			    response.setHeader("Access-Control-Max-Age", "3600");
			    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization-Key,wallet,app-language,chain-id");
			    response.setHeader("Access-Control-Expose-Headers", "Authorization-Key,wallet,app-language,chain-id");
			}
				
			return response;
		}catch(Exception ex){
			return response;
		}
		
		
	}
	
public static String getLanguage(HttpServletRequest request) {
		
		String lang = appConfig.defaultLang;
		
		try {
			
			if(request.getHeader("app-language")!=null && !request.getHeader("app-language").toString().equals("null") && !request.getHeader("app-language").toString().equals("")) {
				tools.console.println("Found lang header:"+request.getHeader("app-language").toString().toLowerCase());
				lang = request.getHeader("app-language").toString().toLowerCase();
			}
			else
				lang = appConfig.defaultLang;
		
		return lang;
		}catch(Exception ex) {
			return "en";
		}
		
	}
public static String getChainId(HttpServletRequest request) {
	
	String chain_id = appConfig.chainId;
	
	try {
		
		if(request.getHeader("chain-id")!=null && !request.getHeader("chain-id").toString().equals("null") && !request.getHeader("chain-id").toString().equals("")) {
			tools.console.println("Found chain_id header:"+request.getHeader("chain-id").toString().toLowerCase());
			chain_id = request.getHeader("chain-id").toString().toLowerCase();
		}
		else
			chain_id = appConfig.chainId;
	
	return chain_id;
	}catch(Exception ex) {
		return appConfig.chainId;
	}
	
}

public static String getWallet(HttpServletRequest request) {
	
	String wallet = null;
	
	try {
		
		if(request.getHeader("wallet")!=null && !request.getHeader("wallet").toString().equals("null") && !request.getHeader("wallet").toString().equals("")) {
			tools.console.println("Found wallet header:"+request.getHeader("wallet").toString().toLowerCase());
			wallet = request.getHeader("wallet").toString().toLowerCase();
		}

	
	return wallet;
	}catch(Exception ex) {
		return null;
	}
	
}
	
	
	
	
	 
	
	
	
	
	public static String getIP(HttpServletRequest request) {
		 String ipAddress = request.getHeader("X-FORWARDED-FOR");  
	       if (ipAddress == null) {  
	         ipAddress = request.getRemoteAddr();  
	       }
		
		return ipAddress;
	}
	public static String getInfo(HttpServletRequest request) {
		try {
			return request.getHeader("user-agent")+"\n"+request.getHeader("from");
		}catch(Exception ex) {
			return "";
			
		}
	}
	
	
	public static String getJSON(HttpServletRequest request) {
		String json_req = "";

		try {
		if(request.getParameter("myData")!=null) {
			  json_req = request.getParameter("myData");
 
		  }
		else if(request.getParameter("newData")!=null) {
			json_req = request.getParameter("newData");
			tools.console.println("Requets parameter updated:"+json_req);
		}
		else if(request.getParameter("key")!=null) {
			json_req = request.getParameter("key");
			tools.console.println("Requets parameter updated:"+json_req);
		}
		else {

			  BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			  String read = br.readLine();

		  		while( read != null )
		  		{
		  			json_req = json_req + read ;
		  			read = br.readLine();
		  		}

		  }
		}catch(Exception ex) {
			tools.console.println("PArsing Request Error"+ex.getMessage());
		}
		
		return json_req;
	}
	
	    public static String getParamsString(Map<String, String> params) 
	      throws UnsupportedEncodingException{
	        StringBuilder result = new StringBuilder();

	        for (Map.Entry<String, String> entry : params.entrySet()) {
	          result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
	          result.append("=");
	          result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
	          result.append("&");
	        }

	        String resultString = result.toString();
	        return resultString.length() > 0
	          ? resultString.substring(0, resultString.length() - 1)
	          : resultString;
	    }

	
	    public static String inputStreamToString(InputStream inputStream) {
	        final int bufferSize = 8 * 1024;
	        byte[] buffer = new byte[bufferSize];
	        final StringBuilder builder = new StringBuilder();
	        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, bufferSize)) {
	            while (bufferedInputStream.read(buffer) != -1) {
	                builder.append(new String(buffer));
	            }
	        } catch (IOException ex) {
	           tools.console.println(ex.getMessage());
	        }
	        return builder.toString();
	    }

	    private static String bytesToHex(byte[] hash) {
	        StringBuilder hexString = new StringBuilder(2 * hash.length);
	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) {
	                hexString.append('0');
	            }
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    }
	    
}
