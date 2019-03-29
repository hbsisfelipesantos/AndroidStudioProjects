package com.example.whatsappclone.activity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText campoEmail, campoSenha;
    private Usuario usuario;

    private FirebaseAuth firebaseAuth = ConfiguracaoFirebase.getFirebaseAuth();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.textEmail);
        campoSenha = findViewById(R.id.textSenha);

    }


    public void abrirTelaCadastro(View view) {
        Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);

        startActivity(intent);
    }
    public void abrirTelaPrincipal() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);

        startActivity(intent);
    }

    public void logarUsuario(Usuario usuario){
        firebaseAuth.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(), "Usuário autenticado com sucesso", Toast.LENGTH_SHORT).show();

                    abrirTelaPrincipal();

                } else {
                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Este usuário não existe";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Este usuário ou senha não existem";
                    } catch (Exception e) {
                        excecao = "Erro ao cadsatrar usuário";
                        e.printStackTrace();
                    }
                }
            }

        });
    }

    public void validarAutenticacaoUsuario(View view) {

        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        if (!email.isEmpty()) {
            if (!senha.isEmpty()) {

                usuario = new Usuario();

                usuario.setEmail(email);
                usuario.setSenha(senha);

                logarUsuario(usuario);

                } else{
                    Toast.makeText(getApplicationContext(), "Preencha a senha ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Preencha o email", Toast.LENGTH_SHORT).show();
            }
        }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usuarioLogado = firebaseAuth.getCurrentUser();
        if (usuarioLogado != null){
            abrirTelaPrincipal();
        }
    }
}
