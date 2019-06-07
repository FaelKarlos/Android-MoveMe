package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.maps.CustomerLoginActivity;
import moveme.com.br.moveme.maps.DriverLoginActivity;

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
            Intent it = new Intent(this, CustomerLoginActivity.class);

            startActivity(it);
        } else{
            Intent it = new Intent(this, DriverLoginActivity.class);

            startActivity(it);
        }
    }
}
