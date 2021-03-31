package other.activity.src.app_package

import com.android.tools.idea.wizard.template.BooleanParameter
import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.CheckBoxWidget
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.StringParameter
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardParameterData
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.activityToLayout
import com.android.tools.idea.wizard.template.booleanParameter
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template
import other.activity.MvpActivityRecipe

/**@Author neil
 * @Description TODO
 * @Date 2021/3/30 14:10
 */
val MvpActivityTemplate
  get() = template {
    revision = 1
    name = "VivaCutMvpActivity"
    description = "VivaCut项目的Activity的Mvp模板"
    minApi = MIN_API
    minBuildApi = MIN_API
    category = Category.Other
    formFactor = FormFactor.Mobile
    screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

    lateinit var layoutName: StringParameter

    val activityClass = stringParameter {
      name = "Activity Name"
      default = "Main"
      help = "只输入名字，不要包含Activity"
      constraints = listOf(Constraint.NONEMPTY)
    }

    val generateLayout: BooleanParameter = booleanParameter {
      name = "generateLayout"
      default = true
      help = "是否自动创建Activity布局文件"
    }


    layoutName = stringParameter {
      name = "Layout Name"
      default = "activity_main"
      help = "请输入布局的名字"
      visible = { generateLayout.value }
      constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
      suggest = { "${activityToLayout(activityClass.value.toLowerCase())}" }
    }

    val packageName = defaultPackageNameParameter

    widgets(
        TextFieldWidget(activityClass),
        CheckBoxWidget(generateLayout),
        TextFieldWidget(layoutName),
        PackageNameWidget(packageName)
    )
//        thumb { File("logo.png") }
    recipe = { data: TemplateData ->
      MvpActivityRecipe(
          data as ModuleTemplateData,
          activityClass.value,
          layoutName.value,
          generateLayout.value,
          packageName.value)
    }
  }

val defaultPackageNameParameter
  get() = stringParameter {
    name = "Package name"
    visible = { !isNewModule }
    default = "com.mycompany.myapp"
    constraints = listOf(Constraint.PACKAGE)
    suggest = { packageName }
  }

