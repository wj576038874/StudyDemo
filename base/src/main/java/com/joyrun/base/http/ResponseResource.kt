package com.joyrun.base.http


class ResponseResource<T> private constructor() {
    var status: Status? = null
    var data: T? = null
    var message: String? = null


    private constructor(status: Status?, data: T?, message: String?) : this() {
        this.status = status
        this.data = data
        this.message = message
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {

        fun <T> success(data: T): ResponseResource<T> {
            return ResponseResource(Status.SUCCESS, data, "")
        }

        fun <T> error(msg: String?): ResponseResource<T> {
            return ResponseResource(Status.ERROR, null, msg)
        }

        fun <T> loading(): ResponseResource<T> {
            return ResponseResource(Status.LOADING, null, "")
        }
    }
}