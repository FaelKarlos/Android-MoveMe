import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import moveme.com.br.moveme.Passageiro;

public class HttpServicePassageiro extends AsyncTask<Void, Void, Passageiro> {

    public HttpServicePassageiro() {

    }
    @Override
    protected Passageiro doInBackground(Void... voids) {
        try {
            URL url = new URL("localhost:8080//MoveMe/rest/servicoteste/cadastro-passageiro");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try {
                connection.setRequestMethod("POST");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);

            connection.connect();

            Scanner scanner = new Scanner(url.openStream());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

