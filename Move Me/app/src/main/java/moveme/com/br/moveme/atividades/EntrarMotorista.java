package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import moveme.com.br.moveme.R;

public class EntrarMotorista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar_motorista);


        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void entrar(View v){
        int id = v.getId();

        if (id == R.id.btnEntrarMotorista){
            Intent it = new Intent(this, TelaEntradaMotorista.class);
            startActivity(it);
        } else if(id == R.id.txtCadastre_seMotorista){
            Intent it = new Intent(this, CadastroMotorista.class);
            startActivity(it);
        } else if(id == R.id.txtIrRedefinirSenhaMotorista){
            Intent it = new Intent(this, RedefinirSenhaPassageiro.class);
            startActivity(it);
        }
    }
}
