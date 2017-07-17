package novajox.io.healthfit.core.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Jocelyn on 16/07/2017.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }
}