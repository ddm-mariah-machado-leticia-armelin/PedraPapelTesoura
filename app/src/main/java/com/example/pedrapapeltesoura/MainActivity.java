package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int pontosJogador;
    int pontosApp;
    // Atributos relacionados com os objetos gráficos da interface:
    private ImageView imgPedra;
    private ImageView imgPapel;
    private ImageView imgTesoura;
    private ImageView imgApp;
    private TextView lblResultado;
    private TextView lblPontoJogador;
    private TextView lblPontoApp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ligar os atributos com os objetos da interface,
        // procurando pelo ID dos objetos:
        imgPedra = findViewById( R.id.imgPedra );
        imgPapel = findViewById( R.id.imgPapel );
        imgTesoura = findViewById( R.id.imgTesoura );
        imgApp = findViewById( R.id.imgApp );
        lblResultado = findViewById( R.id.lblResultado );
        lblPontoJogador = findViewById( R.id.lblPontoJogador );
        lblPontoApp = findViewById( R.id.lblPontoApp);

        // Criando um objeto escutador de cliques:
        EscutadorClickImagem eci = new EscutadorClickImagem();
        // Associando o objeto criado acima nas imagens:
        imgPedra.setOnClickListener( eci );
        imgPapel.setOnClickListener( eci );
        imgTesoura.setOnClickListener( eci );

    }

    // classe interna para tratar os cliques nas imagens
    private class EscutadorClickImagem implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            // Variável para guardar a escolha do usuário:
            int escolhaUsuario = 0;

            ImageView img = (ImageView) v;
            switch ( img.getId() ) {
                case R.id.imgPedra:
                    escolhaUsuario = 1;
                    break;
                case R.id.imgPapel:
                    escolhaUsuario = 2;
                    break;
                case R.id.imgTesoura:
                    escolhaUsuario = 3;
                    break;
            }

            int escolhaApp = new Random().nextInt(3) + 1;
            // Precisamos colocar a imagem correta que reflete
            // A escolha do App:
            switch ( escolhaApp ) {
                case 1:
                    imgApp.setImageResource(R.drawable.pedra);
                    break;
                case 2:
                    imgApp.setImageResource(R.drawable.papel);
                    break;
                case 3:
                    imgApp.setImageResource(R.drawable.tesoura);
                    break;
            }

            if ( ( escolhaApp == 1 && escolhaUsuario == 3 ) ||
                    ( escolhaApp == 2 && escolhaUsuario == 1 ) ||
                    ( escolhaApp == 3 && escolhaUsuario == 2 ) )
            {
                pontosApp++;
                lblPontoApp.setText(pontosApp);
                lblResultado.setText("O app ganhou!!!!");
            }
            else
            {
                if ( (escolhaApp == 3 && escolhaUsuario == 1) ||
                        (escolhaApp == 1 && escolhaUsuario == 2) ||
                        (escolhaApp == 2 && escolhaUsuario == 3) )
                {
                    pontosJogador++;
                    lblPontoJogador.setText(pontosJogador);
                    lblResultado.setText("Você ganhou!!");
                }
                else
                {
                    lblResultado.setText("Deu empate!");
                }
            }
        }
    }
}



