package me.daemon.logger

/**
 * @author daemon
 * @since 2019-03-16 21:48
 */
interface ILogger {

    enum class Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR,
        NONE
    }

    fun v(tag: Any, vararg msg: Any)

    fun d(tag: Any, vararg msg: Any)

    fun i(tag: Any, vararg msg: Any)

    fun w(tag: Any, vararg msg: Any)

    fun e(tag: Any, vararg msg: Any)

}