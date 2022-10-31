package app.alessandrotedesco.template.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Example")
data class Example(
    @PrimaryKey
    @ColumnInfo(name = "value")
    val value: String
)
