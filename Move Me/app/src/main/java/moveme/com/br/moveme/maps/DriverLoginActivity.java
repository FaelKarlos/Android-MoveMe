package moveme.com.br.moveme.maps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import moveme.com.br.moveme.R;
import moveme.com.br.moveme.atividades.CadastroMotorista;
import moveme.com.br.moveme.atividades.CadastroPassageiro;
import moveme.com.br.moveme.atividades.EscolherRestaurante;
import moveme.com.br.moveme.atividades.RedefinirSenha;

public class DriverLoginActivity extends AppCompatActivity {
    private EditText mEmail, mPassword;
    private Button mLogin;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar_motorista);

        mAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(DriverLoginActivity.this, DriverMapActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        mEmail = (EditText) findViewById(R.id.edtMotorista);
        mPassword = (EditText) findViewById(R.id.edtSenhaMotorista);

        mLogin = (Button) findViewById(R.id.btnEntrarMotorista);


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(DriverLoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(DriverLoginActivity.this, "Erro no Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
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
        Intent cadastrar = new Intent(this, CadastroMotorista.class);
        startActivity(cadastrar);
    }
    public void recuperarSenha(View v){
        Intent recuperaSenha = new Intent(this, RedefinirSenha.class);
        startActivity(recuperaSenha);
    }
}
