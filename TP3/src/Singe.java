import java.util.Random;
import java.util.concurrent.Callable;

public class Singe implements Callable {


    public Singe(){
    }

    @Override
    public Object call() throws Exception {
        return (new Random().nextInt(10));
    }



}
