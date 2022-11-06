package app.alessandrotedesco.template.ui.section.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.alessandrotedesco.template.ui.theme.TemplateTheme

@Composable
fun MainSection(navController: NavHostController, viewModel: MainViewModel = hiltViewModel()) {
    MainSectionUI(navController, viewModel.liveDataExample)
}

@Composable
fun MainSectionUI(navController: NavHostController, text: MutableLiveData<String>) {
    Text(text = text.observeAsState().value!!) // TODO example
    // TODO example: navController.navigate(Main.Example2.route)
}

@Preview(showBackground = true)
@Composable
fun MainSectionPreview() {
    TemplateTheme {
        val navController = rememberNavController()
        MainSectionUI(navController, MutableLiveData("Hello Preview!"))
    }
}