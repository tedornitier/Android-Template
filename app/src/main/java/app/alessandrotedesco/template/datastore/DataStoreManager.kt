package app.alessandrotedesco.template.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import app.alessandrotedesco.template.datastore.PreferencesKeys.EXAMPLE_VALUE
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(PreferencesKeys.USER_PREFERENCES)

@Singleton
class DataStoreManager @Inject constructor(@ApplicationContext context: Context) {

    private val settingsDataStore = context.dataStore
    private val coroutineScope = CoroutineScope(Job())

    suspend fun resetDataStore() {
        settingsDataStore.edit {
            it.clear()
        }
    }

    suspend fun setExampleValue(exampleValue: Int) { // TODO example
        settingsDataStore.edit { preferences ->
            preferences[EXAMPLE_VALUE] = exampleValue
        }
    }

    val exampleValue: StateFlow<Int> = settingsDataStore.data.map { preferences -> // TODO example
        preferences[EXAMPLE_VALUE] ?: 0
    }.stateIn(coroutineScope, SharingStarted.Lazily, 0)
}