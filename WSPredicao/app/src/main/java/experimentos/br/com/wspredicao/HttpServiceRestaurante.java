package experimentos.br.com.wspredicao;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpServiceRestaurante extends AsyncTask<String, Void, Restaurante> {

    private String escolha;

    public HttpServiceRestaurante(String escolha) {
        this.escolha = escolha;
    }

    public HttpServiceRestaurante() {

    }

    @Override
    protected Restaurante doInBackground(String... strings) {
        StringBuilder resposta = new StringBuilder();
        Gson gson = new Gson();

        //Converte o Passageiro passado para Json
        String jsonUsuario = gson.toJson(escolha);

        System.out.println("Dao recebidos: " + escolha.toString());
        Escolha passageiroRetorno = gson.fromJson(escolha, Escolha.class);

            //Cria o objeto Passageiro recebido no construtor

            //Conexão com o web service
            try {
                //Localização do web service

                URL url = new URL("http://127.0.0.1:8081/");

                //Abre a conexão
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                try {
                    //Defini o verbo HTTP
                    connection.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }

                //Cabeçalhos da requisição
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);

                //Prepara para enviar dados para a requisição
                OutputStream writer = connection.getOutputStream();

                //Envia o Passageiro passado no construtor
                writer.write(escolha.getBytes());
                writer.flush();

                //Pega o que foi retornado pelo web service
                BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

                String retorno;
                //Escreve o retorno em uma variável
                while ((retorno = br.readLine()) != null) {
                    System.out.println(retorno);
                }

                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();

                //Imprimi a resposta
                System.out.println(resposta.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return null;
    }
}
