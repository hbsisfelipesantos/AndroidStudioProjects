package com.example.felipesantos.atmconsultoria.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.felipesantos.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sobre);
String descricao = "texto descrição texto descrição texto descrição texto descrição texto descrição" +
        "texto descrição texto descrição texto descrição texto descriçãotexto descrição";
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .addGroup("Fale conosco")
                .setDescription(descricao)
                .addGroup("Fale conosco")
                .addEmail("atmconsultoria@gmail.com")
                .addWebsite("http://google.com.br")
                .addGroup("Redes Sociais")
                .addFacebook("goolge", "Facebook")
                .addTwitter("gooble","Twitter")
                .addYoutube("google", "Youtube")
                .addInstagram("google", "Intagram")
                .create();

        setContentView( sobre);
    }
}
