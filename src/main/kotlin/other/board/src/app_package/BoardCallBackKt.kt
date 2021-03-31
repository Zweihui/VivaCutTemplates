package other.board.src.app_package

import other.fileHeader

fun BoardCallBackKt(
  boardClass:String?,
  packageName:String
)="""
package ${packageName}

import com.quvideo.vivacut.editor.stage.base.BaseBoardCallback

${fileHeader()}
interface ${boardClass}BoardCallBack : BaseBoardCallback{

}
"""