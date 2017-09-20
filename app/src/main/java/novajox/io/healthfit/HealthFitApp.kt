package novajox.io.healthfit

import android.app.Application
import com.raizlabs.android.dbflow.config.DatabaseConfig
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.runtime.DirectModelNotifier
import novajox.io.healthfit.data.AppDatabase


/**
 * Created by Jocelyn on 16/07/2017.
 */
class HealthFitApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val databaseConfig = DatabaseConfig.Builder(AppDatabase::class.java).modelNotifier(DirectModelNotifier.get()).build()
        FlowManager.init(FlowConfig.Builder(this).addDatabaseConfig(databaseConfig).build())
    }
}