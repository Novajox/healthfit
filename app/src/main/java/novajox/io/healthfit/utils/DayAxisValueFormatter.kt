package novajox.io.healthfit.utils

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date

class DayAxisValueFormatter : IAxisValueFormatter {
    internal var f: DateFormat = SimpleDateFormat("dd")

    init {
        for (i in 0..9) {

        }
    }

    override fun getFormattedValue(value: Float, axis: AxisBase): String {

        val days = value.toLong()
        val d = Date(days)
        val text = f.format(d)
        return text

    }


}