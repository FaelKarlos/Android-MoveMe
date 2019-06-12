package moveme.com.br.moveme.atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import moveme.com.br.moveme.R;

public class EscolherRestaurante extends AppCompatActivity {

    private Spinner spCozinha;
    private Spinner spAvaliacao;
    private Spinner spVotos;
    private Spinner spPreco;
    private Spinner spTaxa;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_restaurante);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spCozinha = (Spinner)findViewById(R.id.sp_cozinha);
        spAvaliacao = (Spinner)findViewById(R.id.sp_avaliacao);
        spVotos = (Spinner)findViewById(R.id.sp_votos);
        spPreco = (Spinner)findViewById(R.id.sp_faixaPreco);
        spTaxa = (Spinner)findViewById(R.id.sp_taxa);
        btnBuscar = (Button)findViewById(R.id.btn_buscar);

        //cozinhas
        ArrayAdapter adapter = ArrayAdapter.createFromResource(EscolherRestaurante.this, R.array.cozinhas,
                android.R.layout.simple_spinner_item);
        spCozinha.setAdapter(adapter);
        //votos
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(EscolherRestaurante.this, R.array.votos,
                android.R.layout.simple_spinner_item);
        spVotos.setAdapter(adapter1);
        //avaliacao
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(EscolherRestaurante.this, R.array.avaliacao,
                android.R.layout.simple_spinner_item);
        spAvaliacao.setAdapter(adapter2);
        //preço
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(EscolherRestaurante.this, R.array.precoTaxa,
                android.R.layout.simple_spinner_item);
        spPreco.setAdapter(adapter3);
        //taxa
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(EscolherRestaurante.this, R.array.precoTaxa,
                android.R.layout.simple_spinner_item);
        spTaxa.setAdapter(adapter4);


        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cozinha
                String cozinha = spCozinha.getSelectedItem().toString();

                //Votos
                String votos = spVotos.getSelectedItem().toString();

                //Avaliação

                String avaliacao = spAvaliacao.getSelectedItem().toString();

                //Faixa de Preço
                String preco = spPreco.getSelectedItem().toString();

                //Taxa
                String taxa = spTaxa.getSelectedItem().toString();
                System.out.println("valores:"+"\n"+cozinha+"\n"+votos+"\n"+avaliacao+"\n"+preco+"\n"+taxa);

                /*Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle paramer = new Bundle();
                paramer.putString("chave_cozinha",cozinha);
                paramer.putString("chave_votos",votos);
                paramer.putString("chave_avaliacao",avaliacao);
                paramer.putString("chave_preco",preco);
                paramer.putString("chave_taxa",taxa);
                intent.putExtras(paramer);
                startActivity(intent);*/


            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    public void solicitarRestaurante(View v){
        Toast.makeText(this, "Viagem iniciada", Toast.LENGTH_LONG).show();
    }
}
