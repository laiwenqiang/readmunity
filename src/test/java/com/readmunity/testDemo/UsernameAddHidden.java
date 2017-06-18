package com.readmunity.testDemo;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by Henry on 17/6/18.
 */
public class UsernameAddHidden {

    //1、进行MD5加密，得到byte[]

    /**
     * 进行MD5加密
     *
     * @param //String 原始的SPKEY
     * @return byte[] 指定加密方式为md5后的byte[]
     */
    private byte[] md5(String strSrc) {
        byte[] returnByte = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            returnByte = md5.digest(strSrc.getBytes("GBK"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnByte;
    }
    //2、得到3-DES的密钥匙

    /**
     * 得到3-DES的密钥匙
     * 根据根据需要，如密钥匙为24个字节，md5加密出来的是16个字节，因此后面补8个字节的0
     *
     * @param //String 原始的SPKEY
     * @return byte[] 指定加密方式为md5后的byte[]
     */
    private byte[] getEnKey(String spKey) {
        byte[] desKey = null;
        try {
            byte[] desKey1 = md5(spKey);
            desKey = new byte[24];
            int i = 0;
            while (i < desKey1.length && i < 24) {
                desKey[i] = desKey1[i];
                i++;
            }
            if (i < 24) {
                desKey[i] = 0;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return desKey;
    }
    //3、3-DES加密

    /**
     * 3-DES加密
     *
     * @param src   要进行3-DES加密的byte[]
     * @param enKey 3-DES加密密钥
     * @return byte[] 3-DES加密后的byte[]
     */
    public byte[] Encrypt(byte[] src, byte[] enKey) {
        byte[] encryptedData = null;
        try {
            DESedeKeySpec dks = new DESedeKeySpec(enKey);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            SecretKey key = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encryptedData = cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedData;
    }
    //4、对字符串进行Base64编码

    /**
     * 对字符串进行Base64编码
     *
     * @param //byte[] src 要进行编码的字符
     * @return String 进行编码后的字符串
     */
    public String getBase64Encode(byte[] src) {
        String requestValue = "";
        try {
            BASE64Encoder base64en = new BASE64Encoder();
            requestValue = base64en.encode(src);
            //System.out.println(requestValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestValue;
    }
    //5、根据需要可以去掉字符串的换行符号

    /**
     * 去掉字符串的换行符号
     * base64编码3-DES的数据时，得到的字符串有换行符号，根据需要可以去掉
     */
    private String filter(String str) {
        String output = null;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int asc = str.charAt(i);
            if (asc != 10 && asc != 13)
                sb.append(str.subSequence(i, i + 1));
        }
        output = new String(sb);
        return output;
    }
    //6、对字符串进行URLDecoder.encode(strEncoding)编码

    /**
     * 对字符串进行URLDecoder.encode(strEncoding)编码
     *
     * @param //String src 要进行编码的字符串
     * @return String 进行编码后的字符串

    public String getURLEncode(String src) {
    String requestValue = "";
    try {
    requestValue = URLEncoder.encode(src);
    } catch (Exception e) {
    e.printStackTrace();
    }
    return requestValue;
    }*/
    //7、对字符串进行URLDecoder.decode(strEncoding)解码

    /**
     * 对字符串进行URLDecoder.decode(strEncoding)解码
     *
     * @param //String src 要进行解码的字符串
     * @return String 进行解码后的字符串

    public String getURLDecoderdecode(String src) {
    String requestValue = "";
    try {
    requestValue = URLDecoder.decode(src);
    } catch (Exception e) {
    e.printStackTrace();
    }
    return requestValue;
    }*/
    //8、进行3-DES解密（密钥匙等同于加密的密钥匙）

    /**
     * 进行3-DES解密（密钥匙等同于加密的密钥匙）。
     *
     * @param //byte[] src 要进行3-DES解密byte[]
     * @param //String spkey分配的SPKEY
     * @return String 3-DES解密后的String
     */
    public String deCrypt(byte[] debase64, String spKey) {
        String strDe = null;
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DESede");
            byte[] key = getEnKey(spKey);
            DESedeKeySpec dks = new DESedeKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            SecretKey sKey = keyFactory.generateSecret(dks);
            cipher.init(Cipher.DECRYPT_MODE, sKey);
            byte ciphertext[] = cipher.doFinal(debase64);
            strDe = new String(ciphertext, "UTF-16LE");
        } catch (Exception ex) {
            strDe = "";
            ex.printStackTrace();
        }
        return strDe;
    }
    //经过以上步骤就可以完成MD5加密，3－DES加密、base64编码传输、base64解码、3－DES解密得到原文。
    //程序全文如下：


    /**
     * 进行MD5加密
     *
     * @param //String 原始的SPKEY
     * @param //byte[] src 要进行3-DES加密的byte[]
     * @param //byte[] enKey 3-DES加密密钥
     * @param //byte[] src 要进行编码的字符
     * @param //String src 要进行编码的字符串
     * @param //String src 要进行3-DES加密的String
     * @param //String spkey分配的SPKEY
     * @return String 3-DES加密后的String
     */

    public String get3DESEncrypt(String src, String spkey) {
        String requestValue = "";
        try {
            //得到3-DES的密钥匙
            byte[] enKey = getEnKey(spkey);
            //要进行3-DES加密的内容在进行/"UTF-16LE/"取字节
            byte[] src2 = src.getBytes("UTF-16LE");
            //进行3-DES加密后的内容的字节
            byte[] encryptedData = Encrypt(src2, enKey);
            //进行3-DES加密后的内容进行BASE64编码
            String base64String = getBase64Encode(encryptedData);
            //BASE64编码去除换行符后
            String base64Encrypt = filter(base64String);
            //对BASE64编码中的HTML控制码进行转义的过程
            requestValue = base64Encrypt;
            //requestValue = getURLEncode(base64Encrypt);
            //System.out.println(requestValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestValue;
    }

    /**
     * 对字符串进行URLDecoder.decode(strEncoding)解码
     *
     * @param src 要进行解码的字符串
     * @param src 要进行3-DES解密byte[]
     * @param src 要进行3-DES解密的String
     * @return String 3-DES加密后的String
     */
    public String get3DESDecrypt(String src, String spkey) {
        String requestValue = "";
        try {
            //得到3-DES的密钥匙
            //URLDecoder.decodeTML控制码进行转义的过程
            //String URLValue = getURLDecoderdecode(src);
            //进行3-DES加密后的内容进行BASE64编码
            BASE64Decoder base64Decode = new BASE64Decoder();
            byte[] base64DValue = base64Decode.decodeBuffer(src);
            //要进行3-DES加密的内容在进行/"UTF-16LE/"取字节
            requestValue = deCrypt(base64DValue, spkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestValue;
    }

    //@Test
    public void maintest() {
        UsernameAddHidden test = new UsernameAddHidden();
        String oldString = "毒素发";
        String SPKEY = "1234";
        System.out.println("1。分配的SPKEY为: " + SPKEY);
        System.out.println("2。的内容为: " + oldString);
        String reValue = test.get3DESEncrypt(oldString, SPKEY);
        reValue = reValue.trim().intern();
        System.out.println("进行3-DES加密后的内容: " + reValue);
        String reValue2 = test.get3DESDecrypt(reValue, SPKEY);
        System.out.println("进行3-DES解密后的内容: " + reValue2);
    }

    /**
     * 3重DES加密
     *
     * @param src
     * @param DES_KEY 密钥长度不少于24的倍数位
     * @return
     */
    public static String EncryptBy3DES(String src, String DES_KEY) {
        String result = null;
        try {
            SecureRandom secureRandom = new SecureRandom();
            DESedeKeySpec sedeKeySpec = new DESedeKeySpec(DES_KEY.getBytes());

            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
            SecretKey key = secretKeyFactory.generateSecret(sedeKeySpec);

            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, secureRandom);

            byte[] bytesresult = cipher.doFinal(src.getBytes());
            result = new sun.misc.BASE64Encoder().encode(bytesresult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 3重DES解密
     *
     * @param src
     * @param DES_KEY
     * @return
     */

    public static String decryptBy3DES(String src, String DES_KEY) {
        String deresult = null;
        try {
            SecureRandom secureRandom = new SecureRandom();
            DESedeKeySpec sedeKeySpec = new DESedeKeySpec(DES_KEY.getBytes());

            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
            SecretKey key = secretKeyFactory.generateSecret(sedeKeySpec);

            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, secureRandom);

            byte[] bytesresult = cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(src));
            deresult = new String(bytesresult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deresult;
    }

    //定义一个要加密的字符串
    private static String src = "imoocsecurity3des";

    @Test
    public void main2() {
        //调用加密的方法并打印查看结果

        System.out.println(EncryptBy3DES(src, "123456781234567812345678"));

        //将加密后的结果放入解密的方法，由于是对称加密，因此加解密的密钥都是同一个
        System.out.println(decryptBy3DES("lA/dMJvyrb2Q/BtmUKPPEdNwn5+TwCxA", "123456781234567812345678"));
    }

    private final static String DES = "DES";
    private final static String ENCODE = "GBK";
    private final static String defaultKey = "test1234";

    //@Test
    public void main3() throws Exception {
        String data = "测试ss";
        // System.err.println(encrypt(data, key));
        // System.err.println(decrypt(encrypt(data, key), key));
        System.out.println(encrypt(data));
        System.out.println(decrypt(encrypt(data)));

    }

    /**
     * 使用 默认key 加密
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午02:46:43
     */
    public static String encrypt(String data) throws Exception {
        byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    /**
     * 使用 默认key 解密
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午02:49:52
     */
    public static String decrypt(String data) throws IOException, Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, defaultKey.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws IOException,
            Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, key.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    @Test
    public void main4(){
        try {
            Cipher cipher=Cipher.getInstance("DESede/CBC/PKCS5Padding");


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

    }
}