package Esercitazione7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FigureComp implements Figure {
    private List<Figure> figures;

    public FigureComp(List<Figure> figures){
        Objects.requireNonNull(figures);
        for(Figure f : figures) Objects.requireNonNull(f);
        this.figures = new ArrayList<Figure>(figures);
    }

    @Override
    public void draw(BitMap bitmap) {
        for(Figure f: figures){
            f.draw(bitmap);
        }
    }
}
