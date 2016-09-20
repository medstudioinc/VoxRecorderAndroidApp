package cafe.adriel.voxrecorder.util

import android.os.Build
import android.support.v7.app.AppCompatDelegate
import cafe.adriel.voxrecorder.Constant
import cafe.adriel.voxrecorder.R
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.pawegio.kandroid.fromApi
import com.pawegio.kandroid.toApi
import org.ocpsoft.prettytime.PrettyTime

object Util {

    val prettyTime = PrettyTime()

    fun isDarkTheme() = pref().getBoolean(Constant.PREF_THEME_DARK_MODE, false)

    fun getThemeMode() = if(isDarkTheme()) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO

    fun getRecorderColor() = pref().getInt(Constant.PREF_THEME_RECORDER_COLOR, color(R.color.peter_river))

    fun isRecorderColorBright() = cafe.adriel.androidaudiorecorder.Util.isBrightColor(getRecorderColor())

    fun isCpu86(): Boolean {
        var abi86 = false
        fromApi(21){
            abi86 = Build.SUPPORTED_ABIS.any { it.contains("86") }
        }
        toApi(21){
            abi86 = Build.CPU_ABI.contains("86") || Build.CPU_ABI2.contains("86")
        }
        return abi86
    }

    fun getPlayIcon() = GoogleMaterial.Icon.gmd_play_arrow.formattedName

    fun getPauseIcon() = GoogleMaterial.Icon.gmd_pause.formattedName

}