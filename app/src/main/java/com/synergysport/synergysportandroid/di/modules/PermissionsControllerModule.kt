package com.synergysport.synergysportandroid.di.modules

import com.synergysport.synergysportandroid.presentation.common.PermissionControllerImpl
import com.synergysport.synergysportandroid.presentation.common.PermissionsController
import dagger.Binds
import dagger.Module

@Module
abstract class PermissionsControllerModule {
    @Binds
    abstract fun providePermissionsController(permissionsController: PermissionControllerImpl): PermissionsController
}