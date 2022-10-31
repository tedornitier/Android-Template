package app.alessandrotedesco.template.ui.navigation

sealed class Main(val route: String) {
    object Example : Main("example")
}