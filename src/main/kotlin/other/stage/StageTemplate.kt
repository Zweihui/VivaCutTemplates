package other.stage

import com.android.tools.idea.wizard.template.BooleanParameter
import com.android.tools.idea.wizard.template.Category.Other
import com.android.tools.idea.wizard.template.CheckBoxWidget
import com.android.tools.idea.wizard.template.Constraint.NONEMPTY
import com.android.tools.idea.wizard.template.EnumWidget
import com.android.tools.idea.wizard.template.FormFactor.Mobile
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext.ActivityGallery
import com.android.tools.idea.wizard.template.WizardUiContext.MenuEntry
import com.android.tools.idea.wizard.template.WizardUiContext.NewModule
import com.android.tools.idea.wizard.template.WizardUiContext.NewProject
import com.android.tools.idea.wizard.template.booleanParameter
import com.android.tools.idea.wizard.template.enumParameter
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template
import other.activity.src.app_package.defaultPackageNameParameter
import other.stage.model.StageType

/**@Author neil
 * @Description TODO
 * @Date 2021/3/31 14:59
 */

val StageTemplate
  get() = template {
    revision = 1
    name = "VivaCutStageView"
    description = "VivaCut编辑页StageView模板"
    minApi = MIN_API
    minBuildApi = MIN_API
    category = Other
    formFactor = Mobile
    screens = listOf(ActivityGallery, MenuEntry, NewProject, NewModule)

    val stageClass = stringParameter {
      name = "Stage Name"
      default = "Main"
      help = "请填Stage名,如填写 Main,会自动生成 IMainStage, MainStageController等文件"
      constraints = listOf(NONEMPTY)
    }

    val stageType = enumParameter<StageType> {
      name = "Stage Type"
      default = StageType.CLIP
      help = "选择自动生成的Stage类型"
    }

    var generateToolProvider: BooleanParameter = booleanParameter {
      name = "Generate ToolProvider"
      default = true
      help = "如果需要创建ToolProvider,请勾选下面的单选框"
    }

    val packageName = defaultPackageNameParameter

    widgets(
        TextFieldWidget(stageClass),
        EnumWidget(stageType),
        CheckBoxWidget(generateToolProvider),
        PackageNameWidget(packageName)
    )

    recipe = { data: TemplateData ->
      StageRecipe(
          data as ModuleTemplateData,
          stageClass.value,
          stageType.value,
          generateToolProvider.value,
          packageName.value
      )
    }
  }
