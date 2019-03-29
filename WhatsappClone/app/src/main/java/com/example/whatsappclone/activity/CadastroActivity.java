package com.example.whatsappclone.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.whatsappclone.R;
import com.example.whatsappclone.config.ConfiguracaoFirebase;
import com.example.whatsappclone.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText campoNome, campoEmail, campoSenha;
    private Usuario usuario;


    private FirebaseAuth firebaseAuth = ConfiguracaoFirebase.getFirebaseAuth();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.textNome);
        campoEmail = findViewById(R.id.textEmail);
        campoSenha = findViewById(R.id.textSenha);

    }

    public void cadastrarUsuario(View view) {

        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        if (!nome.isEmpty() ) {
            if (!email.isEmpty()) {
                if (!senha.isEmpty()) {

                        usuario = new Usuario(nome, email, senha);

                        firebaseAuth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {

                                            Toast.makeText(getApplicationContext(), "Usuario cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                                            finish();
                                        } else {
                                            String excecao = "";
                                            try {
                                                throw task.getException();
                                            }catch ( FirebaseAuthWeakPasswordException e){
                                                excecao = "Digite uma senha mais forte";
                                            }catch (FirebaseAuthInvalidCredentialsException e){
                                                excecao = "Por favor, digite um email válido";
                                            }catch (FirebaseAuthUserCollisionException e ){
                                                excecao = "Esta conta já foi cadastrada";
                                            }catch (Exception e){
                                            excecao = "Erro ao cadastrar usuário";
                                            }
                                            // If sign in fails, display a message to the user.
                                            Log.i("Cadastro", excecao, task.getException());
                                            Toast.makeText(getApplicationContext(), excecao,
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                } else {
                    Toast.makeText(getApplicationContext(), "Preencha a senha ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Preencha o email", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_SHORT).show();
        }
    }
}