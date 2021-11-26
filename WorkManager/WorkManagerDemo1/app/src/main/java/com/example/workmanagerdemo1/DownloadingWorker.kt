package com.example.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class DownloadingWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        return try {
            for (i in 0..3000) {
                Log.i("MYTAG", "Downloading $i")
            }

            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}