

package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.conexao.webservices.HttpServicePassageiro;
import moveme.com.br.moveme.modelos.Passageiro;

public class RecuperarSenhaEtapaDois extends AppCompatActivity {
    private EditText nome, email, senha;
    private Passageiro passageiroBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha_etapa_dois);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nome = (EditText) findViewById(R.id.edtNome);
        email = (EditText) findViewById(R.id.edtEmail);
        senha = (EditText) findViewById(R.id.edtSenha);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        passageiroBundle = (Passageiro) intent.getSerializableExtra("DADOS_USUARIO");


        nome.setText(passageiroBundle.getNome());
        email.setText(passageiroBundle.getEmail());

    }



    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    public void senhaEnviada(View v){

        Intent intent = new Intent(this, EntrarPassageiro.class);

        //Cria um objeto passageiro
        passageiroBundle.setSenha(senha.getText().toString());

        //Converte o objeto Passageiro para Json
        Gson gson = new Gson();
        String jsonUsuario = gson.toJson(passageiroBundle);

        String r = "";
        String operacao = "editar";

        try {
            //Conecta com web service e passa o Json para ser tratado
            //HttpServicePassageiro - classe que cria um thread para acessar o web service
            Passageiro retorno = new HttpServicePassageiro(jsonUsuario, operacao).execute().get();
            r = retorno.toString();

            //Imprimi o saída do web service
            System.out.println("Objeto retornado pelo web service: " + r.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        startActivity(intent);
    }
}
