package other.stage.src.app_package.subtitle

import other.fileHeader

fun SubtitleControllerKt(
  stageClass:String?,
  packageName:String
)="""
package ${packageName}

import com.quvideo.vivacut.editor.stage.effect.subtitle.base.BaseSubtitleController
import com.quvideo.xiaoying.sdk.editor.effect.IEffectAPI

${fileHeader()}
class Subtitle${stageClass}Controller(
  index: Int,
  effectAPI: IEffectAPI,
  iCollage: ISubtitle${stageClass}Stage
)  : BaseSubtitleController<ISubtitle${stageClass}Stage>(index, effectAPI, iCollage) {

  init {
    
  }
 	
  fun release() {
    
  }
    
}

"""
