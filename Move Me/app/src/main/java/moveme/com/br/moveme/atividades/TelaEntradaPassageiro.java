package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import moveme.com.br.moveme.R;

public class TelaEntradaPassageiro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_entrada_passageiro);
    }

    public void solicitarVeiculo(View v) {
        Intent intent = new Intent(this, EscolherRestaurante.class);
        startActivity(intent);
    }
}
