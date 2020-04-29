package jspClasses;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Surname extends TagSupport {
    static String in = "<label>Surname&nbsp &nbsp</label><input name =\"first_name\" type= \"text\"width= \"15-	\"maxlength=\"30\" ";
    public String value = "";

    public String getValue() {
        return value;
    }
    public void setValue(final String value) {
        this.value = value;
    }

    public int doStartTag() {
        final JspWriter out = pageContext.getOut();
        try {
            out.print(in + (this.value.isEmpty() ? " " : "value=\"" + this.value + "\" />"));
        }
        catch (IOException e){
        }
        return SKIP_BODY;
    }
}
