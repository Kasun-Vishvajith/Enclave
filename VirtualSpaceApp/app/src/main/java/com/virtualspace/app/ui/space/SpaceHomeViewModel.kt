package com.virtualspace.app.ui.space

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.virtualspace.app.data.model.SpaceApp
import com.virtualspace.app.data.repository.SpaceAppsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SpaceHomeState(
    val apps: List<SpaceApp> = emptyList(),
    val pinnedApps: List<SpaceApp> = emptyList(),
    val isLoading: Boolean = true
)

@HiltViewModel
class SpaceHomeViewModel @Inject constructor(
    private val repository: SpaceAppsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SpaceHomeState())
    val uiState: StateFlow<SpaceHomeState> = _uiState.asStateFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            val apps = repository.getSpaceApps()
            _uiState.value = SpaceHomeState(
                apps = apps,
                pinnedApps = apps.take(4),
                isLoading = false
            )
        }
    }
}
