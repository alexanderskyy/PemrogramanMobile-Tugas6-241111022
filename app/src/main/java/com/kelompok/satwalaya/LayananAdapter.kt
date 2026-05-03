package com.kelompok.satwalaya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LayananAdapter<T>(
    private var items: List<T>,
    private val binder: (View, T) -> Unit,
    private val onHapus: (T) -> Unit
) : RecyclerView.Adapter<LayananAdapter<T>.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        LayoutInflater.from(parent.context).inflate(R.layout.item_layanan, parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        binder(holder.itemView, items[position])
        holder.itemView.findViewById<Button>(R.id.btnHapus).setOnClickListener {
            onHapus(items[position])
        }
    }

    override fun getItemCount() = items.size

    fun updateData(newItems: List<T>) {
        items = newItems
        notifyDataSetChanged()
    }
}