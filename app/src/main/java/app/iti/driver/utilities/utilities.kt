package app.iti.driver.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Hazem on 6/2/2018.
 */
//fun isOnline(context: Context):Boolean{
//
//    if (isNetworkAvailable(context)){
//
//        val urlc: HttpURLConnection = URL("http://www.google.com").openConnection() as HttpURLConnection
//        urlc.setRequestProperty("User-Agent", "Test")
//        urlc.setRequestProperty("Connection", "close")
//        urlc.connectTimeout = 1500
//        urlc.connect()
//        return (urlc.responseCode == 200)
//    }
//    return false
//}

fun isNetworkAvailable(context: Context):Boolean{
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
    return isConnected
}

fun formatDateTime(cal:Calendar):String{
    val sdfDay   = SimpleDateFormat("dd")
    val sdfMonth = SimpleDateFormat("MM")
    val sdfYear  = SimpleDateFormat("yyyy")
    val sdfHour = SimpleDateFormat("HH")
    val sdfMinute = SimpleDateFormat("mm")
    val sdfSec = SimpleDateFormat("ss")

    return sdfYear.format(cal.get(Calendar.YEAR)) + "-" + sdfMonth.format(cal.get(Calendar.MONTH)) + "-" + sdfDay.format(cal.get(Calendar.DAY_OF_MONTH))+
            " " +
            sdfHour.format(cal.get(Calendar.HOUR_OF_DAY)) + ":" + sdfMinute.format(cal.get(Calendar.MINUTE)) + ":" + sdfSec.format(cal.get(Calendar.SECOND))
}
//2018-06-16T22:46:35.535Z
fun confirtDateFormat(oldDate:String):String{
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
    val newFormat = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z")
    var convertedDate = Date()
    convertedDate = dateFormat.parse(oldDate)
    val newDate = newFormat.format(convertedDate)
    Log.i("date","old date:" + oldDate)
    Log.i("date", "converted date: " + convertedDate.toString())
    val str = newDate.toString().split(',')
    val finalDate = str[1].split('+')
    Log.i("date", "new date: " + finalDate[0])
    return finalDate[0]
}
