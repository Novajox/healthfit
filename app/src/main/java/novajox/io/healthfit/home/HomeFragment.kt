package novajox.io.healthfit.home

import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.components.YAxis.YAxisLabelPosition
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.home_fragment.*
import novajox.io.healthfit.R
import novajox.io.healthfit.core.fragment.BaseFragment
import novajox.io.healthfit.utils.DayAxisValueFormatter
import novajox.io.healthfit.utils.YAxisValueFormatter


/**
 * Created by Jocelyn on 16/07/2017.
 */
class HomeFragment : BaseFragment() {


    val dataWeight = arrayListOf<Entry>()

    override val layout: Int
        get() = R.layout.home_fragment


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initXAxis()
        initYAxis()

        dataWeight.add(Entry(1f, 54.3f))
        dataWeight.add(Entry(2f, 53.3f))
        dataWeight.add(Entry(3f, 52.9f))
        dataWeight.add(Entry(4f, 53.3f))
        dataWeight.add(Entry(5f, 52.4f))
        dataWeight.add(Entry(6f, 52.1f))

        addData(dataWeight, "Poids")
    }


    private fun initXAxis() {
        val xAxisFormatter = DayAxisValueFormatter(homeFragmentLineChart)

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

    fun addData(entry: List<Entry>, title: String) {
        var lineDataSet = LineDataSet(entry, title)


        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(lineDataSet)
        val data = LineData(dataSets)
        homeFragmentLineChart.data = data

    }
}