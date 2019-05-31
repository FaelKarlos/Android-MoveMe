package moveme.com.br.moveme.conexao.webservices;

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

import moveme.com.br.moveme.configuracaoes.URLWebServices;
import moveme.com.br.moveme.modelos.Passageiro;

//Classe para conectar com o web service
public class HttpServicePassageiro extends AsyncTask<String, Void, Passageiro> {

    private String passageiro;
    private String operacao;

    //Construtor com um parâmetro, que nesse caso é o passageiro a ser inserido
    public HttpServicePassageiro(String passageiro, String operacao) {
        this.passageiro = passageiro;
        this.operacao = operacao;
    }

    public HttpServicePassageiro() {

    }

    @Override
    protected Passageiro doInBackground(String... voids) {
        StringBuilder resposta = new StringBuilder();
        System.out.println("Operação passada por parametro: " + operacao);
        Gson gson = new Gson();

        //Converte o Passageiro passado para Json
        String jsonUsuario = gson.toJson(passageiro);

        Passageiro passageiroRetorno = gson.fromJson(passageiro, Passageiro.class);
        if (operacao.equals("inserir")){
            //Cria o objeto Passageiro recebido no construtor

            //Conexão com o web service
            try {
                //Localização do web service

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/passageiro/inserir");

                //Abre a conexão
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                try {
                    //Defini o verbo HTTP
                    connection.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }

                //Cabeçalhos da requisição
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);

                //Prepara para enviar dados para a requisição
                OutputStream writer = connection.getOutputStream();

                //Envia o Passageiro passado no construtor
                writer.write(passageiro.getBytes());
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
        }
        //Retorno para passageiro retornado pelo web service
        return passageiroRetorno;
    }
}

