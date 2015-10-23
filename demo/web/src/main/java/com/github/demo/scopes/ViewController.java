package com.github.demo.scopes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.github.demo.scopes.util.CommonController;

@ViewScoped
@ManagedBean
public class ViewController extends CommonController {

    private static final Logger LOG = Logger.getLogger(ViewController.class);

    public ViewController() {
        LOG.info(ViewController.class.getName() + "...");
    }
}
