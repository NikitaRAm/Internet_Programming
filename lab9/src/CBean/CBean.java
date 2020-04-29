package CBean;

public class CBean {
    private String Value1 = null;
    private String Value2 = null;
    private String Value3 = null;

    public CBean(String Value1, String Value2, String Value3) {
        this.Value1 = Value1;
        this.Value2 = Value2;
        this.Value3 = Value3;
    }
    public String GetValue1() {
        return (this.Value1);
    }
    public void SetValue1(String Value1) {
        this.Value1 = Value1;
    }
    public String GetValue2() {
        return (this.Value2);
    }
    public void SetValue2(String Value2) {
        this.Value2 = Value2;
    }
    public String GetValue3() {
        return (this.Value3);
    }
    public void SetValue3(String Value3) {
        this.Value3 = Value3;
    }
}
