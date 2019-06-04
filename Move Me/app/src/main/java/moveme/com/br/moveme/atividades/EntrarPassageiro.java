package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.conexao.webservices.HttpServicePassageiro;
import moveme.com.br.moveme.modelos.Passageiro;

public class EntrarPassageiro extends AppCompatActivity {

    private EditText usuario, senha;
    private Button btnAcessar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar_passageiro);

        usuario = (EditText) findViewById(R.id.edtUsuarioMotorista);
        senha = (EditText) findViewById(R.id.edtSenhaPassageiro);

        btnAcessar = (Button) findViewById(R.id.btnEntrarUsuario);
    }

    public void entrar(View v){
        int id = v.getId();

        if (id == R.id.btnEntrarUsuario){

            //Login usuario
            {
                //Pega os valores dos EditText
                String cpfPassageiro = usuario.getText().toString();
                String senhaPassageiro = senha.getText().toString();

                //Cria um objeto passageiro
                Passageiro passageiro = new Passageiro();
                passageiro.setCpf(cpfPassageiro);
                passageiro.setSenha(senhaPassageiro);

                //Converte o objeto Passageiro para Json
                Gson gson = new Gson();
                String jsonUsuario = gson.toJson(passageiro);

                String r = "";
                String operacao = "login";

                try {
                    //Conecta com web service e passa o Json para ser tratado
                    //HttpServicePassageiro - classe que cria um thread para acessar o web service
                    Passageiro retorno = new HttpServicePassageiro(jsonUsuario, operacao).execute().get();
                    r = retorno.toString();

                    //Imprimi o saída do web service
                    System.out.println("Vai entrar agora: " + r.toString());
                    if (retorno != null){

                        Toast.makeText(this, "Logado com sucesso!!!", Toast.LENGTH_SHORT).show();

                        Intent it = new Intent(this, TelaEntradaPassageiro.class);

                        it.putExtra("USUARIO", retorno.getNome());
                        startActivity(it);
                    } else{
                        Toast.makeText(this, "Usuário não encontrado!!!", Toast.LENGTH_LONG).show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }


        } else if(id == R.id.txtCadastre_se){
            Intent it = new Intent(this, CadastroPassageiro.class);
            startActivity(it);
        } else if(id == R.id.txtIrRedefinirSenhaMotorista){
            Intent it = new Intent(this, RedefinirSenhaPassageiro.class);
            startActivity(it);
        }
    }
}
