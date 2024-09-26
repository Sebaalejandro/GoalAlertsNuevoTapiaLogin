package com.example.goalalerts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.goalalerts.BaseDatos.*;

public class LoginActivity extends AppCompatActivity {
    private EditText editUsername, editPassword;
    private Button btnLogin, btnRegister;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializa la base de datos
        dbHelper = new DbHelper(this);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(v -> {
            String username = editUsername.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            // Verifica si los campos están vacíos
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Verifica si el usuario y la contraseña son correctos
            if (dbHelper.validarUsuario(username, password)) {
                // Si el usuario es válido, redirigir a la siguiente actividad
                Intent intent = new Intent(LoginActivity.this, VentanaInicio.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        dbHelper.close(); // Cierra la base de datos al destruir la actividad
        super.onDestroy();
    }
}
