package com.readmunity.testDemo;

import org.junit.Test;

import java.util.Date;

/**
 * Created by Henry on 17/6/19.
 */
public class Asc2Test {
    /**
     * 字符串中每个字母转化为16进制
     * @param letter
     * @return
     */
    public static String letterToH(String letter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letter.length(); i++) {
            char c = letter.charAt(i);
            sb.append(Integer.toHexString(c));
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }


    /**
     * 16进制转化为字母
     * @param hex  要转化的16进制数，用逗号隔开
     * 		如：53,68,61,64,6f,77
     * @return
     */
    public static String hexTolLetter(String hex) {
        StringBuilder sb = new StringBuilder();
        String[] split = hex.split(",");
        for (String str : split) {
            int i = Integer.parseInt(str, 16);
            sb.append((char)i);
        }
        return sb.toString();
    }


    public String convertStringToHex(String str){

        char[] chars = str.toCharArray();

        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]));
        }

        return hex.toString();
    }

    public String convertHexToString(String hex){

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for( int i=0; i<hex.length()-1; i+=2 ){

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char)decimal);
            temp.append(decimal);
        }

        return sb.toString();
    }
    @Test
    public void test(){
        Asc2Test strToHex = new Asc2Test();
        System.out.println("\n-----ASCII码转换为16进制 -----");
        String str = "cczhaoliang@126.com ";
        System.out.println("字符串: " + str);
        String hex = strToHex.convertStringToHex(str);
        System.out.println("转换为16进制 : " + hex);

        //hex="00c09adb55ca216f60a6ac632c2804a90bb5cb06f46824c292ce59466cfd83a5656d61696cb363637a68616f6c69616e67403132362e636f6da5666f726365c2b374776f5f666163746f725f7665726966696564c2";
        System.out.println("\n***** 16进制转换为ASCII *****");
        System.out.println("Hex : " + hex);
        System.out.println("ASCII : " + strToHex.convertHexToString(hex));

        Date date=new Date();
        long time=date.getTime()/1000*1000;
        System.out.println(time);
        String timeString= Long.toHexString(time);

        System.out.println(   timeString   );
        long time2=Long.valueOf(timeString,16);

        System.out.println(time2);
        System.out.println("ASCII : " + strToHex.convertHexToString("ff"));

        String email="cczhaoliang@126.com";
        String code=new RandomTest().getRandom().toLowerCase();
        String hexEmail = strToHex.convertStringToHex(email);
        String hexTime= Long.toHexString(time);
        String hexInfo=hexEmail+SPLIT+hexTime+SPLIT+code;
        System.out.println(hexInfo);

        int index=hexInfo.indexOf(SPLIT);
        String emailInfo=hexInfo.substring(0,index);
        System.out.println(strToHex.convertHexToString(emailInfo));

        int length=hexInfo.length();
        String codeInfo=hexInfo.substring(length-RandomTest.SIZE,length);

        System.out.println(codeInfo);
        String timeInfo=hexInfo.substring(index+SPLIT.length(),length-RandomTest.SIZE-SPLIT.length());
        System.out.println(timeInfo);
        long timeInfotime=Long.valueOf(timeInfo,16);

        System.out.println("timeInfotime:"+timeInfotime);

        Date date2=new Date(timeInfotime);
        System.out.println(date.getTime());
        System.out.println(date2.getTime());
        System.out.print(date2.compareTo(date));
    }
    private static final String SPLIT="0f";


}
