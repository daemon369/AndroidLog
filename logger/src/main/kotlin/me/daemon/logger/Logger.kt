@file:JvmName("Logger")

package me.daemon.logger

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
var logger: ILogger? = null
    set(value) {
        field = value
        loggerClass = null
    }

var loggerClass: Class<out ILogger>? = null
    set(value) {
        field = value
        logger = null
    }

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
    val clz = loggerClass
    if (logger == null && clz != null) {
        logger = clz.newInstance().setTag(tag)
    }

    val logger = logger
    if (logger != null) {
        return logger
    }

    return defaultLogger.setTag(tag)
}

fun v(vararg msg: Any) {
    get().v(*msg)
}

fun v(tag: String, vararg msg: Any) {
    get().setTag(tag).v(*msg)
}

fun d(vararg msg: Any) {
    get().d(*msg)
}

fun d(tag: String, vararg msg: Any) {
    get().setTag(tag).d(*msg)
}

fun i(vararg msg: Any) {
    get().i(*msg)
}

fun i(tag: String, vararg msg: Any) {
    get().setTag(tag).i(*msg)
}

fun w(vararg msg: Any) {
    get().w(*msg)
}

fun w(tag: String, vararg msg: Any) {
    get().setTag(tag).w(*msg)
}

fun e(vararg msg: Any) {
    get().e(*msg)
}

fun e(tag: String, vararg msg: Any) {
    get().setTag(tag).e(*msg)
}

internal fun concatMessage(vararg msg: Any): String {
    val sb = StringBuilder()
    for (m in msg) {
        sb.append(m)
    }

    return sb.toString()
}

