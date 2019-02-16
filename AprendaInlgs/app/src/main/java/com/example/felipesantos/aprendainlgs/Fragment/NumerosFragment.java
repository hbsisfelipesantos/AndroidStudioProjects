package com.example.felipesantos.aprendainlgs.Fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.felipesantos.aprendainlgs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageView imageOne, imageTwo, imageThree, imagefour, imageFive, imageSix;

    private MediaPlayer mediaPlayer;


    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        Cria uma variavel View que pode acessar os elementos do fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

//        Recupera as Views da fragment
        imageOne = view.findViewById(R.id.imageOne);
        imageTwo = view.findViewById(R.id.imageTwo);
        imageThree = view.findViewById(R.id.imageThree);
        imagefour = view.findViewById(R.id.imageFour);
        imageFive = view.findViewById(R.id.imageFive);
        imageSix = view.findViewById(R.id.imageSix);


//        Informa que o evento de click será tratado por metodo
        imageOne.setOnClickListener(this );
        imageThree.setOnClickListener(this );
        imageTwo.setOnClickListener(this );
        imagefour.setOnClickListener(this );
        imageFive.setOnClickListener(this );
        imageSix.setOnClickListener(this );

        return view;


    }


    @Override
    public void onClick(View v) {
//        Switch entre a opção selecionada e executa Som

        switch (v.getId()){
            case R.id.imageOne: if(mediaPlayer != null){mediaPlayer.stop();}  mediaPlayer = MediaPlayer.create(getActivity(),R.raw.one); tocarSom(); break;
            case R.id.imageTwo: if(mediaPlayer != null){mediaPlayer.stop();}  mediaPlayer = MediaPlayer.create(getActivity(),R.raw.two); tocarSom(); break;
            case R.id.imageThree: if(mediaPlayer != null){mediaPlayer.stop();}  mediaPlayer = MediaPlayer.create(getActivity(),R.raw.three); tocarSom(); break;
            case R.id.imageFour: if(mediaPlayer != null){mediaPlayer.stop();}  mediaPlayer = MediaPlayer.create(getActivity(),R.raw.four); tocarSom(); break;
            case R.id.imageFive: if(mediaPlayer != null){mediaPlayer.stop();}  mediaPlayer = MediaPlayer.create(getActivity(),R.raw.five); tocarSom(); break;
            case R.id.imageSix: if(mediaPlayer != null){mediaPlayer.stop();}  mediaPlayer = MediaPlayer.create(getActivity(),R.raw.six); tocarSom(); break;
        }

    }

//    metodo para tocar som e limpar dados em seguida
    public void tocarSom(){
        if (mediaPlayer != null){
            mediaPlayer.start();

            new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            };

        }
    }


}

