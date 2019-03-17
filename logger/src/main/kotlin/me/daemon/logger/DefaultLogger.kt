package me.daemon.logger

import android.util.Log

/**
 * @author daemon
 * @since 2019-03-17 21:56
 */
open class DefaultLogger : ILogger {

    private var tag: String = ""

    override fun setTag(tag: Any): ILogger {
        this.tag = tag.toString()
        return this
    }

    override fun v(vararg msg: Any) {
        if (level.ordinal > Level.VERBOSE.ordinal) {
            return
        }

        Log.v(tag, concatMessage(*msg))
    }

    override fun d(vararg msg: Any) {
        if (level.ordinal > Level.DEBUG.ordinal) {
            return
        }

        Log.d(tag, concatMessage(*msg))
    }

    override fun i(vararg msg: Any) {
        if (level.ordinal > Level.INFO.ordinal) {
            return
        }

        Log.i(tag, concatMessage(*msg))
    }

    override fun w(vararg msg: Any) {
        if (level.ordinal > Level.WARN.ordinal) {
            return
        }

        Log.w(tag, concatMessage(*msg))
    }

    override fun e(vararg msg: Any) {
        if (level.ordinal > Level.ERROR.ordinal) {
            return
        }

        Log.e(tag, concatMessage(*msg))
    }

}