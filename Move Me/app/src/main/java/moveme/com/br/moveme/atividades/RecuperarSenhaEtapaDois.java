






































package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.atividades.EntrarPassageiro;

public class RecuperarSenhaEtapaDois extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha_etapa_dois);
    }

    public void senhaEnviada(View v){
        Intent intent = new Intent(this, EntrarPassageiro.class);
        startActivity(intent);
    }
}
