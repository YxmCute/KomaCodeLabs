package com.yxmcute.codelabs.jetpack.workmanager

import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.NetworkType.CONNECTED
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.yxmcute.codelabs.base.BaseBindingFragment
import com.yxmcute.codelabs.databinding.FragmentWorkManangerBinding
import java.time.Duration

/**
 * <pre>
 *     author : Koma
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/09/10 10:11
 *     desc   :
 *     link   :
 *     version: 1.0
 * </pre>
 */

class WorkManagerFragment : BaseBindingFragment<FragmentWorkManangerBinding>() {

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    val constraints = Constraints.Builder()
        .setRequiredNetworkType(CONNECTED)
        .setRequiresBatteryNotLow(false)
        .setRequiresCharging(true)
        .build()
    val oneTimeWorkRequest = OneTimeWorkRequestBuilder<ImageWorker>().setConstraints(constraints)
        .addTag("image")
        .build()

    viewBinding.tvSampleOneTime.setOnClickListener {

      WorkManager.getInstance(myContext)
          .enqueue(oneTimeWorkRequest)
    }
    WorkManager.getInstance(myContext)
        .getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
        .observe(viewLifecycleOwner, Observer { workInfo ->
          run {
            if (workInfo != null) {
              Log.i("timo", "workinfo state=${workInfo.state}")
              Log.i("timo", "workinfo progress=${workInfo.progress}")
            }
          }

        })
  }
}