package com.example.goalalerts;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    /*
    private RecyclerView recyclerView;
    private FloatingActionButton fabRefresh;
    private LiveMatchesAdapter adapter;  // Adapter para mostrar los partidos
    private FootballAPI footballAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos el RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));  // Configura un LinearLayoutManager

        // Inicializamos Retrofit y la API
        footballAPI = RetrofitClient.getClient().create(FootballAPI.class);

        // Inicializamos el Adapter vacío
        adapter = new LiveMatchesAdapter();
        recyclerView.setAdapter(adapter);  // Establecemos el Adapter en el RecyclerView

        // Configuramos el Floating Action Button para actualizar la lista de partidos
        fabRefresh = findViewById(R.id.fabRefresh);
        fabRefresh.setOnClickListener(v -> refrescarPartidos());  // Llama al método para refrescar los partidos

        // Cargamos los partidos en vivo al inicio
        cargarPartidos();
    }

    // Método para cargar los partidos en vivo desde la API
    private void cargarPartidos() {
        footballAPI.getLiveMatches("true").enqueue(new Callback<LiveMatchesResponse>() {
            @Override
            public void onResponse(Call<LiveMatchesResponse> call, Response<LiveMatchesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<LiveMatchesResponse.Match> matches = response.body().getMatches();
                    adapter.updateMatches(matches);  // Actualizamos el RecyclerView con los nuevos partidos
                    Toast.makeText(MainActivity.this, "Partidos cargados", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "No se encontraron partidos en vivo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LiveMatchesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error al cargar los partidos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método para refrescar la lista de partidos cuando se presiona el FAB
    private void refrescarPartidos() {
        cargarPartidos();  // Volvemos a cargar los partidos
    }*/
}
