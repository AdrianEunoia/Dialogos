package com.adrian.dialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.adrian.dialogos.R;

public class DialogoNota extends DialogFragment {
    // Elementos
    onDialogoNota listener;
    EditText idEditNota;
    View view;
    // Metodo dialogo
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_nota,null);
        instancias();
        listener = (onDialogoNota) getContext();
    }
    // Instancias
    private void instancias() {
        idEditNota = view.findViewById(R.id.idEditNota);
    }
    // Metodo constructor dialogo
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Diálogo 6");
        dialogo.setMessage("Introduce la nota que consideras que vas a sacar en el examen:");
        dialogo.setView(view);
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
        dialogo.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoNota(idEditNota.getText().toString());
            }
        });
        return dialogo.create();
    }
    // Interface dialogo
    public interface onDialogoNota{
        void onDialogoNota(String nota);
    }
}
