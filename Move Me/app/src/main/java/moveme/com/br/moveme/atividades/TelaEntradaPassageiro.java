package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.conexao.webservices.HttpServicePassageiro;
import moveme.com.br.moveme.modelos.Passageiro;

public class TelaEntradaPassageiro extends AppCompatActivity {

    private Passageiro passageiroBundle;

    private TextView usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_entrada_passageiro);

        usuario = (TextView) findViewById(R.id.txtUsuario);

        //Buscando dados no bundle
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        passageiroBundle = (Passageiro) intent.getSerializableExtra("DADOS_USUARIO");
        //

        usuario.setText(passageiroBundle.getNome());
    }

    public void solicitarVeiculo(View v) {
        Intent intent = new Intent(this, EscolherRestaurante.class);
        startActivity(intent);
    }

    public void opcoes(View v){
        int id = v.getId();

        if (id == R.id.btnEditarPassageiro){
            Intent it = new Intent(this, EditarContaPassageiro.class);

            //Adicionando o objeto Experimento ao bundle
            it.putExtra("DADOS_USUARIO", passageiroBundle);

            startActivity(it);

        } else if(id == R.id.btnApagarConta){
            Gson gson = new Gson();
            String jsonUsuario = gson.toJson(passageiroBundle);

            String r = "";
            String operacao = "deletar";

            try {
                //Conecta com web service e passa o Json para ser tratado
                //HttpServicePassageiro - classe que cria um thread para acessar o web service
                Passageiro retorno = new HttpServicePassageiro(jsonUsuario, operacao).execute().get();
                r = retorno.toString();

                //Imprimi o saída do web service
                if (r == null) {
                    Toast.makeText(this, "Conta apagada com sucesso!!!", Toast.LENGTH_LONG).show();
                    Intent it = new Intent(this, MainActivity.class);
                    startActivity(it);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
