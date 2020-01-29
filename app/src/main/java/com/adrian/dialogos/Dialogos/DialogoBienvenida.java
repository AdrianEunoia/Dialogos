package com.adrian.dialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoBienvenida extends DialogFragment {
    // Elementos, Listener dialogo
    OnDialogoBienvenida listener;
    // Metodos dialogo
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnDialogoBienvenida) context;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    // Metodos contructor dialogo
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Diálogo 1");
        dialogo.setMessage("Bienvenido al examen. ¿Estás seguro de continuar?");
        dialogo.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoSelected("si");
                DialogoNombre dialogoNombre = new DialogoNombre();
                dialogoNombre.show(getFragmentManager(),"nombre");
            }
        });
        dialogo.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoSelected("no");
                dismiss();
            }
        });
        return dialogo.create();
    }
    // Interface dialogo
    public interface OnDialogoBienvenida{
        void onDialogoSelected(String s);
    }

}
