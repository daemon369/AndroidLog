@file:JvmName("Logger")

package me.daemon.logger

/**
 * @author daemon
 * @since 2019-03-16 21:51
 */

var loggerClass: Class<out ILogger>? = null

private fun generateLogger(): ILogger {
    val clz = loggerClass

    if (clz != null) {
        return clz.newInstance()
    }

    return DefaultLogger()
}

fun getLogger(any: Any): ILogger {
    return generateLogger()
}

fun v(tag: Any, vararg msg: Any) {
}

fun d(tag: Any, vararg msg: Any) {
}

fun i(tag: Any, vararg msg: Any) {
}

fun w(tag: Any, vararg msg: Any) {
}

fun e(tag: Any, vararg msg: Any) {
}


class DefaultLogger : ILogger {
    override fun v(tag: Any, vararg msg: Any) {
    }

    override fun d(tag: Any, vararg msg: Any) {
    }

    override fun i(tag: Any, vararg msg: Any) {
    }

    override fun w(tag: Any, vararg msg: Any) {
    }

    override fun e(tag: Any, vararg msg: Any) {
    }

}

