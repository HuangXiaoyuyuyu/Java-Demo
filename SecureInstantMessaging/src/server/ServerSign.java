package server;

import java.security.*;
import java.security.interfaces.*;

public class ServerSign {

    public static byte[] Sign(PrivateKey k, byte[] data) throws Exception {
        RSAPrivateKey prk = (RSAPrivateKey) k;
        Signature s = Signature.getInstance("MD5WithRSA");
        s.initSign(prk);
        s.update(data);
        return s.sign();
    }

    public static boolean CheckSign(PublicKey k, byte[] data, byte[] signeddata)
            throws Exception {/*使用RSA公钥验证数字签名*/
        RSAPublicKey pbk = (RSAPublicKey) k;
        Signature s = Signature.getInstance("MD5WithRSA");
        s.initVerify(pbk);
        s.update(data);
        return s.verify(signeddata);
    }
}