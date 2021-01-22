package edges;

import calculate.*;
import interfaces.IEdgeCalculatable;
import interfaces.IObserver;
import javafx.concurrent.Task;

import java.util.ArrayList;

public class RightCalculatable extends Task<ArrayList<Edge>> implements IObserver, IEdgeCalculatable {

    private KochFractal fractal;
    private KochManager manager;
    public ArrayList<Edge> edges = new ArrayList<>();
    private int current = 0;
    private int MAX;


    public RightCalculatable(int nxt, KochManager manager){
        fractal = new KochFractal();
        this.manager = manager;
        fractal.setLevel(nxt);
        fractal.attach(this);
        MAX = fractal.getNrOfEdges() / 3;
    }

    @Override
    public ArrayList<Edge> call() throws Exception {
        fractal.generateRightEdge();
        edges.addAll(fractal.getEdges());
        return edges;
    }

    @Override
    public void update() {

        this.current = fractal.current;
        updateProgress(current, MAX);
        updateMessage(String.valueOf(current));
    }

    @Override
    public void done(){
        manager.incrementCount();
    }
}
