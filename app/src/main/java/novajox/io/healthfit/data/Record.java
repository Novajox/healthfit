package novajox.io.healthfit.data;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

/**
 * Created by Jocelyn on 16/07/2017.
 */
@Table(database = AppDatabase.class)
public class Record {

    @PrimaryKey(autoincrement = true)
    Integer id;
    public Long date;
    public Float totalMass;
    public Float fatMass;
    public Float muscleMass;
    public Float waterMass;
}
