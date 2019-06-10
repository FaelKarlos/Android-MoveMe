package moveme.com.br.moveme.atividades;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.conexao.webservices.HttpServiceMotorista;
import moveme.com.br.moveme.conexao.webservices.HttpServicePassageiro;
import moveme.com.br.moveme.maps.CustomerLoginActivity;
import moveme.com.br.moveme.maps.DriverLoginActivity;
import moveme.com.br.moveme.modelos.Motorista;
import moveme.com.br.moveme.modelos.Passageiro;

public class CadastroMotorista extends AppCompatActivity {
    private EditText nome, sobrenome, cpf, email, telefone, senha;
    private Button mRegistration;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_motorista);

        nome = (EditText) findViewById(R.id.edtNome);
        sobrenome = (EditText) findViewById(R.id.edtSobrenome);
        cpf = (EditText) findViewById(R.id.edtCPF);
        email = (EditText) findViewById(R.id.edtEmail);
        telefone = (EditText) findViewById(R.id.edtTelefone);
        senha = (EditText) findViewById(R.id.edtSenha);

        mAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(CadastroMotorista.this, DriverLoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    System.out.println("Erro!");
                }
            }
        };
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRegistration = (Button) findViewById(R.id.btnCadastroMotorista);

        mRegistration.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (!validateForm()) {
                    return;
                }

                //Pega os valores dos EditText
                String nomeMotorista = nome.getText().toString();
                String sobrenomeMotorista = sobrenome.getText().toString();
                String cpfMotorista = cpf.getText().toString();
                String telefoneMotorista = telefone.getText().toString();
                String emailMotorista = email.getText().toString();;
                String senhaMotorista = senha.getText().toString();

                //Cria um objeto motorista
                Motorista motorista = new Motorista();
                motorista.setNome(nomeMotorista + " " + sobrenomeMotorista);
                motorista.setCpf(cpfMotorista);
                motorista.setEmail(emailMotorista);
                motorista.setTelefone(telefoneMotorista);
                motorista.setSenha(senhaMotorista);

                //Converte o objeto Passageiro para Json
                Gson gson = new Gson();
                String jsonUsuario = gson.toJson(motorista);

                String r = "";
                String operacao = "inserir";

                try {
                    //Conecta com web service e passa o Json para ser tratado
                    //HttpServicePassageiro - classe que cria um thread para acessar o web service
                    Motorista retorno = new HttpServiceMotorista(jsonUsuario, operacao).execute().get();
                    r = retorno.toString();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }


                mAuth.createUserWithEmailAndPassword(emailMotorista, senhaMotorista).addOnCompleteListener(CadastroMotorista.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(CadastroMotorista.this, "Erro de Login", Toast.LENGTH_SHORT).show();
                        } else {
                            String user_id = mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(user_id);
                            Toast.makeText(CadastroMotorista.this, "Cadastro efetuado com sucesso (FIREBASE)!", Toast.LENGTH_SHORT).show();
                            current_user_db.setValue(true);
                            Toast.makeText(CadastroMotorista.this, "Erro de Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private boolean validateForm() {
        boolean valid = true;

        String mail = email.getText().toString();
        if (TextUtils.isEmpty(mail)) {
            email.setError("O campo de email está vazio!");
            valid = false;
        } else {
            email.setError(null);
        }

        String password = senha.getText().toString();
        if (TextUtils.isEmpty(password)) {
            senha.setError("O campo de senha está vazio!");
            valid = false;
        } else {
            senha.setError(null);
        }

        return valid;
    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }
    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);
    }
}
