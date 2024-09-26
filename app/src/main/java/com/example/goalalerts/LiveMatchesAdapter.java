package com.example.goalalerts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LiveMatchesAdapter extends RecyclerView.Adapter<LiveMatchesAdapter.MatchViewHolder> {

    private List<LiveMatchesResponse.Match> matches = new ArrayList<>();  // Lista para almacenar los partidos

    // Método para actualizar la lista de partidos
    public void updateMatches(List<LiveMatchesResponse.Match> newMatches) {
        this.matches = newMatches;
        notifyDataSetChanged();  // Notifica al adaptador que los datos han cambiado
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el layout de cada item de partido (item_match.xml)
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(itemView);  // Retorna el ViewHolder correspondiente
    }

    @Override

    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        LiveMatchesResponse.Match match = matches.get(position);

        // Rellenar los datos
        holder.homeTeam.setText(match.getFixture().getTeams().getHome().getName());
        holder.awayTeam.setText(match.getFixture().getTeams().getAway().getName());
        holder.matchStatus.setText(match.getFixture().getStatus().getLongStatus());
        holder.matchDate.setText(match.getFixture().getDate());
    }


    @Override
    public int getItemCount() {
        return matches.size();  // Retorna la cantidad de partidos en la lista
    }

    // ViewHolder que representa cada partido en la lista
    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView homeTeam, awayTeam, matchStatus, matchDate;

        public MatchViewHolder(View itemView) {
            super(itemView);

            // Referencia a los elementos del layout de cada item (item_match.xml)
            homeTeam = itemView.findViewById(R.id.home_team);
            awayTeam = itemView.findViewById(R.id.away_team);
            matchStatus = itemView.findViewById(R.id.match_status);
            matchDate = itemView.findViewById(R.id.match_date);
        }
    }
}
