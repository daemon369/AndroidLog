package me.daemon.logger

/**
 * @author daemon
 * @since 2019-03-16 21:48
 */
interface ILogger {

    fun setTag(tag: Any): ILogger

    fun v(vararg msg: Any)

    fun vt(tag: Any, vararg msg: Any)

    fun d(vararg msg: Any)

    fun dt(tag: Any, vararg msg: Any)

    fun i(vararg msg: Any)

    fun it(tag: Any, vararg msg: Any)

    fun w(vararg msg: Any)

    fun wt(tag: Any, vararg msg: Any)

    fun e(vararg msg: Any)

    fun et(tag: Any, vararg msg: Any)

}