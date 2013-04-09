/**
 * 
 */
package com.meituan.service.mobile.example.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meituan.service.mobile.example.model.Example;
import com.meituan.service.mobile.example.service.IExampleService;
import com.meituan.service.mobile.example.view.ExampleView;
import com.meituan.service.mobile.example.view.ResultView;

/**
 * 
 */
@Controller
@RequestMapping("/example")
public class ExampleController {

    Logger logger = Logger.getLogger(getClass());

    @Autowired
    IExampleService exampleService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/{did}")
    public ResultView get(@PathVariable String did) {
        Example example = exampleService.getOneExample(did);
        return new ResultView(new ExampleView(example));
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Object add(
            @RequestParam(value = "udid", required = false) String udid,
            @RequestParam("did") String did,
            @RequestParam("appnm") String appnm,
            @RequestParam("source") String source,
            @RequestParam(value = "verified", defaultValue = "0") int verified) {
        Example example = new Example();
        example.setActiveTime(new Date());
        example.setAppnm(appnm);
        example.setDid(did);
        example.setSource(source);
        example.setUdid(udid);
        example.setVerified(verified);
        exampleService.insert(example);
        return ResultView.OK;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Object update(@RequestParam("did") String did) {
        exampleService.update(did);
        return ResultView.OK;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public Object delete(@RequestParam("did") String did) {
        exampleService.delete(did);
        return ResultView.OK;
    }
}
