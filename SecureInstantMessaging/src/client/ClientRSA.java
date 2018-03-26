package client;

import java.security.*;
import javax.crypto.*;


public class ClientRSA {
    public ClientRSA() throws Exception{              //生成密钥对
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");//创建RSA密钥对对象
        kpg.initialize(1024);//初始化密钥长度为1024位
        KeyPair kp = kpg.genKeyPair();//生成密钥对
        pbkey = kp.getPublic();//取得RSA公钥
        prkey = kp.getPrivate();//取得RSA私钥
    }

    public static byte [] wrapkey(Key key, PublicKey publicKey) //实现RSA加密
            throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.WRAP_MODE, publicKey);
        return (cipher.wrap(key));
    }


    public static Key unwrapkey(//实现RSA解密
                                byte []wrapedkey,
                                PrivateKey privateKey,
                                String wrappedKeyAlgorithm,
                                int wrappedKeyType)throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.UNWRAP_MODE, privateKey);
        return (cipher.unwrap(wrapedkey, wrappedKeyAlgorithm, wrappedKeyType));
    }

    public PublicKey getPublicKey(){
        return pbkey;
    }

    public PrivateKey getPrivateKey(){
        return prkey;
    }

    private PublicKey pbkey;
    private PrivateKey prkey;
}