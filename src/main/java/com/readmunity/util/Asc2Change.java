package com.readmunity.util;

import com.readmunity.entity.User;

import java.util.Date;

/**
 * Created by Henry on 17/6/20.
 */
public class Asc2Change {

    private static Asc2Change instance;

    private Asc2Change() {
    }

    public static Asc2Change getInstance() {    //对获取实例的方法进行同步
        if (instance == null) {
            synchronized (Asc2Change.class) {
                if (instance == null)
                    instance = new Asc2Change();
            }
        }
        return instance;
    }


    /**
     * 将字符串转换为16进制
     * 字符串: POS88884  转换为16进制 : 504f533838383834
     * @param str
     * @return
     */
    public String convertStringToHex(String str){
        if(str==null||str.length()==0){
            return"";
        }
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]));
        }
        return hex.toString();
    }

    /**
     * 将16进制转换为字符串。
     * //49204c6f7665204a617661 split into two characters 49, 20, 4c...
     * @param hex
     * @return
     */
    public String convertHexToString(String hex){
        if(hex==null||hex.length()==0){
            return"";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for( int i=0; i<hex.length()-1; i+=2 ){
            String output = hex.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            sb.append((char)decimal);
            temp.append(decimal);
        }
        return sb.toString();
    }

    /**
     * 将long转换成16进制
     * @param l
     * @return
     */
    public String convertLongToHex(long l){
        if(l==0)return "";
        return Long.toHexString(l);
    }

    /**
     * 将16进制转换成long
     * @param hex
     * @return
     */
    public long convertHexToLong(String hex){
        if(hex==null||hex.length()==0){
            return 0;
        }
        if(!isHexNumberRex(hex)){
            return 0;
        }
        return Long.valueOf(hex,16);
    }

    /**
     * 校验字符串是不是16进制。
     * @param str
     * @return
     */
    private static boolean isHexNumberRex(String str){
        String validate = "(?i)[0-9a-f]+";
        return str.matches(validate);
    }

    /**
     * 获取加密后的信息
     * email +"0f"+ timelong + validateCode
     * @param user
     * @return
     */
    public synchronized String getAsc2toString(User user){
        String email=user.getEmail();
        long time=user.getResetPassTime().getTime();
        String validateCode=user.getValidateCode().toLowerCase();
        String hexTime=convertLongToHex(time);
        String hexEmail=convertStringToHex(email);
        return hexEmail+SPLIT+hexTime+validateCode;
    }
    private static final String SPLIT="0f";

    public synchronized String getEmailStringtoAsc2(String asc2Info){
        if(asc2Info==null||asc2Info.length()==0){
            return"";
        }
        int index=asc2Info.indexOf(SPLIT);
        if(index==-1) return "";
        String emailInfo=asc2Info.substring(0,index);
        return convertHexToString(emailInfo);
    }
    public synchronized Date getTimeStringtoAsc2(String asc2Info){
        if(asc2Info==null||asc2Info.length()==0){
            return new Date();
        }
        int index=asc2Info.indexOf(SPLIT);
        if(index==-1||RandomCode.SIZE+SPLIT.length()>asc2Info.length()) return new Date();

        String timeInfo=asc2Info.substring(index+SPLIT.length(),asc2Info.length()-RandomCode.SIZE);
        long timeLong=convertHexToLong(timeInfo);
        return new Date(timeLong);
    }
    public synchronized String getCodeStringtoAsc2(String asc2Info){
        if(asc2Info==null||asc2Info.length()==0){
            return"";
        }
        if(RandomCode.SIZE>asc2Info.length()) return "";
        String codeInfo=asc2Info.substring(asc2Info.length()-RandomCode.SIZE,asc2Info.length()).toUpperCase();
        return codeInfo;
    }
}
