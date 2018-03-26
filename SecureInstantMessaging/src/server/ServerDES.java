package server;

import javax.crypto.*;

public class ServerDES {

    public ServerDES() throws Exception {/*产生DES密钥*/
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(56);
        sKey = kg.generateKey();
    }

    public static byte[] SEnc(SecretKey k, String mode, byte[] data)
            throws Exception {
        Cipher cp = Cipher.getInstance("DES");
        if (mode.equals("DEC")) {
            cp.init(Cipher.DECRYPT_MODE, k);
        } else {
            cp.init(Cipher.ENCRYPT_MODE, k);
        }
        return cp.doFinal(data);
    }

    public SecretKey getSecretKey() {
        return sKey;
    }
    private SecretKey sKey;
}