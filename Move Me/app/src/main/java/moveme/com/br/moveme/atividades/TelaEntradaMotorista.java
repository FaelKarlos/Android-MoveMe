package moveme.com.br.moveme.atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import moveme.com.br.moveme.R;

public class TelaEntradaMotorista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_entrada_motorista);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
