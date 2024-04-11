package homework.lesson24;

import javax.sql.rowset.FilteredRowSet;
import java.io.*;

public class OutputDecorator extends FilterOutputStream {
    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            {@code null} if this instance is to be
     *            created without an underlying stream.
     */
    public OutputDecorator(OutputStream out) {
        super(out);
    }
    @Override
    public void write(byte[] bytes) throws IOException {
        String pKey = "1111";
        byte[] key = pKey.getBytes();
        byte[] res = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            res[i] = (byte) (bytes[i] ^ key[i % key.length]);
        }
        out.write(res, 0, res.length);
    }
}
