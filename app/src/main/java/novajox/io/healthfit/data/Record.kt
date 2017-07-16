package novajox.io.healthfit.data

import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table

/**
 * Created by Jocelyn on 16/07/2017.
 */
@Table(database = AppDatabase::class)
class Record {
    @PrimaryKey(autoincrement = true) var id: Int = 0
    var date: Long = 0
    var totalMass: Float = 0.0f
    var fatMass: Float = 0.0f
    var muscleMass: Float = 0.0f
    var waterMass: Float = 0.0f

}