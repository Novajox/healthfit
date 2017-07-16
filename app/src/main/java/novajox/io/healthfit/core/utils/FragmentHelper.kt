package novajox.io.healthfit.core.utils

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager


/**
 * Created by josh on 24/08/16.
 */
object FragmentHelper {


    fun replaceFragmentNoAnim(fragmentManager: FragmentManager, fragment: Fragment, @IdRes id: Int, clearBackstack: Boolean, withBackstack: Boolean) {
        updateFragment(false, fragmentManager, fragment, id, clearBackstack, withBackstack, false)
    }

    fun replaceFragment(fragmentManager: FragmentManager, fragment: Fragment, @IdRes id: Int, clearBackstack: Boolean, withBackstack: Boolean) {
        updateFragment(false, fragmentManager, fragment, id, clearBackstack, withBackstack, true)
    }

    /***
     * @param fragment
     * *
     * @param clearBackStack
     * *
     * @param withBackstack
     */
    fun addFragment(fragmentManager: FragmentManager, fragment: Fragment, @IdRes id: Int,
                    clearBackStack: Boolean, withBackstack: Boolean) {
        updateFragment(true, fragmentManager, fragment, id, clearBackStack, withBackstack, true)
    }


    /***
     * @param fragmentName
     * *
     * @return
     * *
     * @throws IllegalAccessException
     * *
     * @throws InstantiationException
     */
    @Throws(IllegalAccessException::class, InstantiationException::class)
    fun fragmentByName(fragmentName: String): Fragment {
        var className: Class<*>? = null
        try {
            className = Class.forName(fragmentName)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }

        return className!!.newInstance() as Fragment
    }

    /***
     * @param fragment
     * *
     * @param clearBackStack
     * *
     * @param withBackstack
     */
    private fun updateFragment(add: Boolean, fragmentManager: FragmentManager, fragment: Fragment, @IdRes id: Int,
                               clearBackStack: Boolean, withBackstack: Boolean, withAnim: Boolean) {

        // Clear the back stack if needed
        if (clearBackStack) {
            while (fragmentManager.backStackEntryCount > 0) {
                fragmentManager.popBackStackImmediate()
            }
        }
        // Set up the transaction
        var transaction = fragmentManager.beginTransaction()
        if (withAnim)
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        if (add)
            transaction.add(id, fragment, fragment.javaClass.simpleName)
        else
            transaction.replace(id, fragment, fragment.javaClass.simpleName)
        // Add the new fragment to back stack if needed
        if (withBackstack) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }

        // Commit transaction
        try {
            transaction.commit()
        } catch (e: Exception) {
            transaction = fragmentManager.beginTransaction()
            transaction.replace(id, fragment)
            transaction.commitAllowingStateLoss()
        }

    }


}
