package novajox.io.healthfit.view.newrecord

import android.os.Bundle
import android.view.View
import com.raizlabs.android.dbflow.kotlinextensions.save
import khronos.Dates
import kotlinx.android.synthetic.main.newrecord_fragment.*
import novajox.io.healthfit.R
import novajox.io.healthfit.core.fragment.BottomBaseFragment
import novajox.io.healthfit.data.Record

/**
 * Created by Jocelyn on 16/07/2017.
 */
class NewRecordFragment : BottomBaseFragment() {
    override val layout: Int
        get() = R.layout.newrecord_fragment
    override val fullscreen: Boolean
        get() = true


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newRecordValidateButton.setOnClickListener(this::validate)
    }


    fun validate(view: View?) {


        val totalMass = newRecordTotalMass.text.toString().toFloat()
        val fatMass = newRecordFatMass.text.toString().toFloat()
        val muscleMass = newRecordMuscleMass.text.toString().toFloat()
        val waterMass = newRecordWaterMass.text.toString().toFloat()

        val record = Record()
        record.date=Dates.today.time
        record.totalMass = totalMass
        record.fatMass = fatMass
        record.muscleMass = muscleMass
        record.waterMass = waterMass

        record.save()
    }
}