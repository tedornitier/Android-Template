package app.alessandrotedesco.template.ui.section.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.alessandrotedesco.template.apiservice.model.Pokemon
import app.alessandrotedesco.template.ui.theme.TemplateTheme

@Composable
fun MainSection(navController: NavHostController, viewModel: MainViewModel = hiltViewModel()) {
    MainSectionUI(navController, viewModel.pokemon) {
        viewModel.getPokemon(it)
    }
}

@Composable
fun MainSectionUI(navController: NavHostController, pokemon: MutableLiveData<Pokemon>, getPokemon: (String) -> Unit = {}) {
    Column {
        Text(text = pokemon.observeAsState().value?.let { it.name + " #" + it.id }
            ?: "??? #??") // TODO example
        Button(onClick = { getPokemon.invoke("pikachu") }) {
            Text(text = "Get Pikachu")
        }
        Button(onClick = { getPokemon("charizard") }) {
            Text(text = "Get Charizard")
        }
    }
    // TODO example: navController.navigate(Main.Example2.route)
}

@Preview(showBackground = true)
@Composable
fun MainSectionPreview() {
    TemplateTheme {
        val navController = rememberNavController()
        MainSectionUI(navController, MutableLiveData(Pokemon("Pikachu", 25, 4)))
    }
}