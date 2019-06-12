package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.conexao.webservices.HttpServiceRestaurante;
import moveme.com.br.moveme.maps.CustomerMapActivity;
import moveme.com.br.moveme.modelos.Escolha;
import moveme.com.br.moveme.modelos.Restaurante;

public class EscolherRestaurante extends AppCompatActivity {

    private EditText edt1, edt2, edt3, edt4, edt5;

    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_restaurante);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edt1 = (EditText) findViewById(R.id.edtTaxaVoto);
        edt2 = (EditText) findViewById(R.id.edtMediaPreco);
        edt3 = (EditText)findViewById(R.id.edtalcancePreco);
        edt4 = (EditText)findViewById(R.id.edtclassificacaoAgregada);
        edt5 = (EditText)findViewById(R.id.edtVotos);
        btnBuscar = (Button)findViewById(R.id.btn_buscar);


    }

    public void clkas(View v){
        if (!validateForm()) {
            return;
        }
        String taxaVotos = edt1.getText().toString();
        String mediaPreco = edt2.getText().toString();
        String alcancePreco = edt3.getText().toString();
        String classifi = edt4.getText().toString();
        String votos = edt5.getText().toString();

        //Cria um objeto escolha
        Escolha escolha = new Escolha();
        escolha.setTaxaVotos(taxaVotos);
        escolha.setMediaPreco(Integer.parseInt(mediaPreco));
        escolha.setAlcancePreco(Integer.parseInt(alcancePreco));
        escolha.setClassificacaoAgregada(Double.parseDouble(classifi));
        escolha.setVotos(Integer.parseInt(votos));




        Gson gson = new Gson();
        String jsonEscolha = gson.toJson(escolha);

        try {
            Restaurante retorno = new HttpServiceRestaurante(jsonEscolha).execute().get();

            if (retorno != null){
                Intent it = new Intent(this, CustomerMapActivity.class);

                Bundle bundle = new Bundle();
                //Adicionando o objeto Experimento ao bundle
                it.putExtra("DADOS_RESTAURANTE", retorno);

                startActivity(it);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    public void solicitarRestaurante(View v){
        Toast.makeText(this, "Viagem iniciada", Toast.LENGTH_LONG).show();
    }
    private boolean validateForm() {
        boolean valid = true;

        String taxaVotos = edt1.getText().toString();
        if (TextUtils.isEmpty(taxaVotos)) {
            edt1.setError("O campo de taxa de votos está vazio!");
            valid = false;
        } else {
            edt1.setError(null);
        }

        String mediaPreco = edt2.getText().toString();
        if (TextUtils.isEmpty(mediaPreco)) {
            edt2.setError("O campo de senha está vazio!");
            valid = false;
        }
        else {
            edt2.setError(null);
        }
        String alcancePreco = edt3.getText().toString();
        if (TextUtils.isEmpty(alcancePreco)) {
            edt3.setError("O campo de alcançe de preço está vazio!");
            valid = false;
        }
        else {
            edt3.setError(null);
        }
        String classificacao = edt4.getText().toString();
        if (TextUtils.isEmpty(classificacao)) {
            edt4.setError("O campo de classificação está vazio!");
            valid = false;
        }
        else {
            edt4.setError(null);
        }
        String votos = edt5.getText().toString();
        if (TextUtils.isEmpty(votos)) {
            edt5.setError("O campo de classificação está vazio!");
            valid = false;
        }
        else {
            edt5.setError(null);
        }

        return valid;
    }
}
