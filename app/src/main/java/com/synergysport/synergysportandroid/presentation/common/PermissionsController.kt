package com.synergysport.synergysportandroid.presentation.common

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import javax.inject.Inject

interface PermissionsController {
    fun getUnacceptedPermissions(): Array<String>
}

class PermissionControllerImpl @Inject constructor(
    private val applicationContext: Context
) : PermissionsController {

    private val requiredPermissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        arrayOf(
            Manifest.permission.ACTIVITY_RECOGNITION,
        )
    } else {
        arrayOf()
    }

    override fun getUnacceptedPermissions() = requiredPermissions.filter {
        ContextCompat.checkSelfPermission(
            applicationContext,
            it
        ) != PackageManager.PERMISSION_GRANTED
    }.toTypedArray()
}