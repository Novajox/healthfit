package novajox.io.healthfit.data

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by Jocelyn on 16/07/2017.
 */
@Table(database = AppDatabase::class)
class Record : BaseModel {

    @PrimaryKey(autoincrement = true)
    var id: Int? = null
    @Column
    var date: Long? = null
    @Column
    var totalMass: Float? = null
    @Column
    var fatMass: Float? = null
    @Column
    var muscleMass: Float? = null
    @Column
    var waterMass: Float? = null

    constructor() {}

}
