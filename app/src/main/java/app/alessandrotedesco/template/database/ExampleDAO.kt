package app.alessandrotedesco.template.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import app.alessandrotedesco.template.database.model.Example
import kotlinx.coroutines.flow.Flow

@Dao
interface ExampleDAO {
    @Query("SELECT * FROM Example LIMIT 1")
    fun getExample(): Flow<Example?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(example: Example): Long

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(example: Example)

    @Delete
    suspend fun delete(example: Example)

    @Query("DELETE FROM Example")
    suspend fun deleteAll()

    @Transaction
    suspend fun upsert(entity: Example) {
        val id = insert(entity)
        if (id == -1L) {
            update(entity)
        }
    }
}
