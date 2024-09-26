package com.example.goalalerts;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.goalalerts.BaseDatos.DbHelper;

public class PartidoManagementActivity extends AppCompatActivity {

    private EditText editLocal, editVisitante, editFecha, editHora;
    private Button btnAgregar;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_partido_management);

        // Inicializar los componentes de la interfaz
        editLocal = findViewById(R.id.editLocal);
        editVisitante = findViewById(R.id.editVisitante);
        editFecha = findViewById(R.id.editFecha);
        editHora = findViewById(R.id.editHora);
        btnAgregar = findViewById(R.id.btnAgregar);

        dbHelper = new DbHelper(this);

        // Configurar el botón de agregar partido
        btnAgregar.setOnClickListener(v -> agregarPartido());
    }

    private void agregarPartido() {
        String equipoLocal = editLocal.getText().toString().trim();
        String equipoVisitante = editVisitante.getText().toString().trim();
        String fecha = editFecha.getText().toString().trim();
        String hora = editHora.getText().toString().trim();

        // Verificar que no haya campos vacíos
        if (equipoLocal.isEmpty() || equipoVisitante.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Intentar agregar el partido a la base de datos
        boolean resultado = dbHelper.registrarPartido(equipoLocal, equipoVisitante, fecha, hora);
        if (resultado) {
            Toast.makeText(this, "Partido agregado con éxito", Toast.LENGTH_SHORT).show();
            limpiarCampos(); // Limpia los campos después de agregar
        } else {
            Toast.makeText(this, "Error al agregar el partido", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        editLocal.setText("");
        editVisitante.setText("");
        editFecha.setText("");
        editHora.setText("");
    }
}
