@file:JvmName("Logger")

package me.daemon.logger

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

class DefaultLogger : ILogger {

    var tag: String = ""

    override fun setTag(tag: Any): ILogger {
        this.tag = tag.toString()
        return this
    }

    override fun v(vararg msg: Any) {
    }

    override fun d(vararg msg: Any) {
    }

    override fun i(vararg msg: Any) {
    }

    override fun w(vararg msg: Any) {
    }

    override fun e(vararg msg: Any) {
    }

}

