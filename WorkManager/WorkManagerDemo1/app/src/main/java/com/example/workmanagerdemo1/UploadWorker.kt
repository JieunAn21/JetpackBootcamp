package com.example.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        return try {
            for (i in 0..600) {
                Log.i("MYTAG", "Uploading $i")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}