package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.conexao.webservices.HttpServicePassageiro;
import moveme.com.br.moveme.modelos.Passageiro;

public class EditarContaPassageiro extends AppCompatActivity {

    private Passageiro passageiroBundle;

    private EditText nome, cpf, telefone, email, senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_conta_passagiro);

        nome = (EditText) findViewById(R.id.edtNome);
        cpf = (EditText) findViewById(R.id.edtCPF);
        email = (EditText) findViewById(R.id.edtEmail);
        telefone = (EditText) findViewById(R.id.edtTelefone);
        senha = (EditText) findViewById(R.id.edtSenha);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        passageiroBundle = (Passageiro) intent.getSerializableExtra("DADOS_USUARIO");

        nome.setText(passageiroBundle.getNome());
        cpf.setText(passageiroBundle.getCpf());
        email.setText(passageiroBundle.getEmail());
        telefone.setText(passageiroBundle.getTelefone());
        senha.setText(passageiroBundle.getSenha());
    }

    public void alterarConta(View v){
        String nomePassageiro = nome.getText().toString();
        String cpfPassageiro = cpf.getText().toString();
        String telefonePassageiro = telefone.getText().toString();
        String emailPassageiro = email.getText().toString();
        String senhaPassageiro = senha.getText().toString();

        //Cria um objeto passageiro
        Passageiro passageiro = new Passageiro();
        passageiro.setNome(nomePassageiro);
        passageiro.setCpf(cpfPassageiro);
        passageiro.setEmail(emailPassageiro);
        passageiro.setTelefone(telefonePassageiro);
        passageiro.setSenha(senhaPassageiro);

        //Converte o objeto Passageiro para Json
        Gson gson = new Gson();
        String jsonUsuario = gson.toJson(passageiro);

        String r = "";
        String operacao = "editar";

        try {
            //Conecta com web service e passa o Json para ser tratado
            //HttpServicePassageiro - classe que cria um thread para acessar o web service
            Passageiro retorno = new HttpServicePassageiro(jsonUsuario, operacao).execute().get();
            r = retorno.toString();

            //Imprimi o saída do web service
            System.out.println("Objeto retornado pelo web service: " + r.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
