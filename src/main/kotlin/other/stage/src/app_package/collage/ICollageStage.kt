package other.stage.src.app_package.collage

import other.fileHeader

fun ICollageStageKt(
  stageClass:String?,
  packageName:String
)="""
package ${packageName}

import com.quvideo.vivacut.editor.stage.effect.base.IEffectStage

${fileHeader()}
interface ICollage${stageClass}Stage : IEffectStage{
  
}
"""
