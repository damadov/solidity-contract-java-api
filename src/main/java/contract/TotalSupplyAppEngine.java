package contract;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import blockchain.Web3JavaClient;
import data.Balance;
import data.ContractRequestParams;
import data.PSCResponse;
import tools.appConfig;
import tools.requestTool;

@WebServlet(
    name = "TotalSupplyAppEngine",
    urlPatterns = {"/contract/total"}
)
public class TotalSupplyAppEngine extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

	  Gson gson = new GsonBuilder().create();
	  Calendar cal = Calendar.getInstance();
	  PSCResponse resp1 = null;
	  
	  HttpSession session = request.getSession();
		String ipAddress = requestTool.getIP(request);
		String reqInfo = requestTool.getInfo(request);
		String json_req = requestTool.getJSON(request);
		String lang = requestTool.getLanguage(request);
		String chain_id = requestTool.getChainId(request);
		
		try {
		
			appConfig.ownerPrv = "cd481e2fb81ffccd7abc94546779afad3206d2f807b9a56c27ba499865c9d8fa" ; // "<your_priv_key>";
			appConfig.ownerAddress = "0x3Aae417D4844a022EC6341D561496C491Ca147D3"; // "<your_wallet_address>";
			
			ContractRequestParams params = gson.fromJson(json_req, ContractRequestParams.class);
			
	  	 Web3JavaClient web3 = new Web3JavaClient();
		 BigInteger amount = web3.getNFTSupply(params.contract_address, params.chain_id);
		 Balance balance = new Balance();
		 balance.setBalance(amount);
		 
		 
		 	resp1 = new PSCResponse();
			resp1.setResponseTime(appConfig.sdfDetail.format(cal.getTime()));
			resp1.setStatus("OK");
			resp1.setData(new JsonParser().parse(gson.toJson(balance, Balance.class)).getAsJsonObject());


			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(gson.toJson(resp1, PSCResponse.class));
				 
				 
				 
		}catch(Exception ex) {
			
			resp1 = new PSCResponse();
			resp1.setResponseTime(appConfig.sdfDetail.format(cal.getTime()));
			resp1.setStatus("ERROR");
			data.Error error = new data.Error();
			error.setCode("304");
			error.setMessage(ex.getMessage());
			resp1.setError(error);


			 response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(gson.toJson(resp1, PSCResponse.class));
			tools.console.println(ex.getMessage());
		}

  }
}