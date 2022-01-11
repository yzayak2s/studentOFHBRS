package org.hbrs.se1.ws21.uebung10;

import java.io.UnsupportedEncodingException;

public enum TextDocumentEncoding {
    UTF8,
    UTF16,
    UTF32
    }

public class Encoding {
    private int bytes;
    public int getBytes(TextDocumentEncoding encoding, String string) {
        TextDocumentEncoding UTF = encoding;

        switch (UTF) {
            case UTF8:
                final byte[] utf8Bytes;
                try {
                    utf8Bytes = string.getBytes("UTF-8");
                bytes = utf8Bytes.length;
                break;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            case UTF16:
                final byte[] utf16Bytes;
                try {
                    utf16Bytes = string.getBytes("UTF-16");
                bytes = utf16Bytes.length;
                break;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            case UTF32:
                final byte[] utf32Bytes;
                try {
                    utf32Bytes = string.getBytes("UTF-32");
                bytes = utf32Bytes.length;
                break;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
        }
        return bytes;
    }
}