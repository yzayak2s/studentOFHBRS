package org.hbrs.se1.ws21.uebung10;

public class TextDocument extends CoreDocument{
    private TextDocumentEncoding encoding = null;
    private String inhalt = "";
    private int size = 0;

    TextDocument(String inhalt, TextDocumentEncoding encoding){
        this.inhalt = inhalt;
        this.encoding = encoding;
    }

    public String getInhalt() {
        return inhalt;
    }

    public int size(){
        return size;
    }

}
