package com.example.fl_plugin.sample.compose;

import java.util.List;

public interface VideoLoadListener {

    void onVideoLoaded(List<VideoItem> videoItems);

    void onFailed(Exception e);
}
