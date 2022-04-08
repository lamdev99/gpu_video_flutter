package com.example.fl_plugin

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.fl_plugin.egl.filter.GlFilter
import com.example.fl_plugin.player.GPUPlayerView
import com.example.fl_plugin.sample.FilterAdjuster
import com.example.fl_plugin.sample.FilterType
import com.example.fl_plugin.sample.widget.MovieWrapperView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import io.flutter.plugin.platform.PlatformView


internal class NativeView(
    context: Context,
    id: Int,
    creationParams: Map<String?, Any?>?,
) :
    PlatformView {
    private var player: SimpleExoPlayer? = null
    private var gpuPlayerView: GPUPlayerView = GPUPlayerView(context)
    private val movieWrapperView = MovieWrapperView(context)
    private var filter: GlFilter? = null
    private var adjuster: FilterAdjuster? = null
    override fun getView(): View {
        return movieWrapperView
    }

    override fun dispose() {
        gpuPlayerView.onPause()
        movieWrapperView.removeAllViews()
        player!!.stop()
        player!!.release()
        player = null
    }

    init {
        creationParams?.let { params ->
            val position: Int = params["position"] as Int
            val videoUrl: String = params["videoUrl"] as String
            val filterProgress: Int = params["filterProgress"] as Int
            // SimpleExoPlayer
            player = SimpleExoPlayer.Builder(context)
                .setTrackSelector(DefaultTrackSelector(context))
                .build()

            player!!.addMediaItem(MediaItem.fromUri(Uri.parse(videoUrl)))
            player!!.prepare()
            player!!.playWhenReady = true
            gpuPlayerView.setSimpleExoPlayer(player)
            gpuPlayerView.layoutParams = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            val filterTypes = FilterType.createFilterList()
            filter = FilterType.createGlFilter(filterTypes[position], context)
            adjuster = FilterType.createFilterAdjuster(filterTypes[position])
            adjuster?.adjust(filter,filterProgress)
            gpuPlayerView.setGlFilter(filter)
            movieWrapperView.setBackgroundColor(Color.CYAN)
            movieWrapperView.addView(gpuPlayerView)
            gpuPlayerView.onResume()
        }
    }
}
