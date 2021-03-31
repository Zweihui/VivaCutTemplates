package other

/**@Author neil
 * @Description TODO
 * @Date 2021/3/30 15:10
 */
import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.activity.src.app_package.MvpActivityTemplate
import other.board.BoardTemplate
import other.stage.StageTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

  override fun getTemplates(): List<Template> = listOf(
      // activity的模板
      MvpActivityTemplate,
      // stage的模板
      StageTemplate,
      // board的模板
      BoardTemplate
  )
}