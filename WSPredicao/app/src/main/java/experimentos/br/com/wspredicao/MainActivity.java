package experimentos.br.com.wspredicao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private EditText edtVotos, edtClassifica, edtTaxa, edtAlcance, edtcozinha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtVotos = (EditText) findViewById(R.id.edtVotos);
        edtClassifica = (EditText) findViewById(R.id.edtClassifi_agregada);
        edtTaxa = (EditText) findViewById(R.id.edtTaxaVotos);
        edtAlcance = (EditText) findViewById(R.id.edtAlcance);
        edtcozinha = (EditText) findViewById(R.id.edtCozinha);
    }

    public void realizaPredicao(View v){

        String votos = edtVotos.getText().toString();
        String classi = edtClassifica.getText().toString();
        String taxavotos = edtTaxa.getText().toString();
        String alcance = edtAlcance.getText().toString();
        String cozinha = edtcozinha.getText().toString();

        //Cria um objeto passageiro
        Escolha passageiro = new Escolha();
        passageiro.setAlcance_preco(Integer.parseInt(alcance));
        passageiro.setClassifi_agregada(Integer.parseInt(classi));
        passageiro.setCozinha(cozinha);
        passageiro.setTaxa_votos(taxavotos);
        passageiro.setVotos(Integer.parseInt(votos));

        Gson gson = new Gson();
        String jsonEscolha = gson.toJson(passageiro);

        try {
            Restaurante retorno = new HttpServiceRestaurante(jsonEscolha).execute().get();

            if (retorno != null){
                Intent it = new Intent(this, DadosRetornados.class);

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
}
