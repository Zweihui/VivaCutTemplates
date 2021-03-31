package other.board.src.app_package

import other.fileHeader

fun ViewModelKt(
  viewModelName:String?,
  packageName:String
)="""
package ${packageName}

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

${fileHeader()}
class ${viewModelName}ViewModel : ViewModel(){

  //var data = MutableLiveData<Any>()

  override fun onCleared() {

  }

}
"""