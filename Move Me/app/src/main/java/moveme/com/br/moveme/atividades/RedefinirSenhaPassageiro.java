package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.conexao.webservices.HttpServicePassageiro;
import moveme.com.br.moveme.modelos.Passageiro;

public class RedefinirSenhaPassageiro extends AppCompatActivity {
    private EditText email;
    private Passageiro passageiroBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefinir_senha_passageiro);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        email = (EditText) findViewById(R.id.edtEmail);
    }




    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    public void buscarEmail(View v) throws ExecutionException, InterruptedException {
        Intent intent = new Intent(this, RecuperarSenhaEtapaDois.class);
        String emailPassageiro = email.getText().toString();

        passageiroBundle.setEmail(emailPassageiro);
        //Converte o objeto Passageiro para Json
        Gson gson = new Gson();
        String jsonUsuario = gson.toJson(passageiroBundle);

        String operacao = "recuperarSenha";
        Passageiro retorno = new HttpServicePassageiro(jsonUsuario, operacao).execute().get();

        intent.putExtra("DADOS_USUARIO", retorno);
        startActivity(intent);
    }
}
