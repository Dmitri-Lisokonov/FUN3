package edges;

import interfaces.IObserver;
import calculate.KochFractal;
import calculate.KochManager;
import javafx.concurrent.Task;

import java.util.ArrayList;

public class LeftCalculatable extends Task<ArrayList<Edge>> implements IObserver {

    private KochFractal fractal;
    private KochManager manager;
    public ArrayList<Edge> edges = new ArrayList<>();
    private int current = 0;
    private int MAX;


    public LeftCalculatable(int nxt, KochManager manager){
        fractal = new KochFractal();
        this.manager = manager;
        fractal.setLevel(nxt);
        fractal.attach(this);
        MAX = fractal.getNrOfEdges() / 3;
    }

    @Override
    public ArrayList<Edge> call() throws Exception {
        fractal.generateLeftEdge();
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
