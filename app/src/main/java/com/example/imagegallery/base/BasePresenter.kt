package com.example.imagegallery.base

import androidx.annotation.CallSuper

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 8/18/2021
 */
abstract class BasePresenter<T> protected constructor(view: T) {
    protected var _view: T? = null

    /**
     * Call this method in {Activity#onCreate}
     * or {Fragment#onAttach(Context)} to attach the MVP View object
     */
    @CallSuper
    private fun attachView(view: T) {
        _view = view
    }

    /**
     * Call this method in {Activity#onDestroy()}
     * or {Fragment#onDetach()} to detach the MVP View object
     */
    @CallSuper
    fun detachView() {
        _view = null
    }

    /**
     * Check if the view is attached.
     * This checking is only necessary when returning from an asynchronous call
     */
    protected val isViewAttached: Boolean
        protected get() = _view != null

    init {
        attachView(view)
    }
}