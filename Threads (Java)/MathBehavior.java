import java.util.concurrent.Semaphore;

public abstract class MathBehavior {
    public void doTheMath(Buffer input, Buffer output) throws InterruptedException {
        Semaphore readyToRead = new Semaphore(1);
        Semaphore readyToWrite = new Semaphore(0);

        readyToRead.acquire();
        int x = input.read();
        int y = delegateMath(x);
        readyToWrite.release();

        readyToWrite.acquire();
        output.write(y);
        readyToRead.release();
    }

    protected abstract int delegateMath(int x);
}
