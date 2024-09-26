package com.example.goalalerts;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.goalalerts.BaseDatos.*;

public class RegisterActivity extends AppCompatActivity {
    private EditText editUsername, editPassword;
    private Button btnRegister;
    private DbHelper dbHelper;  // Instancia de la clase DbHelper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializamos DbHelper
        dbHelper = new DbHelper(this);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {
            String username = editUsername.getText().toString();
            String password = editPassword.getText().toString();

            if (!username.isEmpty() && !password.isEmpty()) {
                // Verificar si el usuario ya existe en la base de datos
                if (!dbHelper.nombreExiste(username)) {
                    // Agregar el nuevo usuario a la base de datos
                    boolean success = dbHelper.registrarUsuario(username, password);
                    if (success) {
                        showConfirmationDialog();  // Muestra el diálogo de confirmación
                    } else {
                        Toast.makeText(RegisterActivity.this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(RegisterActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showConfirmationDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirmation_layout);
        dialog.show();

        new android.os.Handler().postDelayed(
                () -> dialog.dismiss(), 2000);  // Cierra el diálogo después de 2 segundos
    }
}
