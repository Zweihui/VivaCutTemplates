package other.stage.src.app_package.collage

import other.fileHeader

fun CollageStageKt(
  stageClass:String?,
  generateToolProvider:Boolean,
  packageName:String
)="""
package ${packageName}

import android.annotation.SuppressLint
import androidx.fragment.app.FragmentActivity
import com.quvideo.vivacut.editor.common.Stage
import com.quvideo.vivacut.editor.stage.effect.collage.base.BaseCollageStageView
import com.quvideo.xiaoying.sdk.constant.XYSdkConstants
import com.quvideo.xiaoying.sdk.editor.cache.EffectDataModel
${if (generateToolProvider)
"""import com.quvideo.vivacut.editor.stage.common.CommonToolAdapter
   import androidx.recyclerview.widget.LinearLayoutManager
   import androidx.recyclerview.widget.RecyclerView
   import com.quvideo.vivacut.editor.stage.common.ToolCallback
   import com.quvideo.vivacut.editor.stage.common.ToolItemModel
"""
else
""
}
import com.quvideo.vivacut.editor.R


${fileHeader()}
@SuppressLint("ViewConstructor")
class Collage${stageClass}StageView(
  activity: FragmentActivity,
  stage: Stage
)  : BaseCollageStageView<Collage${stageClass}Controller>(activity, stage), ICollage${stageClass}Stage {

    ${if (generateToolProvider)
"""private lateinit var mRecyclerView: RecyclerView
   private lateinit var mAdapter: CommonToolAdapter"""
else
  ""
}

  override fun handleCustomViewCreated() {
    initController()
    initView()
  }

   override fun getLayoutId(): Int {
   ${if (generateToolProvider)
  """return R.layout.editor_common_stage_view_layout"""
  else
    "return R.layout.editor_empty_stage_layout"
    }
   }
    
   private fun initController() {
     val index = emitter?.effectIndex ?: -1
     val isSticker = emitter?.groupId == XYSdkConstants.GROUP_ID_STICKER
     mController = Collage${stageClass}Controller(index, engineService.effectAPI, this, isSticker)
   }

   private fun initView() {
     ${if (generateToolProvider)
  """mRecyclerView = this.findViewById(R.id.rc_view)
     mAdapter = CommonToolAdapter(context, false)
     mAdapter.setToolList(${stageClass}ToolProvider.getToolList())
     mAdapter.setListener(object : ToolCallback{
       override fun onToolSelected(
         position: Int,
         model: ToolItemModel?
       ) {
         
       }

       override fun onToolLongPress(
         position: Int,
         model: ToolItemModel?
       ) {
         
       }

     })
     mRecyclerView.layoutManager =
     LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
     mRecyclerView.adapter = mAdapter
     """
else
  ""
}   
   
   }


   override fun handleCustomRelease() {
     mController.release()
   }
   ${if (generateToolProvider)
  """override fun getContentRecyclerView(): RecyclerView {
        return mRecyclerView
     }"""
else
  ""
}

   override fun onUpdateRangeSuccess(effectDataModel: EffectDataModel?) {
    
   }

}

"""
