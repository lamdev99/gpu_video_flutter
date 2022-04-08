package com.example.fl_plugin.sample;
import com.example.fl_plugin.egl.filter.GlFilter;

public interface FilterAdjuster {
    public void adjust(GlFilter filter, int percentage);
}
