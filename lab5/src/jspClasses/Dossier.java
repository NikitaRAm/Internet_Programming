package jspClasses;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

import static java.lang.String.format;

public class Dossier extends TagSupport {
    private String action = "";

    public String getAction(){
        return this.action;
    }
    public void setAction(final String action){
        this.action=action;
    }

    public int doStartTag() {
        final String in = format("<form id=\"f-1\" name=\"f01\" method=\"post\" action= \"%s\">", action);
        final JspWriter out = pageContext.getOut();
        try {
            out.print(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() {
        JspWriter out= pageContext.getOut();
        try{
            out.print("</form>");
        }
        catch(IOException ignored){
        }
        return EVAL_BODY_INCLUDE;
    }
}
