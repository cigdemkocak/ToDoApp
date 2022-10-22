package com.cigdemkocak.todoapp.data.entity
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "yapilacakIsler")
data class YapilacakIsler(@PrimaryKey(autoGenerate = true)
                          @ColumnInfo(name= "yapilacak_Is_Id") @NonNull var yapilacak_Is_Id:Int,
                          @ColumnInfo(name= "yapilacak_Is") @NonNull var yapilacak_Is: String) : Serializable{
}