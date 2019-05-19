package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import moveme.com.br.moveme.R;

public class EntrarPassageiro extends AppCompatActivity {

    private Button btnAcessar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar_passageiro);

        btnAcessar = (Button) findViewById(R.id.btnEntrarUsuario);
    }

    public void entrar(View v){
        int id = v.getId();

        if (id == R.id.btnEntrarUsuario){
            Intent it = new Intent(this, TelaEntradaPassageiro.class);
            startActivity(it);
        } else if(id == R.id.txtCadastre_se){
            Intent it = new Intent(this, CadastroPassageiro.class);
            startActivity(it);
        } else if(id == R.id.txtIrRedefinirSenhaPassageiro){
            Intent it = new Intent(this, RedefinirSenhaPassageiro.class);
            startActivity(it);
        }
    }
}
