package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.modelos.Motorista;
import moveme.com.br.moveme.modelos.Passageiro;

public class TelaEntradaMotorista extends AppCompatActivity {
    private Motorista motoristaBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_entrada_motorista);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        motoristaBundle = (Motorista) intent.getSerializableExtra("DADOS_USUARIO");
        //
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
