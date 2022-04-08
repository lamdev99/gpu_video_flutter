package com.example.fl_plugin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import io.flutter.plugin.platform.PlatformView

class PlayerView(context: Context, id: Int, creationParams: Map<String?, Any?>?) : PlatformView {
    private  val view : View = LayoutInflater.from(context).inflate(R.layout.activity_player,null)
    override fun getView(): View {
        return view
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }
}