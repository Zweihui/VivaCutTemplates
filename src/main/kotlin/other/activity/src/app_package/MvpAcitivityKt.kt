package other.activity.src.app_package

import other.fileHeader

fun MvpAcitivityKt(
  applicationPackage:String?,
  activityClass:String,
  layoutName:String,
  generateLayout:Boolean,
  packageName:String
)="""
package ${packageName}

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ${applicationPackage}.R

${fileHeader()}
class ${activityClass}Activity : AppCompatActivity(), I${activityClass} {

    private lateinit var mController: ${activityClass}Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ${
        if (generateLayout)
          "setContentView(R.layout.${layoutName})"
        else
          ""
        }
        init()
    }

    private fun init() {
     mController = ${activityClass}Controller(this)
     lifecycle.addObserver(mController)
    }

    override 
    fun getHostActivity(): Activity {
     return this
   }    

}
"""