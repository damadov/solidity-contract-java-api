package tools;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class validation {

	public enum itemType{
		ssr,
		sr,
		rare,
		epique
	}
	public enum itemFormat{
		png,
		jpeg,
		mp4,
		mp3,
		mov
	}
	public enum contractType{
		erc20,
		erc721,
		erc1155,
		market
	}
	public enum mediaFormat{
		image,
		video,
		music,
		text
	}
	public enum saleType{
		fixed,
		auction
	}
	
	
	public static Date epochToDate(long epoch,String timeZone) {
		
		Instant instantTime = Instant.ofEpochMilli(epoch);
		ZoneId localZone = ZoneId.of(timeZone);
		ZonedDateTime localDate = ZonedDateTime.ofInstant(instantTime, localZone);

		return Date.from(localDate.toInstant());
		
		
}

public static LocalDate epochToLocalDate(long epoch,String timeZone) {
	
	return Instant.ofEpochMilli(epoch)
            .atZone(ZoneId.of(timeZone)).toLocalDate();
}


public static LocalDateTime epochToLocalDateTime(long epoch,String timeZone) {
	
	return Instant.ofEpochMilli(epoch)
            .atZone(ZoneId.of(timeZone)).toLocalDateTime();
}
		
	public static String dateFormat(String date,String type,Boolean isReverse) {
		
		String str = "";
		tools.console.println(date);
		date = date.replaceAll("-", "").replaceAll(".", "");
		tools.console.println(date);
		if(type.equals("-")) {
			if(isReverse)
				str = date.substring(0, 3)+"-"+date.substring(4, 5)+"-"+date.substring(6);
			else
				str = date.substring(0, 3)+"-"+date.substring(4, 5)+"-"+date.substring(6);
		}
		
		return str;
		
	}
	
	
	public static long betweenDates(Date firstDate, Date secondDate) throws IOException
	{
	    return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
	}
	
	public static float round(float value, int scale) {
	    int pow = 10;
	    for (int i = 1; i < scale; i++) {
	        pow *= 10;
	    }
	    float tmp = value * pow;
	    float tmpSub = tmp - (int) tmp;

	    return ( (float) ( (int) (
	            value >= 0
	            ? (tmpSub >= 0.5f ? tmp + 1 : tmp)
	            : (tmpSub >= -0.5f ? tmp : tmp - 1)
	            ) ) ) / pow;


	}
	
	public static int calculateAge(
			  String bdate,
			  String currdate) {
		
		LocalDate birthDate = LocalDate.parse(bdate);
		LocalDate currentDate = LocalDate.parse(currdate);
		
			 return Period.between(birthDate, currentDate).getYears();
			}
	
	  public static String setRandomItem(String code,int min,int max) {
			 try {
			  Random random = new Random();
			  int rnd = ThreadLocalRandom.current().nextInt(min, max) + min;
			  code = code + rnd;
			  return code;
			 }catch(Exception ex) {
				 System.out.println(ex.getLocalizedMessage());
				 return code+"1";
			 }
		  }
		  
		  public static int setRandom(int min,int max) {
			 try {

			  int rnd = ThreadLocalRandom.current().nextInt(min, max) + min;

			  return rnd;
			 }catch(Exception ex) {
				 System.out.println(ex.getLocalizedMessage());
				 return 0;
			 }
		  }
	
		  public static long getChainLong(String chain_id) {
			  if(chain_id.equals("0xa869"))
				  return 0xa869;
			  else  if(chain_id.equals("0xa86a"))
				  return 0xa86a;
			  else if(chain_id.equals("0x61"))
				  return 0x61;
			  else if(chain_id.equals("0x38"))
				  return 0x38;
			  else if(chain_id.equals("0x1"))
				  return 0x1;
			  else if(chain_id.equals("0x5"))
				  return 0x5;
			  else
				  return 0xa869;
		  }
		  
		  public static String chainRPC(String chain_id) {
			  if(chain_id.equals("0x61") || chain_id.equals("0x38"))
			 		 return appConfig.chainStackNodeBNB;
	    		 else if(chain_id.equals("0x13881") || chain_id.equals("0x89"))
			 		 return appConfig.chainStackNodeMATIC;
			 	 else if(chain_id.equals("0xa869") || chain_id.equals("0xa86a"))
			 		 return appConfig.chainStackNodeAVAX;
			 	 else if(chain_id.equals("0x1") || chain_id.equals("0x5"))
			 		 return appConfig.chainStackNodeETH;
			 	 else return null;
		  }

	@SuppressWarnings("unused")
	public static int random(int min, int max) {
		
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
		
	}

}
