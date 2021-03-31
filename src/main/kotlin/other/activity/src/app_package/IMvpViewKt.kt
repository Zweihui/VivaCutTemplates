package other.activity.src.app_package

import other.fileHeader

fun IMvpViewKt(
  activityClass:String,
  packageName:String
)="""
package ${packageName}

import android.app.Activity
import com.quvideo.mobile.component.utils.mvp.MvpView

${fileHeader()}
interface I${activityClass} : MvpView {

   fun getHostActivity():Activity
}

"""