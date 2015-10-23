package com.github.demo.scopes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import com.github.demo.scopes.util.CommonController;

@ManagedBean
@RequestScoped
public class RequestController extends CommonController {

    private static final Logger LOG = Logger.getLogger(RequestController.class);

    public RequestController() {
        LOG.info(RequestController.class.getName() + "...");
    }
}
