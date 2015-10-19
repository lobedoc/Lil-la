package par;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetData {

	public static ArrayList<String> list = new ArrayList<String>();
	public static void getdata(String txt) {
		//String txt="8206358147-BHKK";
		
	    String re1="(\\d)";	// Any Single Digit 1
	    String re2="(\\d)";	// Any Single Digit 2
	    String re3="(\\d)";	// Any Single Digit 3
	    String re4="(\\d)";	// Any Single Digit 4
	    String re5="(\\d)";	// Any Single Digit 5
	    String re6="(\\d)";	// Any Single Digit 6
	    String re7="(\\d)";	// Any Single Digit 7
	    String re8="(\\d)";	// Any Single Digit 8
	    String re9="(\\d)";	// Any Single Digit 9
	    String re10="(\\d)";	// Any Single Digit 10
	    String re11="(-)";	// Any Single Character 1
	    String re12="([a-z])";	// Any Single Word Character (Not Whitespace) 1
	    String re13="([a-z])";	// Any Single Word Character (Not Whitespace) 2
	    String re14="([a-z])";	// Any Single Word Character (Not Whitespace) 3
	    String re15="([a-z])";	// Any Single Word Character (Not Whitespace) 4

	    Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11+re12+re13+re14+re15,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(txt);
	    if (m.find())
	    {
	        String d1=m.group(1);
	        String d2=m.group(2);
	        String d3=m.group(3);
	        String d4=m.group(4);
	        String d5=m.group(5);
	        String d6=m.group(6);
	        String d7=m.group(7);
	        String d8=m.group(8);
	        String d9=m.group(9);
	        String d10=m.group(10);
	        String c1=m.group(11);
	        String w1=m.group(12);
	        String w2=m.group(13);
	        String w3=m.group(14);
	        String w4=m.group(15);
	        
	        list.add(d1.toString()+d2.toString()+d3.toString()+d4.toString()+d5.toString()+d6.toString()+d7.toString()+d8.toString()+
	        		d9.toString()+d10.toString()+c1.toString()+w1.toString()+w2.toString()+w3.toString()+w4.toString());
	    }else{
	    	
	    	list.add(" !!! " );
	    }
	    
	        
	       // System.out.print(d1.toString()+d2.toString()+d3.toString()+d4.toString()+d5.toString()+d6.toString()+d7.toString()+d8.toString()+
	        	//	d9.toString()+d10.toString()+c1.toString()+w1.toString()+w2.toString()+w3.toString()+w4.toString()+"\n");
	    }

	}

