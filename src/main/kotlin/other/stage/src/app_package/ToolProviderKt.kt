package other.stage.src.app_package

import other.fileHeader


fun ToolProviderKt(
  stageClass:String?,
  packageName:String
)="""
package ${packageName}

import com.quvideo.vivacut.editor.stage.common.ToolItemModel

${fileHeader()}
class ${stageClass}ToolProvider{
  companion object {
    @JvmStatic
    fun getToolList(): List<ToolItemModel> {
      return ArrayList<ToolItemModel>()
    }
  }   
}

"""
