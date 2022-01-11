package org.hbrs.se1.ws21.uebung10;

public class GraphicDocument extends CoreDocument{
    private final int size = 1200;
    private String url;

    private GraphicDocument(String url) {
        GraphicDocument g = new GraphicDocument(url);
    }
    public int size() {
        return size;
    }
}
