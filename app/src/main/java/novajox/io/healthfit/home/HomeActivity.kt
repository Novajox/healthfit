package novajox.io.healthfit.home

import android.os.Bundle
import novajox.io.healthfit.R
import novajox.io.healthfit.core.activity.BaseActivity
import novajox.io.healthfit.core.utils.FragmentHelper

/**
 * Created by Jocelyn on 16/07/2017.
 */
class HomeActivity : BaseActivity() {
    override val layout: Int
        get() = R.layout.home_activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FragmentHelper.replaceFragment(supportFragmentManager, HomeFragment(), R.id.homeActivityContainer,
                true, false)
    }


}