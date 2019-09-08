package calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class signal {
	private final static String signal[][]= {{"sin"},{"*","/"},{"+","-"}};
	private final static String regx="(sin|cos)";
	public static double compute(String text ) {
		int bnum=0,bpos=0; 
		if(text.contains("(")) {
			for(int i=0;i<text.length();i++) {
				if(text.charAt(i)=='(') {
					bnum++;	
					if(bnum==1) {
						bpos=i;
						
					}
				}else if(text.charAt(i)==')') {
					bnum--;
					if(bnum==0) {System.out.print(i);
						text=text.substring(0, bpos)+compute(text.substring(bpos+1, i).toString())+text.substring(i+1);
						System.out.print(text);
					}
				}
				
			}
		}
		
		Pattern  p =Pattern.compile("[\\d\\.]|"+regx);
		ArrayList<String> sig = new ArrayList<String>();
		String sigstr[]=p.split(text);
		for(int i=0;i<sigstr.length;i++) {
			System.out.print(sigstr[i]+" ");
			if(!sigstr[i].equals(""))sig.add(sigstr[i]);					
		}
		p =Pattern.compile("[\\+\\-\\*\\/]");
		ArrayList<Double> num = new ArrayList<Double>();
		String numstr[]=p.split(text);
		for(int i=0;i<numstr.length;i++) {
		 if(numstr[i]!=null) {			 		
			if(numstr[i].matches(regx+".*")) {
				if(numstr[i].matches(regx)) {
					num.add(process(0.0,-Double.valueOf(numstr[i+1]),numstr[i]));
					numstr[i+1]=null;
					sig.remove(i);
				}else {
					num.add(process(0.0,Double.valueOf(numstr[i].split(regx)[1]),numstr[i].split("[\\d\\.]")[0]));
				}
				continue;
			}
			if(!numstr[i].equals(""))num.add(Double.valueOf(numstr[i]));
			else num.add(0.0);
			System.out.print(num.get(i)); 
			}
		}
		try {						
			for(int s=1;s<signal.length;s++) {
				
			
				for(int i=0;i<sig.size();i++) {	
					for(String j:signal[s]) {
							if(sig.get(i).equals(j)) {
							num.set(i, process(num.get(i),num.get(i+1),j));
							num.remove(i+1);
							sig.remove(i--);
							break;
						}
					}
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num.get(0);
	}
	
	private static double process(double para1,double para2,String sig) {
		if(sig.equals("*")){
			return para1*para2;
		}else if(sig.equals("/")){
			return para1/para2;
		}else if(sig.equals("+")){
			return para1+para2;
		}else if(sig.equals("-")){
			return para1-para2;
		}else if(sig.equalsIgnoreCase("sin")) {
			return Math.sin(para2);
		}
		return 0;
		
	}
}
