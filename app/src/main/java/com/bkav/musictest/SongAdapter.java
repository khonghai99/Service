package com.bkav.musictest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {
    private Context context;
    private ArrayList<Audio> audioArrayList;
    private OnNewClickAudio onNewClickAudio;

    public SongAdapter(Context context, ArrayList<Audio> audioArrayList, OnNewClickAudio onNewClickAudio) {
        this.context = context;
        this.audioArrayList = audioArrayList;
        this.onNewClickAudio = onNewClickAudio;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.one_row_song, parent, false);
        return new SongHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, final int position) {
        final Audio audio = audioArrayList.get(position);
        holder.tvNameSong.setText(audio.getTitle());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onNewClickAudio.clickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return audioArrayList.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        private TextView tvNameSong;

        public SongHolder(@NonNull View itemView) {
            super(itemView);
            tvNameSong = itemView.findViewById(R.id.tvNameSong);
        }
    }
}
