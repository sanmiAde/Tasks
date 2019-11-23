package com.devsanmiaderibigbe.tasks.data.remote

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, null, msg)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null)
        }

        fun <T> loaded(data : T) : Resource<T> {
            return Resource(Status.LOADED, data, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING,
    LOADED
}