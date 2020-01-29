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

public class DialogoNombre extends DialogFragment {
    // Elementos
    EditText idEditNombre;
    View view;
    // Instancias
    private void instancias() {
            idEditNombre = view.findViewById(R.id.idEditNombre);
    }
    // Metodo dialogo
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_nombre,null);
        instancias();
    }
    // Metodo constructor dialogo
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());

        dialogo.setTitle("Diálogo 2");
        dialogo.setMessage("Introduce tu nombre");
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
                String nombre = idEditNombre.getText().toString();
                DialogoConfirmar dialogoRecuperar =  DialogoConfirmar.newInstance(nombre);
                dialogoRecuperar.show(getFragmentManager(),"recuperar");
            }
        });
        return dialogo.create();
    }
}
