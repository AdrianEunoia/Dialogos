package com.adrian.dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.adrian.dialogos.Dialogos.DialogoBienvenida;
import com.adrian.dialogos.Dialogos.DialogoHora;
import com.adrian.dialogos.Dialogos.DialogoNota;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener, DialogoBienvenida.OnDialogoBienvenida, DialogoNota.onDialogoNota,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }
    // Elementos
    TextView textNota;
    // Instancias
    private void instancias() {
        textNota = findViewById(R.id.textNota);
    }
    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    // Menu metodo para accion seleccionada
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DialogoBienvenida dialogoBienvenida = new DialogoBienvenida();
        dialogoBienvenida.show(getSupportFragmentManager(), "Inicio");
        return true;
    }
    // Metodo autogenerado al extender la clase del dialogo
    @Override
    public void onDialogoSelected(String s) {

    }
    @Override
    public void onDialogoNota(String nota) {
        textNota.setText(nota);
    }
    // Acciones
    @Override
    public void onClick(View v) { }
    // Acciones DATEPICKER
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        DialogoHora dialogoHora = new DialogoHora();
        dialogoHora.show(getSupportFragmentManager(), "hora");
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        DialogoNota dialogoNota = new DialogoNota();
        dialogoNota.show(getSupportFragmentManager(), "nota");
    }
}
