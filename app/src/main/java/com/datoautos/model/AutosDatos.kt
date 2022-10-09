package com.datoautos.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName="AutosDatos")
data class AutosDatos (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="marcaAuto")
    val marcaAuto: String?,
    @ColumnInfo(name="modeloAuto")
    val modeloAuto: String?,
    @ColumnInfo(name="mortorInfo")
    val motorInfo: String?,
    @ColumnInfo(name="caballosMotor")
    val caballosMotor: Int?,
    @ColumnInfo(name="velocidadMaxima")
    val velocidadMaxima: Int?
    ): Parcelable