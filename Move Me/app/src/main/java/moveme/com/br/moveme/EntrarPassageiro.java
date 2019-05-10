package moveme.com.br.moveme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
            Intent it = new Intent(this, TelaEntradaUsuario.class);
            startActivity(it);
        }
    }
}
