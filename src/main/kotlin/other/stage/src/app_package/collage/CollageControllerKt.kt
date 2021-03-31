package other.stage.src.app_package.collage

import other.fileHeader

fun CollageControllerKt(
  stageClass:String?,
  packageName:String
)="""
package ${packageName}

import com.quvideo.vivacut.editor.stage.effect.collage.base.BaseCollageController
import com.quvideo.xiaoying.sdk.editor.effect.IEffectAPI

${fileHeader()}
class Collage${stageClass}Controller(
  index: Int,
  effectAPI: IEffectAPI,
  iCollage: ICollage${stageClass}Stage,
  isSticker:Boolean
)  : BaseCollageController<ICollage${stageClass}Stage>(index, effectAPI, iCollage,isSticker) {

  init {
    
  }
 	
  fun release() {
    
  }
    
}

"""
