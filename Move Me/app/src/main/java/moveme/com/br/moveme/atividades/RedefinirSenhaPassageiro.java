package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import moveme.com.br.moveme.R;

public class RedefinirSenhaPassageiro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefinir_senha_passageiro);

        assert getSupportActionBar() != null;   //null check
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    public void buscarEmail(View v){
        Intent intent = new Intent(this, RecuperarSenhaEtapaDois.class);
        startActivity(intent);
    }
}
