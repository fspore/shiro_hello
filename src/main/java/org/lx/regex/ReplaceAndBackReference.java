package org.lx.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceAndBackReference
{
    private static String REGEX = "(dog[s]{0,1})";//用括号括起来,这样可以在下面用$1来back reference
    private static String REPLACE = "*$1*";//这是要替换成的字符串,$1是dog[s]{0,1}的back reference,整个串就是 *dog* 或 *dogs*
    										//即：原来是什么串,就还是什么串,只不过两边加星号。
    private static String INPUT = "The dog says meow. " +
                                    "All dogs say meow.";

    public static void main(String[] args) {
       Pattern p = Pattern.compile(REGEX);
       // get a matcher object
       Matcher m = p.matcher(INPUT); 
       INPUT = m.replaceAll(REPLACE);
       
       System.out.println(INPUT);
   }
}
