package other.stage.src.app_package.clip

import other.fileHeader

fun IClipStageKt(
  stageClass:String?,
  packageName:String
)="""
package ${packageName}

import com.quvideo.vivacut.editor.stage.clipedit.base.IBaseTransformStage

${fileHeader()}
interface IClip${stageClass}Stage : IBaseTransformStage{
  
}
"""
