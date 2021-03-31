package other.board

import com.android.tools.idea.wizard.template.BooleanParameter
import com.android.tools.idea.wizard.template.Category.Other
import com.android.tools.idea.wizard.template.CheckBoxWidget
import com.android.tools.idea.wizard.template.Constraint.NONEMPTY
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
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template
import other.activity.src.app_package.defaultPackageNameParameter

/**@Author neil
 * @Description TODO
 * @Date 2021/3/31 16:38
 */
val BoardTemplate
  get() = template {
    revision = 1
    name = "VivaCutBoardView"
    description = "VivaCut编辑页BoardView模板"
    minApi = MIN_API
    minBuildApi = MIN_API
    category = Other
    formFactor = Mobile
    screens = listOf(ActivityGallery, MenuEntry, NewProject, NewModule)

    val boardClass = stringParameter {
      name = "Board Name"
      default = "Main"
      help = "请填Board名,如填写 Main,会自动生成 IMainBoard, MainStageController等文件"
      constraints = listOf(NONEMPTY)
    }

    val generateViewModel: BooleanParameter = booleanParameter {
      name = "generateViewModel"
      default = true
      help = "是否创建带ViewModel的BoardView"
    }

    val packageName = defaultPackageNameParameter

    widgets(
        TextFieldWidget(boardClass),
        CheckBoxWidget(generateViewModel),
        PackageNameWidget(packageName)
    )

    recipe = { data: TemplateData ->
      BoardRecipe(
          data as ModuleTemplateData,
          boardClass.value,
          generateViewModel.value,
          packageName.value
      )
    }


  }
