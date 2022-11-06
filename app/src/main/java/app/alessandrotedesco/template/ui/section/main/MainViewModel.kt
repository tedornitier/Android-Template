package app.alessandrotedesco.template.ui.section.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import app.alessandrotedesco.template.apiservice.RemoteDataSourceRetrofit
import app.alessandrotedesco.template.apiservice.Resource
import app.alessandrotedesco.template.apiservice.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val api: RemoteDataSourceRetrofit): ViewModel() { // TODO example
    val pokemon = MutableLiveData<Pokemon>()

    fun getPokemon(name: String) = viewModelScope.launch {
        val response = api.getPokemon(name)
        if (response is Resource.Success) {
            pokemon.postValue(response.data)
        } else {
            pokemon.postValue(null) // TODO handle error
        }
    }
}
