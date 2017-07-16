package novajox.io.healthfit.view.home

import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.components.YAxis.YAxisLabelPosition
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.raizlabs.android.dbflow.kotlinextensions.list
import com.raizlabs.android.dbflow.kotlinextensions.select
import khronos.Dates
import kotlinx.android.synthetic.main.home_fragment.*
import novajox.io.healthfit.R
import novajox.io.healthfit.core.fragment.BaseFragment
import novajox.io.healthfit.data.Record
import novajox.io.healthfit.utils.DayAxisValueFormatter
import novajox.io.healthfit.utils.YAxisValueFormatter
import novajox.io.healthfit.view.newrecord.NewRecordFragment
import java.util.*


/**
 * Created by Jocelyn on 16/07/2017.
 */
class HomeFragment : BaseFragment() {


    val totalMass = arrayListOf<Entry>()
    val waterMass = arrayListOf<Entry>()
    val muscleMass = arrayListOf<Entry>()
    val fatMass = arrayListOf<Entry>()

    override val layout: Int
        get() = R.layout.home_fragment


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeFragmentNewRecordButton.setOnClickListener({
            NewRecordFragment().show(fragmentManager, NewRecordFragment::javaClass.name)
        })

        initXAxis()
        initYAxis()

        val today = Dates.today
        var day = today

        val results = (select.from(Record::class.java)).list
        // can call .result for single result
        // .hasData if it has results
        // .statement for a compiled statement
        for (record in results) {
            val date = record.date.toFloat()
            totalMass.add(Entry(date, record.totalMass))
            waterMass.add(Entry(date, record.waterMass))
            muscleMass.add(Entry(date, record.muscleMass))
            fatMass.add(Entry(date, record.fatMass))
        }

        addData(totalMass, "Poids", android.R.color.black)
        addData(waterMass, "Eau", android.R.color.holo_blue_dark)
        addData(muscleMass, "Muscle", R.color.colorAccent)
        addData(fatMass, "Graisse", android.R.color.holo_red_light)
    }


    private fun initXAxis() {
        val xAxisFormatter = DayAxisValueFormatter()

        val xAxis = homeFragmentLineChart.xAxis
        xAxis.position = XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.granularity = 1f // only intervals of 1 day
        xAxis.labelCount = 7
        xAxis.valueFormatter = xAxisFormatter


    }


    private fun initYAxis() {

        val custom = YAxisValueFormatter()

        val leftAxis = homeFragmentLineChart.axisLeft
        leftAxis.setLabelCount(10, false)
        leftAxis.valueFormatter = custom
        leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART)
        leftAxis.spaceTop = 15f
        leftAxis.axisMinimum = 0f

    }

    fun addData(entry: List<Entry>, title: String, color: Int) {
        var lineDataSet = LineDataSet(entry, title)
        lineDataSet.setDrawCircles(true)
        lineDataSet.color = color


        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(lineDataSet)

        val data = LineData(dataSets)
        homeFragmentLineChart.data = data

    }
}