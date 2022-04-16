public class Counter {
    private static int counter;

    public static synchronized int getCounter() {
        return Counter.counter;
    }

    public static synchronized void setCounter() {
        Counter.counter += 1;
    }

    public static synchronized void delCounter(int count) {
        Counter.counter -= count;
    }

    public static synchronized void nullCounter() {
        Counter.counter = 0;
    }
}
