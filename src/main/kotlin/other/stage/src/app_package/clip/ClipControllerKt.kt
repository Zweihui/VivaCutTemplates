package other.stage.src.app_package

import other.fileHeader

fun ClipControllerKt(
  stageClass:String?,
  packageName:String
)="""
package ${packageName}

import com.quvideo.vivacut.editor.stage.clipedit.base.BaseClipController

${fileHeader()}
class Clip${stageClass}Controller(
  index: Int,
  iStage: IClip${stageClass}Stage
)  : BaseClipController<IClip${stageClass}Stage>(index, iStage) {
 
  fun release() {
    
  }
    
}
"""
