package com.decagon.mubarak.dog_app.util

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String?
) {
    companion object {
        // success status
        fun <T> success(data: T?): Resource<T> = Resource(Status.SUCCESS, data, null)

        // error state
        fun <T> error(message: String?, data: T?): Resource<T> = Resource(Status.ERROR, data, message)

        // loading state
        fun <T> loading(data: T?): Resource<T> = Resource(Status.LOADING, data, null)
    }
}
