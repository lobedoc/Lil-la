package par;

import java.util.ArrayList;
import java.util.regex.*;

public class GetData3 {
	public static ArrayList<String> list = new ArrayList<String>();

  public static void getdata(String txt)
  {

    String re1="(\\d)";	// Any Single Digit 1
    String re2="(\\d)";	// Any Single Digit 2
    String re3="(\\d)";	// Any Single Digit 3

    Pattern p = Pattern.compile(re1+re2+re3,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    Matcher m = p.matcher(txt);
    if (m.find())
    {
        String d1=m.group(1);
        String d2=m.group(2);
        String d3=m.group(3);
        list.add(d1.toString()+d2.toString()+d3.toString());
    }else{
    	
    	list.add(" !!! " );
    }
  }
}
