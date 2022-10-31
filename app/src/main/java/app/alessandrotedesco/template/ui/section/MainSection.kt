package app.alessandrotedesco.template.ui.section

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.alessandrotedesco.template.ui.theme.TemplateTheme

@Composable
fun MainSection(navController: NavHostController) {
    Text(text = "Hello World!") // TODO example
    // TODO example: navController.navigate(Main.Example2.route)
}

@Preview(showBackground = true)
@Composable
fun MainSectionPreview() {
    TemplateTheme {
        val navController = rememberNavController()
        MainSection(navController)
    }
}