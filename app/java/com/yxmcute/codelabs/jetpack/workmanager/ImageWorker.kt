package com.yxmcute.codelabs.jetpack.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * <pre>
 *     author : LiJun
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/09/10 14:54
 *     desc   :
 *     link   :
 *     version: 1.0
 * </pre>
 */
class ImageWorker(
  context: Context,
  val workerParameters: WorkerParameters
) : Worker(context, workerParameters) {
  override fun doWork(): Result {

    val data = workerParameters.inputData

    return Result.success()
  }
}