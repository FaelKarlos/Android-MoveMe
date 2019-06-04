package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import moveme.com.br.moveme.R;

public class TelaEntradaPassageiro extends AppCompatActivity {

    private TextView usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_entrada_passageiro);

        usuario = (TextView) findViewById(R.id.txtUsuario);

        Bundle extras = getIntent().getExtras();

        String nomeUsuario = extras.getString("USUARIO");

        usuario.setText(nomeUsuario);
    }

    public void solicitarVeiculo(View v) {
        Intent intent = new Intent(this, EscolherRestaurante.class);
        startActivity(intent);
    }
}
