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
        vt(tag, *msg)
    }

    override fun vt(tag: Any, vararg msg: Any) {
        if (level.ordinal > Level.VERBOSE.ordinal) {
            return
        }

        Log.v(tag.toString(), concatMessage(*msg))
    }

    override fun d(vararg msg: Any) {
        dt(tag, *msg)
    }

    override fun dt(tag: Any, vararg msg: Any) {
        if (level.ordinal > Level.DEBUG.ordinal) {
            return
        }

        Log.d(tag.toString(), concatMessage(*msg))
    }

    override fun i(vararg msg: Any) {
        it(tag, *msg)
    }

    override fun it(tag: Any, vararg msg: Any) {
        if (level.ordinal > Level.INFO.ordinal) {
            return
        }

        Log.i(tag.toString(), concatMessage(*msg))
    }

    override fun w(vararg msg: Any) {
        wt(tag, *msg)
    }

    override fun wt(tag: Any, vararg msg: Any) {
        if (level.ordinal > Level.WARN.ordinal) {
            return
        }

        Log.w(tag.toString(), concatMessage(*msg))
    }

    override fun e(vararg msg: Any) {
        et(tag, *msg)
    }

    override fun et(tag: Any, vararg msg: Any) {
        if (level.ordinal > Level.ERROR.ordinal) {
            return
        }

        Log.e(tag.toString(), concatMessage(*msg))
    }

}