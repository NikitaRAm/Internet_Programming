package jspClasses;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

import static java.lang.String.format;

public class Sex extends TagSupport {
    private String radioButton1 = "<input type=\"radio\" name=\"sex\" value=\"male\" checked=\"checked\">male";
    private String radioButton2 = "<input type=\"radio\" name=\"sex\" value=\"female\" checked=\"checked\">female";

    public int doStartTag() {
        final JspWriter out = pageContext.getOut();
        try {
            out.print(format("%s<br>%s", radioButton1, radioButton2));
        } catch (IOException e) {
        }
        return SKIP_BODY;
    }
}
