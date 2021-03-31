package other.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.activity.res.layout.CommonActivityXml
import other.activity.src.app_package.ControllerKt
import other.activity.src.app_package.IMvpViewKt
import other.activity.src.app_package.MvpAcitivityKt

fun RecipeExecutor.MvpActivityRecipe(
  moduleData: ModuleTemplateData,
  activityClass: String,
  layoutName: String,
  generateLayout: Boolean,
  packageName: String
) {
  val (projectData, srcOut, resOut) = moduleData
  val ktOrJavaExt = projectData.language.extension
//    generateManifest(
//            moduleData = moduleData,
//            activityClass = "${activityClass}Activity",
//            activityTitle = activityClass,
//            packageName = packageName,
//            isLauncher = false,
//            hasNoActionBar = false,
//            generateActivityTitle = true,
//            requireTheme = false,
//            useMaterial2 = false
//    )

  val activity = MvpAcitivityKt(projectData.applicationPackage, activityClass, layoutName,generateLayout, packageName)
  save(activity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
  if (generateLayout){
    save(CommonActivityXml(), resOut.resolve("layout/${layoutName}.xml"))
  }
  save(IMvpViewKt(activityClass,packageName), srcOut.resolve("I${activityClass}.${ktOrJavaExt}"))
  save(ControllerKt(activityClass,packageName), srcOut.resolve("${activityClass}Controller.${ktOrJavaExt}"))
}