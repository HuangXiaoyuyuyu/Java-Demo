package client;

import java.security.*;
import java.security.interfaces.*;

public class ClientSign {
    public static byte[] Sign(PrivateKey k, byte[] data)
            throws Exception{
        RSAPrivateKey prk = (RSAPrivateKey) k;
        Signature s = Signature.getInstance("MD5WithRSA");//  创建指定算法为MD5WithRSA的 Signature 对象。
        s.initSign(prk);//  初始化这个用于签名的对象。
        s.update(data); // 使用指定的 byte 数组更新要签名或验证的数据。
        return s.sign(); //返回所有已更新数据的签名字节。
    }

    public static boolean CheckSign(PublicKey k, byte[] data, byte[] signeddata)
            throws Exception{
        RSAPublicKey pbk = (RSAPublicKey) k;//将PublicKey类型强制转换为RSAPublicKey类型
        Signature s = Signature.getInstance("MD5WithRSA");//  创建指定算法为MD5WithRSA的 Signature 对象。
        s.initVerify(pbk);//   初始化此用于验证的对象。
        s.update(data); // 使用指定的 byte 数组更新要签名或验证的数据。
        return s.verify(signeddata);//  验证传入的签名。
    }
}
