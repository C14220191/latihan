package com.example.latihan

import android.os.Parcelable
import java.util.Date
import kotlinx.android.parcel.Parcelize

@Parcelize
data class pengerjaan(
    var nama : String,
    var tanggal : Date,
    var kategori : String,
    var deskripsi : String,
    var status : String,
) : Parcelable
