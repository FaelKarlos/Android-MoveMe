package moveme.com.br.moveme;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import moveme.com.br.moveme.Passageiro;

public class HttpServicePassageiro extends AsyncTask<String, Void, Passageiro> {

    private String passageiro;

    public HttpServicePassageiro(String passageiro) {
        this.passageiro = passageiro;
    }

    public HttpServicePassageiro() {

    }

    @Override
    protected Passageiro doInBackground(String... voids) {
        StringBuilder resposta = new StringBuilder();

        Gson gson = new Gson();

        String jsonUsuario = gson.toJson(passageiro);
        System.out.println("Passageiro no doInBackground: " + passageiro);
        System.out.println("Passageiro no doInBackground J: " + jsonUsuario);

        Passageiro passageiroRetorno = gson.fromJson(passageiro, Passageiro.class);
        System.out.println("Objeto: " + passageiroRetorno);

        try {
            URL url = new URL("http://192.168.1.12:8080/MoveMe/rest/cadastropassageiro/inserirpassageiro");

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


            OutputStream writer = connection.getOutputStream();

            writer.write(passageiro.getBytes());
            writer.flush();
            System.out.println("Veja se foi enviado para o WS");


            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            //Pegar o retorno BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String retorno;
            while ((retorno = br.readLine()) != null) {
                System.out.println(retorno);
            }

            connection.disconnect();
            /*Scanner scanner = new Scanner(url.openStream());


            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }
            */

            //return new Gson().fromJson(resposta.toString(), Passageiro.class);
            System.out.println(resposta.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return passageiroRetorno;
    }
}

