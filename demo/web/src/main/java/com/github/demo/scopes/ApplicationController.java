package com.github.demo.scopes;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.apache.log4j.Logger;

import com.github.demo.scopes.util.CommonController;

@ApplicationScoped
@ManagedBean
public class ApplicationController extends CommonController {

    private static final Logger LOG = Logger.getLogger(ApplicationController.class);

    public ApplicationController() {
        LOG.info(ApplicationController.class.getName() + "...");
    }
}
