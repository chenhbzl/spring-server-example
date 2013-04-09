package com.meituan.service.mobile.example.view;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.meituan.service.mobile.example.model.Example;

public class ExampleView {
    Example delegate = null;

    public ExampleView(Example e) {
        delegate = e;
    }

    public String getTheDid() {
        return delegate.getDid();
    }

    public long getActiveTime() {
        return delegate.getActiveTime().getTime();
    }

    // 有这个annotion jackson将不渲染
    @JsonIgnore
    public long getComfireTime() {
        return delegate.getComfireTime().getTime();
    }

    public boolean isVerified() {
        return delegate.getVerified() != 0;
    }
}
