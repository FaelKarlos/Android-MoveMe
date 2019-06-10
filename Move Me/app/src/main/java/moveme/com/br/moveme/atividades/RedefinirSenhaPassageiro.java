package moveme.com.br.moveme.atividades;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import moveme.com.br.moveme.R;

public class RedefinirSenhaPassageiro extends AppCompatActivity {

    private EditText inputEmail;

    private Button btnReset;

    private FirebaseAuth auth;

    private ProgressBar progressBar;

    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefinir_senha_passageiro);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        inputEmail = (EditText) findViewById(R.id.emailRP);

        btnReset = (Button) findViewById(R.id.btn_reset_password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Entre com seu email cadastrado no aplicativo!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.sendPasswordResetEmail(email)

                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(RedefinirSenhaPassageiro.this, "Nós Enviamos um link para a recuperação de senha pelo email!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RedefinirSenhaPassageiro.this, "Falha ao enviar o email de recuperação de senha!", Toast.LENGTH_SHORT).show();
                                }

                                progressBar.setVisibility(View.GONE);
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
    /*
    public void buscarEmail(View v) throws ExecutionException, InterruptedException {
        Intent intent = new Intent(this, RecuperarSenhaEtapaDois.class);
        String emailPassageiro = email.getText().toString();

        passageiroBundle.setEmail(emailPassageiro);
        //Converte o objeto Passageiro para Json
        Gson gson = new Gson();
        String jsonUsuario = gson.toJson(passageiroBundle);

        String operacao = "recuperarSenha";
        Passageiro retorno = new HttpServicePassageiro(jsonUsuario, operacao).execute().get();

        intent.putExtra("DADOS_USUARIO", retorno);
        startActivity(intent);
    }*/

}
