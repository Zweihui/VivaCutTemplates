package other.activity.src.app_package

import other.fileHeader

fun ControllerKt(
  activityClass:String,
  packageName:String
)="""
package ${packageName}  
  
import com.quvideo.mobile.component.utils.mvp.BaseController
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent

${fileHeader()}
class ${activityClass}Controller(mvpView: I${activityClass})  : BaseController<I${activityClass}>(mvpView), LifecycleObserver  {

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE) 
  fun onCreate() {

  }

  @OnLifecycleEvent(Lifecycle.Event.ON_START) 
  fun onStart() {

  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME) 
  fun onResume() {

  }

  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE) 
  fun onPause() {

  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP) 
  fun onStop() {

  }

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY) 
  fun onDestroy() {

  }
    
}

"""