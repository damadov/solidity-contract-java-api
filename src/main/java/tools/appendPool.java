package tools;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;


public class appendPool {

	public static <T> T[] concat(T[] array1, T[] array2) {
		return  ArrayUtils.addAll(array1, array2);
	}
	
	public static String[] appendString(String[] list, String item) {
		String[] newlist = null;
		 
		 try {
			 if (list != null && list.length>0) {
				 newlist = new String[list.length+1];
				 
				 for(int i =0;i<list.length;i++) {
					 newlist[i] = list[i];
				 }
				 newlist[list.length] = item;
			 }
			 else {
				 newlist = new String[1];
				 newlist[0] = item;
			 }
			 
			 return newlist;
		 }
		 catch(Exception ex) {
			 tools.console.println(ex.getMessage());
			 return null;
		 }
		 
	 }
	
	public static Integer[] appendInteger(Integer[] list, Integer item) {
		Integer[] newlist = null;
		 
		 try {
			 if (list != null && list.length>0) {
				 newlist = new Integer[list.length+1];
				 
				 for(int i =0;i<list.length;i++) {
					 newlist[i] = list[i];
				 }
				 newlist[list.length] = item;
			 }
			 else {
				 newlist = new Integer[1];
				 newlist[0] = item;
			 }
			 
			 return newlist;
		 }
		 catch(Exception ex) {
			 tools.console.println(ex.getMessage());
			 return null;
		 }
		 
	 }
	public static int[] appendInt(int[] list, int item) {
		int[] newlist = null;
		 
		 try {
			 if (list != null && list.length>0) {
				 newlist = new int[list.length+1];
				 
				 for(int i =0;i<list.length;i++) {
					 newlist[i] = list[i];
				 }
				 newlist[list.length] = item;
			 }
			 else {
				 newlist = new int[1];
				 newlist[0] = item;
			 }
			 
			 return newlist;
		 }
		 catch(Exception ex) {
			 tools.console.println(ex.getMessage());
			 return null;
		 }
		 
	 }
	
	public static BigInteger[] appendItem(BigInteger[] list, BigInteger item) {
		BigInteger[] newlist = null;
		 
		 try {
			 if (list != null && list.length>0) {
				 newlist = new BigInteger[list.length+1];
				 
				 for(int i =0;i<list.length;i++) {
					 newlist[i] = list[i];
				 }
				 newlist[list.length] = item;
			 }
			 else {
				 newlist = new BigInteger[1];
				 newlist[0] = item;
			 }
			 
			 return newlist;
		 }
		 catch(Exception ex) {
			 tools.console.println(ex.getMessage());
			 return null;
		 }
	}
	
	public static BigDecimal[] appendItem(BigDecimal[] list, BigDecimal item) {
		BigDecimal[] newlist = null;
		 
		 try {
			 if (list != null && list.length>0) {
				 newlist = new BigDecimal[list.length+1];
				 
				 for(int i =0;i<list.length;i++) {
					 newlist[i] = list[i];
				 }
				 newlist[list.length] = item;
			 }
			 else {
				 newlist = new BigDecimal[1];
				 newlist[0] = item;
			 }
			 
			 return newlist;
		 }
		 catch(Exception ex) {
			 tools.console.println(ex.getMessage());
			 return null;
		 }
	}
	
	
	
}
