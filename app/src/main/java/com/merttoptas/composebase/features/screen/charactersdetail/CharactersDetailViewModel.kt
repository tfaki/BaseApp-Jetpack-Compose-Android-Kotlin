package com.merttoptas.composebase.features.screen.charactersdetail

import androidx.lifecycle.SavedStateHandle
import com.merttoptas.composebase.data.model.Result
import com.merttoptas.composebase.domain.viewstate.IViewEvent
import com.merttoptas.composebase.domain.viewstate.charactersdetail.CharactersDetailViewState
import com.merttoptas.composebase.features.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by merttoptas on 13.03.2022
 */
@HiltViewModel
class CharactersDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<CharactersDetailViewState, CharactersDetailViewEvent>() {

    init {
        savedStateHandle.get<String>("characterDetail")?.let {
            setState { currentState.copy(isLoading = false, data = Result.create(it)) }
        }
    }

    override fun createInitialState() = CharactersDetailViewState()
}

sealed class CharactersDetailViewEvent : IViewEvent {
    class SnackbarEffect(val message: String?) : CharactersDetailViewEvent()
}