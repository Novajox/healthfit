package novajox.io.healthfit.data

import com.raizlabs.android.dbflow.annotation.Database

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
object AppDatabase {

    const val NAME = "AppDatabase"

    const val VERSION = 1
}