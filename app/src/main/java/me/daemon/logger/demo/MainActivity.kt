package me.daemon.logger.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.daemon.logger.ILogger
import me.daemon.logger.getLogger
import me.daemon.logger.level

class MainActivity : AppCompatActivity() {

    private val logger = getLogger(MainActivity::class.java)

    init {
        level = ILogger.Level.VERBOSE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logger.i(1, 2, 3)
    }
}
