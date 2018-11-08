package com.example.tamires.localizacao.Data.webservice.mensagens;

import android.content.Context;
import android.widget.Toast;

public class PopularMensagem {
    public static void VisualizarMensagem(Context context, String mensagem){
        Toast.makeText(context, mensagem, Toast.LENGTH_LONG).show();
    }
}
