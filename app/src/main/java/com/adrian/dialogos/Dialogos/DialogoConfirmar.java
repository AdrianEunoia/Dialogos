package com.adrian.dialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoConfirmar extends DialogFragment {
    // Elementos
    public String nombreRecuperado;
    static final String TAG_ARG1 = "nombrePasado";
    // Metodo para recuperar datos
    public static DialogoConfirmar newInstance(String nombre){
        DialogoConfirmar dialogoConfirmar = new DialogoConfirmar();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ARG1,nombre);
        dialogoConfirmar.setArguments(bundle);
        return dialogoConfirmar;
    }
    // Recuperar contexto, argumento pasado en el dialogo anterior
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        nombreRecuperado = this.getArguments().getString(TAG_ARG1);
    }
    // Metodo constructor dialogo
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Diálogo 3");
        dialogo.setMessage("Perfecto, "+nombreRecuperado+" ahora tendrás que introducir una fecha y una hora, ¿Ok?");
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
        dialogo.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(getFragmentManager(),"fecha");
            }
        });
        return dialogo.create();
    }
}
