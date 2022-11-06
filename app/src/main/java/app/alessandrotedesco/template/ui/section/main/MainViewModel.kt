package app.alessandrotedesco.template.ui.section.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() { // TODO example
    val liveDataExample = MutableLiveData("Hello World!")
}
