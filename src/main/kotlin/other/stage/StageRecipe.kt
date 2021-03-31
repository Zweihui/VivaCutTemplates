package other.stage

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.stage.model.StageType
import other.stage.model.StageType.CLIP
import other.stage.model.StageType.COLLAGE
import other.stage.model.StageType.SUBTITLE
import other.stage.src.app_package.ClipControllerKt
import other.stage.src.app_package.clip.ClipStageKt
import other.stage.src.app_package.clip.IClipStageKt
import other.stage.src.app_package.ToolProviderKt
import other.stage.src.app_package.collage.CollageControllerKt
import other.stage.src.app_package.collage.CollageStageKt
import other.stage.src.app_package.collage.ICollageStageKt
import other.stage.src.app_package.subtitle.ISubtitleStageKt
import other.stage.src.app_package.subtitle.SubtitleControllerKt
import other.stage.src.app_package.subtitle.SubtitleStageKt

fun RecipeExecutor.StageRecipe(
  moduleData: ModuleTemplateData,
  stageClass: String,
  stageType: StageType,
  generateToolProvider: Boolean,
  packageName: String
) {
  val (projectData, srcOut, resOut) = moduleData
  val ktOrJavaExt = projectData.language.extension
  when (stageType) {
    CLIP -> {
      save(ClipStageKt(stageClass,generateToolProvider,packageName), srcOut.resolve("Clip${stageClass}StageView.${ktOrJavaExt}"))
      save(ClipControllerKt(stageClass,packageName), srcOut.resolve("Clip${stageClass}Controller.${ktOrJavaExt}"))
      save(IClipStageKt(stageClass,packageName), srcOut.resolve("IClip${stageClass}Stage.${ktOrJavaExt}"))
    }
    COLLAGE -> {
      save(CollageStageKt(stageClass,generateToolProvider,packageName), srcOut.resolve("Collage${stageClass}StageView.${ktOrJavaExt}"))
      save(CollageControllerKt(stageClass,packageName), srcOut.resolve("Collage${stageClass}Controller.${ktOrJavaExt}"))
      save(ICollageStageKt(stageClass,packageName), srcOut.resolve("ICollage${stageClass}Stage.${ktOrJavaExt}"))
    }
    SUBTITLE -> {
      save(SubtitleStageKt(stageClass,generateToolProvider,packageName), srcOut.resolve("Subtitle${stageClass}StageView.${ktOrJavaExt}"))
      save(SubtitleControllerKt(stageClass,packageName), srcOut.resolve("Subtitle${stageClass}Controller.${ktOrJavaExt}"))
      save(ISubtitleStageKt(stageClass,packageName), srcOut.resolve("Subtitle${stageClass}Stage.${ktOrJavaExt}"))
    }
  }

  if (generateToolProvider){
    save(ToolProviderKt(stageClass,packageName), srcOut.resolve("${stageClass}ToolProvider.${ktOrJavaExt}"))
  }
}