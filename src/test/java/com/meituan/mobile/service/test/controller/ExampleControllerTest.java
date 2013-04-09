package com.meituan.mobile.service.test.controller;

import junit.framework.TestCase;

import com.meituan.mobile.service.test.MeituanBeanFactory;
import com.meituan.service.mobile.example.controller.ExampleController;
import com.meituan.service.mobile.example.view.ExampleView;
import com.meituan.service.mobile.example.view.ResultView;

public class ExampleControllerTest extends TestCase {

    public void testExampleGet() {
        ExampleController controller = MeituanBeanFactory
                .getBean(ExampleController.class);
        ResultView resultView = controller.get("didTest");
        ExampleView ev = (ExampleView) (resultView.getResponse());
        assertEquals("didTest", ev.getTheDid());
    }
}
