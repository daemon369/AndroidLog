@file:JvmName("Logger")

package me.daemon.logger

import android.util.Log
import me.daemon.logger.ILogger.Level

/**
 * @author daemon
 * @since 2019-03-16 21:51
 */

/**
 * logger level
 */
var level: Level = Level.NONE

private val defaultLogger = DefaultLogger().setTag("Logger")

/**
 * customized logger
 */
private var logger: ILogger? = null

var loggerClass: Class<out ILogger>? = null

var tag: String = "Logger"
    set(value) {
        field = value
        val logger = logger ?: defaultLogger
        logger.setTag(field)
    }

fun getLogger(tag: Any): ILogger {
    val clz = loggerClass
    if (clz != null) {
        return clz.newInstance().setTag(tag)
    }

    return DefaultLogger().setTag(tag)
}

private fun get(): ILogger {
    val logger = logger
    if (logger != null) {
        return logger
    }

    val clz = loggerClass
    if (clz != null) {
        return clz.newInstance().setTag(tag)
    }

    return defaultLogger.setTag(tag)
}

fun v(vararg msg: Any) {
    get().v(msg)
}

fun v(tag: Any, vararg msg: Any) {
    get().setTag(tag).v(msg)
}

fun d(vararg msg: Any) {
    get().d(msg)
}

fun d(tag: Any, vararg msg: Any) {
    get().setTag(tag).d(msg)
}

fun i(vararg msg: Any) {
    get().i(msg)
}

fun i(tag: Any, vararg msg: Any) {
    get().setTag(tag).i(msg)
}

fun w(vararg msg: Any) {
    get().w(msg)
}

fun w(tag: Any, vararg msg: Any) {
    get().setTag(tag).w(msg)
}

fun e(vararg msg: Any) {
    get().e(msg)
}

fun e(tag: Any, vararg msg: Any) {
    get().setTag(tag).e(msg)
}

private fun concatMessage(vararg msg: Any): String {
    val sb = StringBuilder()
    for (m in msg) {
        sb.append(m)
    }

    return sb.toString()
}

class DefaultLogger : ILogger {

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

