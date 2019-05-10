package moveme.com.br.moveme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnMotorista;
    private Button btnPassageiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMotorista = (Button) findViewById(R.id.btnMotorista);
        btnPassageiro = (Button) findViewById(R.id.btnPassageiro);
    }

    public void entrarOpcao(View v){
        int id = v.getId();

        if (id == R.id.btnPassageiro){
            Intent it = new Intent(this, EntrarPassageiro.class);

            startActivity(it);
        } else{
            Intent it = new Intent(this, EntrarMotorista.class);

            startActivity(it);
        }
    }
}
