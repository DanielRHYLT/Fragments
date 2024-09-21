package dev.dobler.fragments.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.dobler.fragments.R
import dev.dobler.fragments.model.SongModel

class SongAdapter(private var lstSong: List<SongModel>):
    RecyclerView.Adapter<SongAdapter.ViewHolder>(){

        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

            val ivSong: ImageView = itemView.findViewById(R.id.ivSong)
            val tvAlbum: TextView = itemView.findViewById(R.id.tvAlbum)
            val tvSong: TextView = itemView.findViewById(R.id.tvSong)
            val tvSongTime: TextView = itemView.findViewById(R.id.tvSongTime)
            val tvCountPlay: TextView = itemView.findViewById(R.id.tvCountPlay)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_musica, parent, false))
    }

    override fun getItemCount(): Int {
        return lstSong.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemSong = lstSong[position]
        holder.ivSong.setImageResource(itemSong.image)
        holder.tvAlbum.text = itemSong.album
        holder.tvSong.text = itemSong.songName
        holder.tvSongTime.text = itemSong.songTime
        holder.tvCountPlay.text = itemSong.countPlay
    }
}