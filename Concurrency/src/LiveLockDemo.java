class Worker {
    private boolean finished = false;

    public void consumeResource(Resource resource) {
        while (!resource.isReady()) {
            System.out.println("waiting for a resource");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setFinished(true);
    }

    public boolean isFinished() {
        return finished;
    }

    private void setFinished(boolean finished) {
        this.finished = finished;
    }
}

class Resource {
    private boolean ready = false;

    public void processWork(Worker worker) {
        while (!worker.isFinished()) {
            System.out.println("waiting for a worker");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setReady(true);
    }

    public boolean isReady() {
        return ready;
    }

    private void setReady(boolean ready) {
        this.ready = ready;
    }
}

public class LiveLockDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Worker worker = new Worker();
        Thread t1 = new Thread(() -> resource.processWork(worker));
        Thread t2 = new Thread(() -> worker.consumeResource(resource));

        t1.start();
        t2.start();
    }
}