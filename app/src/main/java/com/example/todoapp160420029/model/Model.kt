package com.example.todoapp160420029.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
//    var title:String,
//    var notes:String
    @ColumnInfo(name="title")
    var title:String,
    @ColumnInfo(name="notes")
    var notes:String
)
{
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}
