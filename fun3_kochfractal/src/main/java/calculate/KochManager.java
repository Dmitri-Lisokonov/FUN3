/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

import edges.BottomCalculatable;
import edges.Edge;
import edges.LeftCalculatable;
import edges.RightCalculatable;
import fun3kochfractalfx.FUN3KochFractalFX;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import timeutil.TimeStamp;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class KochManager{

    private KochFractal fractal;
    private ArrayList<Edge> edges;
    private FUN3KochFractalFX application;
    private TimeStamp tsCalc;
    private TimeStamp tsDraw;
    public BottomCalculatable bottomEdges;
    public LeftCalculatable leftEdges;
    public RightCalculatable rightEdges;
    private int count;

    public KochManager(FUN3KochFractalFX application) {
        this.edges = new ArrayList<>();
        this.fractal = new KochFractal();
        this.application = application;
        this.tsCalc = new TimeStamp();
        this.tsDraw = new TimeStamp();
    }

    public void changeLevel(int nxt) {
        ThreadPoolExecutor pool = (ThreadPoolExecutor) newFixedThreadPool(3);
        edges.clear();
        tsCalc.init();
        tsCalc.setBegin("Begin Calc");
        bottomEdges = new BottomCalculatable(nxt, this);
        leftEdges = new LeftCalculatable(nxt, this);
        rightEdges = new RightCalculatable(nxt, this);
        pool.submit(bottomEdges);
        pool.submit(leftEdges);
        pool.submit(rightEdges);
        tsCalc.setBegin("Begin calculating");
    }

    public void showStats(){

        application.setTextNrEdges(Integer.toString(fractal.getNrOfEdges()));
        application.setTextCalc(tsCalc.toString());
    }

    public void showProgress(ProgressBar bar, Task task){
        bar.progressProperty().bind(task.progressProperty());
    }
    
    public void drawEdges() {
        tsDraw.init();
        tsDraw.setBegin("Begin drawing");
        application.clearKochPanel();
        for (Edge e : edges) {
            application.drawEdge(e);
        }
        tsDraw.setEnd("End drawing");
        application.setTextDraw(tsDraw.toString());


    }

    public synchronized void addEdgesToList(){
        edges.addAll(bottomEdges.edges);
        edges.addAll(rightEdges.edges);
        edges.addAll(leftEdges.edges);
    }

    public void isDone(){
        addEdgesToList();
        application.requestDrawEdges();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                showStats();
            }
        });

    }

    public void incrementCount(){
        this.count++;
        if(count == 3){
            this.isDone();
            tsCalc.setEnd("End Calc");
            count = 0;
        }
    }


}
