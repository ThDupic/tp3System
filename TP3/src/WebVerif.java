import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class WebVerif implements Runnable {

    private String url;

    public WebVerif(String url){
        this.url=url;
    }

    @Override
    public void run() {
        try{
            URL urlVerif = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection)urlVerif.openConnection();
            urlConnection.connect();
            System.out.println("L'URL : "+url+" est OK : "+urlConnection.getResponseCode());
        }catch(IOException e){
            System.out.println("Erreur avec l'URL : "+url);
        }
    }
}
