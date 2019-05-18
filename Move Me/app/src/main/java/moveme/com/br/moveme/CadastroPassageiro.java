package moveme.com.br.moveme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class CadastroPassageiro extends AppCompatActivity {

    private EditText nome, sobrenome, cpf, email, telefone, senha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_passageiro);

        nome = (EditText) findViewById(R.id.edtNome);
        sobrenome = (EditText) findViewById(R.id.edtSobrenome);
        cpf = (EditText) findViewById(R.id.edtCPF);
        email = (EditText) findViewById(R.id.edtEmail);
        telefone = (EditText) findViewById(R.id.edtTelefone);
        senha = (EditText) findViewById(R.id.edtSenha);
    }

    public void cadastrarPassgairo(View v){
        String nomePassageiro = nome.getText().toString();
        String sobrenomePassageiro = sobrenome.getText().toString();
        String cpfPassageiro = cpf.getText().toString();
        String telefonePassageiro = telefone.getText().toString();
        String emailPassageiro = email.getText().toString();
        String senhaPassageiro = senha.getText().toString();

        Toast.makeText(this,"Dados do passageiro: "
                + nomePassageiro + ";" + sobrenomePassageiro + ";" + cpfPassageiro + ";" + telefonePassageiro + ";" + emailPassageiro + ";" + senhaPassageiro + ";",
                Toast.LENGTH_SHORT).show();

        Passageiro passageiro = new Passageiro();
        passageiro.setNome(nomePassageiro);
        passageiro.setSobrenome(sobrenomePassageiro);
        passageiro.setCpf(cpfPassageiro);
        passageiro.setEmail(emailPassageiro);
        passageiro.setTelefone(telefonePassageiro);
        passageiro.setSenha(senhaPassageiro);


        System.out.println("Agora a String json");

        Gson gson = new Gson();
        String jsonUsuario = gson.toJson(passageiro);

        System.out.println(jsonUsuario);

        System.out.println("Agora a de json para passageiro");
        Gson gson1 = new Gson();
        JSONObject object = null;
        try {
            object = new JSONObject(jsonUsuario);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("json objeto: " + object.toString());
    }
}
