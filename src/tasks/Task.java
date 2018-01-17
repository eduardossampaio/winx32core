package tasks;

import java.util.concurrent.*;

public abstract class Task implements Callable<Void> {
    private int duration;


    public Task(int duration) {
        this.duration = duration;
    }

    protected abstract void doTask();

    @Override
    public Void call() throws Exception {
        doTask();
        return null;
    }

    public void execute() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future =null;
        future = executor.submit(this);
    }

}
