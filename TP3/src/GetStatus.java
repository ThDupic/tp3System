import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetStatus {
    private String[] hostList = { "http://crunchify.com", "http://yahoo.com",
            "http://www.ebay.com", "http://google.com",
            "http://www.example.co", "https://paypal.com",
            "http://bing.com/", "http://techcrunch.com/",
            "http://mashable.com/", "http://thenextweb.com/",
            "http://wordpress.com/", "http://wordpress.org/",
            "http://example.com/", "http://sjsu.edu/",
            "http://ebay.co.uk/", "http://google.co.uk/",
            "http://www.wikipedia.org/",
            "http://en.wikipedia.org/wiki/Main_Page"};

    private ExecutorService executor = Executors.newFixedThreadPool(18);

    public GetStatus(){
        for(int i = 0;i< hostList.length;i++){
            executor.execute(new WebVerif(hostList[i]));
        }
        executor.shutdown();

    }

}
