package other.stage.src.app_package.subtitle

import other.fileHeader

fun ISubtitleStageKt(
  stageClass:String?,
  packageName:String
)="""
package ${packageName}

import com.quvideo.vivacut.editor.stage.effect.base.IEffectStage

${fileHeader()}
interface ISubtitle${stageClass}Stage : IEffectStage{
  
}

"""
