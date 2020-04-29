package jspClasses;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Lastname extends TagSupport {
    private final String in = "<label>Last name&nbsp &nbsp</label><input name =\"last_name\" type= \"text\"width= \"15- \"maxlength=\"30\" ";
    private String value = "";

    public String getValue() {
        return value;
    }
    public void setValue(final String value) {
        this.value = value;
    }

    public int doStartTag() {
        final JspWriter out = pageContext.getOut();
        try {
            out.print(in + (this.value.equals("") ? " " : "value=\"" + this.value + "\" />"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
