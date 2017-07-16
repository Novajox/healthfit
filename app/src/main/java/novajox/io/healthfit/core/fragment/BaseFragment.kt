package novajox.io.healthfit.core.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Jocelyn on 16/07/2017.
 */
abstract class BaseFragment : Fragment() {

    abstract val layout: Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(layout, container, false)
        return view
    }

}