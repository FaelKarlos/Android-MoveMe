package experimentos.br.com.wspredicao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DadosRetornados extends AppCompatActivity {

    private Restaurante restaurante;
    private TextView nome, cidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_retornados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nome = (TextView) findViewById(R.id.txtNome);
        cidade = (TextView) findViewById(R.id.txtCidade);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        restaurante = (Restaurante) intent.getSerializableExtra("DADOS_RESTAURANTE");

        System.out.println("Dados restaurante: " + restaurante.toString());

        int totalBlocosBundle = bundle.getInt("totalBlocos");
        int amostrasPorBlocosBundle = bundle.getInt("amostrasPorBlocos");

        nome.setText(restaurante.getNome());
        cidade.setText(restaurante.getCidade());
    }

}
