package ru.netology.mediaplayer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.mediaplayer.databinding.ItemTrackBinding
import ru.netology.mediaplayer.model.Track

/**
 *  адаптер для отоб списка [Track]
 */
class TrackAdapter : ListAdapter<Track, TrackAdapter.TrackViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        return TrackViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track = getItem(position)
        holder.bind(track)
    }

    class TrackViewHolder private constructor(
        private val binding: ItemTrackBinding


    ) : RecyclerView.ViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            ItemTrackBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        fun bind(track: Track) {
            binding.track.text = track.name
            binding.album.text = track.albumName

        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Track>() {
        override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean =
            oldItem == newItem
    }
}
