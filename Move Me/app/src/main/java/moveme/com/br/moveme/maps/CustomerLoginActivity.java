package moveme.com.br.moveme.maps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

import java.util.concurrent.ExecutionException;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.atividades.CadastroPassageiro;
import moveme.com.br.moveme.atividades.RedefinirSenhaPassageiro;

public class CustomerLoginActivity extends AppCompatActivity {

    public EditText mEmail, mPassword;
    public Button mLogin;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar_passageiro);


        usuario = (EditText) findViewById(R.id.edtUsuarioMotorista);
        senha = (EditText) findViewById(R.id.edtSenhaPassageiro);

        btnAcessar = (Button) findViewById(R.id.btnEntrarUsuario);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(CustomerLoginActivity.this, CustomerMapActivity.class);
                    //
                    startActivity(intent);
                    finish();
                }else{
                    System.out.println("Erro da disgraça.");
                }
            }
        };
    }

        mEmail = (EditText) findViewById(R.id.edtPassageiro);
        mPassword = (EditText) findViewById(R.id.edtSenhaPassageiro);

        mLogin = findViewById(R.id.btnEntrarUsuario);
        /*
        mRegistration = (Button) findViewById(R.id.registration);


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
                    if (retorno != null) {

                        Toast.makeText(this, "Logado com sucesso!!!", Toast.LENGTH_SHORT).show();

                        Intent it = new Intent(this, TelaEntradaPassageiro.class);

                        //Adicionando o objeto Experimento ao bundle
                        it.putExtra("DADOS_USUARIO", retorno);

                        it.putExtra("USUARIO", retorno.getNome());
                        startActivity(it);
                    } else {
                        Toast.makeText(this, "Usuário não encontrado!!!", Toast.LENGTH_LONG).show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }




        } else if (id == R.id.txtCadastre_se) {
            Intent it = new Intent(this, CadastroPassageiro.class);
            startActivity(it);
        } else if (id == R.id.txtIrRedefinirSenhaMotorista) {
            Intent it = new Intent(this, RedefinirSenhaPassageiro.class);
            startActivity(it);
        }
    }














/*





            //Registrar
            @Override
            public void onClick(View v) {
                final String email = usuario.getText().toString();
                final String password = senha.getText().toString();
                if (!validateForm()) {
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(CustomerLoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(CustomerLoginActivity.this, "sign up error", Toast.LENGTH_SHORT).show();
                        }else{
                            String user_id = mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(user_id);
                            current_user_db.setValue(true);
                        }
                    }
                });
            }




        });
*/


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateForm()) {
                    return;
                }
                final String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString();
                System.out.println("EMAIL: " + email + "PASSWORD: " + password);
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(CustomerLoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(CustomerLoginActivity.this, "sign in error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    
    private boolean validateForm() {
        boolean valid = true;

        String email = usuario.getText().toString();
        if (TextUtils.isEmpty(email)) {
            usuario.setError("O campo de email está vazio!");
            valid = false;
        } else {
            usuario.setError(null);
        }

        String password = senha.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPassword.setError("O campo de senha está vazio!");
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

    public void cadastrar(View v){
        Intent cadastrar = new Intent(this, CadastroPassageiro.class);
        startActivity(cadastrar);
    }
    public void recuperarSenha(View v){
        Intent recuperaSenha = new Intent(this, RedefinirSenhaPassageiro.class);
        startActivity(recuperaSenha);
    }
}
