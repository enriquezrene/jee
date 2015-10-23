package com.github.demo.scopes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.github.demo.scopes.util.CommonController;

@SessionScoped
@ManagedBean
public class SessionController extends CommonController {

    private static final Logger LOG = Logger.getLogger(SessionController.class);

    public SessionController() {
        LOG.info(SessionController.class.getName() + "...");
    }
}
