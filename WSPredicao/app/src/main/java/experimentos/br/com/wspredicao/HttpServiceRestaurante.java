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
        Restaurante restaurante = new Restaurante();

        Escolha passageiroRetorno = gson.fromJson(escolha, Escolha.class);

            //Cria o objeto Passageiro recebido no construtor

            //Conexão com o web service
            try {
                //Localização do web service
                //http://127.0.0.1/mm?cozinha=Japanese&taxa_votos=Excellent&alcance_preco=4&classifi_agregada=4.7&votos=600
                URL url = new URL("http://d055689b.ngrok.io/api?cozinha=" + passageiroRetorno.getCozinha() + "&taxa_votos=" + passageiroRetorno.getTaxa_votos() + "&alcance_preco=" + passageiroRetorno.getAlcance_preco() + "&classifi_agregada=" + passageiroRetorno.getClassifi_agregada() + "&votos=" + passageiroRetorno.getVotos());

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

                //Pega o que foi retornado pelo web service
                BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
/*
                String retorno;
                //Escreve o retorno em uma variável
                while ((retorno = br.readLine()) != null) {
                    System.out.println(retorno);
                }*/

                String linha;
                StringBuffer buffer = new StringBuffer();
                while((linha = br.readLine()) != null) {
                    buffer.append(linha);
                }

                String str = buffer.toString();
                //System.out.println("String object do buffer: "+str);
                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();


                //Imprimi a resposta
                //System.out.println("Reposta do servidor na htppService: " + buffer.toString());

                String retornado = gson.toJson(str);
                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();

                //Imprimi a resposta
                restaurante = gson.fromJson(str, Restaurante.class);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return restaurante;
    }
}
