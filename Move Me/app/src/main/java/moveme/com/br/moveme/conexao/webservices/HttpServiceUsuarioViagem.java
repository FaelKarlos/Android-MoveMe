package moveme.com.br.moveme.conexao.webservices;

import moveme.com.br.moveme.modelos.UsuarioViagem;
import android.os.AsyncTask;

        import com.google.gson.Gson;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.ProtocolException;
        import java.net.URL;
        import moveme.com.br.moveme.modelos.Veiculo;

public class HttpServiceUsuarioViagem extends AsyncTask<String, Void, UsuarioViagem> {

    private String usuarioViagem;
    private String operacao;

    //Construtor com um parâmetro, que nesse caso é o motorista a ser inserido
    public HttpServiceUsuarioViagem(String usuarioViagem, String operacao) {
        this.usuarioViagem = usuarioViagem;
        this.operacao = operacao;
    }

    public HttpServiceUsuarioViagem() {

    }

    @Override
    protected UsuarioViagem doInBackground(String... voids) {
        StringBuilder resposta = new StringBuilder();
        System.out.println("Operação passada por parametro: " + operacao);
        Gson gson = new Gson();

        //Converte o motorista passado para Json
        String jsonUsuario = gson.toJson(usuarioViagem);

        UsuarioViagem motoristaRetorno = gson.fromJson(usuarioViagem, UsuarioViagem.class);
        if (operacao.equals("inserir")){
            //Cria o objeto motorista recebido no construtor

            //Conexão com o web service
            try {
                //Localização do web service

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/usuarioviagem/inserir");

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

                //Envia o motorista passado no construtor
                writer.write(usuarioViagem.getBytes());
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

        if(operacao.equals("login")){
            //Conexão com o web service
            try {
                //Localização do web service
                String jsonUsuarioLogin = gson.toJson(usuarioViagem);

                UsuarioViagem motoristaLogin = gson.fromJson(usuarioViagem, UsuarioViagem.class);

                System.out.println("Usuario passado: " + motoristaLogin.toString());

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/usuarioviagem/" + motoristaLogin.getUsuarioViagemPK() + "/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                //Prepara para enviar dados para a requisição
                InputStream inputStream = connection.getInputStream();
                if (inputStream == null) {
                    return null;
                }
                //Pega o que foi retornado pelo web service
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String linha;
                StringBuffer buffer = new StringBuffer();
                while((linha = reader.readLine()) != null) {
                    buffer.append(linha);
                }

                String str = buffer.toString();
                //System.out.println("String object do buffer: "+str);
                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();


                //Imprimi a resposta
                //System.out.println("Reposta do servidor na htppService: " + buffer.toString());

                String retornado = gson.toJson(str);

                motoristaRetorno = gson.fromJson(str, UsuarioViagem.class);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(operacao.equals("recuperarSenha")){
            //Conexão com o web service
            try {
                //Localização do web service
                String jsonUsuarioLogin = gson.toJson(usuarioViagem);

                UsuarioViagem passageiroResetaSenha = gson.fromJson(usuarioViagem, UsuarioViagem.class);

                System.out.println("Usuario passado: " + passageiroResetaSenha.toString());

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/usuarioviagem/resuperarsenha/" + passageiroResetaSenha.getUsuarioViagemPK() + "/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                //Prepara para enviar dados para a requisição
                InputStream inputStream = connection.getInputStream();
                if (inputStream == null) {
                    return null;
                }
                //Pega o que foi retornado pelo web service
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String linha;
                StringBuffer buffer = new StringBuffer();
                while((linha = reader.readLine()) != null) {
                    buffer.append(linha);
                }

                String str = buffer.toString();
                //System.out.println("String object do buffer: "+str);
                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();


                //Imprimi a resposta
                //System.out.println("Reposta do servidor na htppService: " + buffer.toString());

                String retornado = gson.toJson(str);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(operacao.equals("apagar")){
            //Conexão com o web service
            try {
                //Localização do web service
                String jsonUsuarioLogin = gson.toJson(usuarioViagem);

                UsuarioViagem motoristaLogin = gson.fromJson(usuarioViagem, UsuarioViagem.class);

                System.out.println("Usuario passado: " + motoristaLogin.toString());

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/usuarioviagem/" + motoristaLogin.getUsuarioViagemPK() + "/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");

                //Prepara para enviar dados para a requisição
                InputStream inputStream = connection.getInputStream();
                if (inputStream == null) {
                    return null;
                }
                //Pega o que foi retornado pelo web service
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String linha;
                StringBuffer buffer = new StringBuffer();
                while((linha = reader.readLine()) != null) {
                    buffer.append(linha);
                }

                String str = buffer.toString();
                //System.out.println("String object do buffer: "+str);
                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();


                //Imprimi a resposta
                //System.out.println("Reposta do servidor na htppService: " + buffer.toString());

                String retornado = gson.toJson(str);

                motoristaRetorno = gson.fromJson(str, UsuarioViagem.class);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(operacao.equals("editar")){
            //Cria o objeto motorista recebido no construtor

            //Conexão com o web service
            try {
                //Localização do web service

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/usuarioviagem/editar");

                //Abre a conexão
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                try {
                    //Defini o verbo HTTP
                    connection.setRequestMethod("PUT");
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

                //Envia o motorista passado no construtor
                writer.write(usuarioViagem.getBytes());
                writer.flush();

                //Pega o que foi retornado pelo web service
                BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

                String retorno;
                //Escreve o retorno em uma variável
                while ((retorno = br.readLine()) != null) {
                    System.out.println("Retorna com alterações: " + retorno);
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


        if(operacao.equals("deletar")){
            //Cria o objeto motorista recebido no construtor

            //Conexão com o web service
            try {
                //Localização do web service

                String jsonUsuarioLogin = gson.toJson(usuarioViagem);

                UsuarioViagem motoristaLogin = gson.fromJson(usuarioViagem, UsuarioViagem.class);

                System.out.println("Usuario passado: " + motoristaLogin.toString());
                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/usuarioviagem/" + motoristaLogin.getUsuarioViagemPK());

                //Abre a conexão
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                try {
                    //Defini o verbo HTTP
                    connection.setRequestMethod("DELETE");
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

                //Envia o motorista passado no construtor
                writer.write(usuarioViagem.getBytes());
                writer.flush();

                //Pega o que foi retornado pelo web service
                BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

                String retorno;
                //Escreve o retorno em uma variável
                while ((retorno = br.readLine()) != null) {
                    System.out.println("Retorna com alterações: " + retorno);
                }

                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();

                //Imprimi a resposta
                System.out.println("sE NAO TVER NADA PAGOU: " + resposta.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Retorno para motorista retornado pelo web service
        return motoristaRetorno;
    }
}
