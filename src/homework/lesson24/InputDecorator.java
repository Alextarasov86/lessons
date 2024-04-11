package homework.lesson24;

import java.io.*;

public class InputDecorator extends FilterInputStream{
    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected InputDecorator(InputStream in) {
        super(in);
    }

    public static String decode(byte[] pText, String pKey){
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();
        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }
        return new String(res);
    }

    public int read(byte[] bytes) throws IOException {
        String pKey = "1111";
        byte[] key = pKey.getBytes();
        byte[] res = new byte[bytes.length];
        for(int i = 0; i < bytes.length; i++){
            res[i] = (byte) (bytes[i] ^ key[i % key.length]);
        }
        return read(res, 0, res.length);
    }

}




