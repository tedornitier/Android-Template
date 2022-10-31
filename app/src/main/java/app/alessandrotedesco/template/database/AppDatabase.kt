package app.alessandrotedesco.template.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.alessandrotedesco.template.database.converter.ExampleConverter
import app.alessandrotedesco.template.database.model.Example

@Database(
    entities = [Example::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [ExampleConverter::class] // TODO example
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDAO // TODO example
}
