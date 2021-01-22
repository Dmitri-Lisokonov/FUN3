package interfaces;

import interfaces.IObserver;

public interface ISubject {
    public void attach(IObserver o);
    public void detach(IObserver o);
    public void allNotify();
}