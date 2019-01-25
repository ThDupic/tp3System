import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Ramasseur {
    private Integer numberOfBananasCollected;
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private ArrayList<Integer> casier = new ArrayList<Integer>(10);


    public Ramasseur(){

        for (int i = 0; i< 10; i++){
            FutureTask<Integer> futureTask = new FutureTask<Integer>(new Singe());
            executorService.execute(futureTask);

            try {
                casier.set(i, futureTask.get());
            } catch (InterruptedException e) {} catch (ExecutionException e) {}
        }

        executorService.shutdown();

        for(int i =0; i< casier.size(); i++){
            numberOfBananasCollected+=casier.get(i);
        }

        System.out.println("Il y a : "+numberOfBananasCollected+" bananes");
    }
}
