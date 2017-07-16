package novajox.io.healthfit

import android.app.Application
import com.raizlabs.android.dbflow.config.FlowManager


/**
 * Created by Jocelyn on 16/07/2017.
 */
class HealthFitApp : Application() {

    override fun onCreate() {
        super.onCreate()
        FlowManager.init(this)
    }
}