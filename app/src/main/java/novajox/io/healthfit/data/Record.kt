package novajox.io.healthfit.data

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by Jocelyn on 16/07/2017.
 */
@Table(database = AppDatabase::class)
class Record : BaseModel() {

    @PrimaryKey(autoincrement = true)
    @Column
    var id: Int? = 0

    @Column
    var date: Long = 0
    @Column
    var totalMass: Float = 0f
    @Column
    var fatMass: Float = 0f
    @Column
    var muscleMass: Float = 0f
    @Column
    var waterMass: Float = 0f
}
