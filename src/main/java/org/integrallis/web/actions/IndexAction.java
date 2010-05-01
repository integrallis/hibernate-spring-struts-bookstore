package org.integrallis.web.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;

@SuppressWarnings("serial")
@Conversion()
public class IndexAction extends ActionSupport {
    
    public String execute() throws Exception {
        return SUCCESS;
    }
}
