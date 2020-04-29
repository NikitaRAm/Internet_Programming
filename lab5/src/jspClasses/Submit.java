package jspClasses;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Submit extends TagSupport {
    private String value;

    public void setValue(final String value)
    {
        this.value = value;
    }
    public String getValue()
    {
        return this.value;
    }

    public int doStartTag() {
        final JspWriter out = pageContext.getOut();
        try {
            out.println("<input type=\"submit\" name=\"press\" value=\"OK\" size=\"20\"><input type=\"submit\" name=\"press\" value=\"Cancel\" size=\"20\">");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
