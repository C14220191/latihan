package com.example.latihan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Color

class adapterRV (private val list: ArrayList<pengerjaan>) : RecyclerView.Adapter<adapterRV.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _tvNama = itemView.findViewById<TextView>(R.id.tvName)
        var _tvDeskripsi = itemView.findViewById<TextView>(R.id.tvDeskripsi)
        var _tvTanggal = itemView.findViewById<TextView>(R.id.tvTanggal)
        var _tvKategori = itemView.findViewById<TextView>(R.id.tvKategori)
        var _btnKerjakan = itemView.findViewById<TextView>(R.id.btnKerja)
        var _btnEdit = itemView.findViewById<TextView>(R.id.btnEdit)
        var _btnDel = itemView.findViewById<TextView>(R.id.btnDel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterRV.ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.recycle_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var pengerjaan: pengerjaan = list[position]

        holder._tvNama.setText(pengerjaan.nama)
        holder._tvDeskripsi.setText(pengerjaan.deskripsi)
        holder._tvTanggal.setText(pengerjaan.tanggal.toString())
        holder._tvKategori.setText(pengerjaan.kategori)
        holder._btnKerjakan.setText(pengerjaan.status)

        if (holder._btnKerjakan.text == "Done"){
            holder._btnKerjakan.setBackgroundColor(Color.GRAY)
            holder._btnEdit.setBackgroundColor(Color.GRAY)

            holder._btnKerjakan.isEnabled = false
            holder._btnEdit.isEnabled = false
        }

        holder._btnDel.setOnClickListener {
            onItemClickCallback.delData(position)
        }

        holder._btnKerjakan.setOnClickListener{
            onItemClickCallback.dataProgress(position)
        }

        holder._btnEdit.setOnClickListener{
            onItemClickCallback.editData(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun editData(pos:Int)
        fun dataProgress(pos:Int)
        fun delData(pos:Int)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
}