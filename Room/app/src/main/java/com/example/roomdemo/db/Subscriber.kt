package com.example.roomdemo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscriber_data_table") //테이블 이름 지정
data class Subscriber(

    @PrimaryKey(autoGenerate = true) //primarykey 지정 및 자동 생성성
    @ColumnInfo(name = "subscriber_id") //컬럼 이름 지정
    val id: Int,

    @ColumnInfo(name = "subscriber_name")
    val name: String,

    @ColumnInfo(name = "subscriber_email")
    val email: String
)