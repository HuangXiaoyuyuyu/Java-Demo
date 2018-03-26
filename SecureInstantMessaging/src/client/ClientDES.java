package client;

import javax.crypto.*;

public class ClientDES {
    public ClientDES() throws Exception{  //DES
        KeyGenerator kg = KeyGenerator.getInstance("DES");//定义DES密钥
        kg.init(56);//密钥初始化为56位
        sKey = kg.generateKey();//生成密钥sKey
    }

    public static byte[] SEnc(SecretKey k, String mode, byte[] data)
            throws Exception{
        //创建 Cipher 对象，调用 Cipher 的 getInstance 方法并将所请求转换的名称传递给它
        Cipher cp = Cipher.getInstance("DES");
        if(mode.equals("DEC"))

            //DECRYPT_MODE, 用于将 Cipher 初始化为解密模式的常量。
            cp.init(Cipher.DECRYPT_MODE, k);//解密数据
        else
            //ENCRYPT_MODE, 用于将 Cipher 初始化为加密模式的常量。
            cp.init(Cipher.ENCRYPT_MODE, k);
        return cp.doFinal(data);//加密data
    }

    public SecretKey getSecretKey(){
        return sKey;
    }

    private SecretKey sKey;
}