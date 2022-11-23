package application.model;

import java.awt.*;

public class RenderData {

    private Image image;
    private Perspective perspective;

    public RenderData(Image i, Perspective p) {
        image = i;
        perspective = p;
    }

    public Image getImage() {
        return image;
    }

    public Perspective getPerspective()
    {
        return  perspective;
    }
}
