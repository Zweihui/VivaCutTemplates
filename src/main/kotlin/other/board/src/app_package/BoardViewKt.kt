package other.board.src.app_package

import other.fileHeader

fun BoardViewKt(
  boardClass:String?,
  generateViewModel:Boolean,
  packageName:String
)="""
package ${packageName}

import android.content.Context
import com.quvideo.vivacut.editor.R
import com.quvideo.vivacut.editor.stage.base.AbstractBoardView

${fileHeader()}
class ${boardClass}BoardView(
  context: Context,
  callBack: ${boardClass}BoardCallBack
) :AbstractBoardView<${boardClass}BoardCallBack>(context, callBack),I${boardClass}Board{

  private val mController by lazy {
    ${boardClass}BoardController(this)
  }

  ${if(generateViewModel)
""" private val mViewModel by lazy{
    getBoardScopeViewModel(${boardClass}ViewModel::class.java)
  }"""
    else
      ""
  }
  
  override fun getLayoutId(): Int {
    return R.layout.editor_${boardClass}_board_layout
  }

  override fun onViewCreated() {

  }
  
}
"""