package other.board

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.board.res.layout.BoardViewXml
import other.board.src.app_package.BoardCallBackKt
import other.board.src.app_package.BoardControllerKt
import other.board.src.app_package.BoardViewKt
import other.board.src.app_package.IBoardKt
import other.board.src.app_package.ViewModelKt

fun RecipeExecutor.BoardRecipe(
  moduleData: ModuleTemplateData,
  boardClass: String,
  generateViewModel: Boolean,
  packageName: String
) {
  val (projectData, srcOut, resOut) = moduleData
  val ktOrJavaExt = projectData.language.extension

  save(BoardViewKt(boardClass,generateViewModel,packageName), srcOut.resolve("${boardClass}BoardView.${ktOrJavaExt}"))
  save(BoardControllerKt(boardClass,packageName), srcOut.resolve("${boardClass}BoardController.${ktOrJavaExt}"))
  save(BoardCallBackKt(boardClass,packageName), srcOut.resolve("${boardClass}BoardCallBack.${ktOrJavaExt}"))
  save(IBoardKt(boardClass,packageName), srcOut.resolve("I${boardClass}Board.${ktOrJavaExt}"))
  save(BoardViewXml(), resOut.resolve("layout/editor_${boardClass.toLowerCase()}_board_layout.xml"))
  if (generateViewModel){
    save(ViewModelKt(boardClass,packageName), srcOut.resolve("${boardClass}ViewModel.${ktOrJavaExt}"))
  }
}