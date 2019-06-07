






































package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.atividades.EntrarPassageiro;

public class RecuperarSenhaEtapaDois extends AppCompatActivity {
    private EditText nome, cpf, telefone, email, senha;
    String emailPassageiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha_etapa_dois);
        nome = (EditText) findViewById(R.id.edtNome);
        email = (EditText) findViewById(R.id.edtEmail);
        senha = (EditText) findViewById(R.id.edtSenha);

        //Pegando email para comparar
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        emailPassageiro = (String) intent.getSerializableExtra("DADOS_USUARIO");

        if(emailPassageiro == )
        {

            nome.setText();
            email.setText();
        }
    }

    public void senhaEnviada(View v){


        Intent intent = new Intent(this, EntrarPassageiro.class);
        startActivity(intent);
    }
}
