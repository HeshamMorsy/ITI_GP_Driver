package app.iti.driver.utilities

import android.content.Context
import android.support.multidex.MultiDexApplication

class MainApplication :  MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LocaleHelper.onAttach(base!!, "en"))
    }

}