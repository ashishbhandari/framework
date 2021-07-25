package com.example.colourmemory

import com.example.core.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun getContentViewId(): Int = R.layout.main_activity
}