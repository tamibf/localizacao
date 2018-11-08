package com.example.tamires.localizacao.Data.webservice.mensagens;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import com.example.tamires.localizacao.R;

public class InfMensagem extends DialogFragment {

    public static final String TITULO = "com.example.tamires.localizacao.data.webservice.infmensagem.titulo";
    public static final String MENSAGEM = "com.example.tamires.localizacao.data.webservice.popularmensagem.mensagem";

    public InfMensagem() {
    }

    //visualiza mensagem
    public static void VisualizarMensagem (AppCompatActivity activity, String titulo, String mensagem){
        InfMensagem infMensagem = new InfMensagem();
        Bundle arguments = new Bundle();
        arguments.putString(TITULO, titulo);
        arguments.putString(MENSAGEM, mensagem);
        infMensagem.setArguments(arguments);
        infMensagem.show(activity.getSupportFragmentManager(), InfMensagem.class.toString());

    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@NonNull Bundle savedInstanceState){
        getArguments().getString(TITULO);
        getArguments().getString(MENSAGEM);
        AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
        builder.setTitle(getArguments().getString(TITULO));
        builder.setMessage(getArguments().getString(MENSAGEM));
        builder.setPositiveButton(R.string.OK, null);
        return builder.create();
    }
}