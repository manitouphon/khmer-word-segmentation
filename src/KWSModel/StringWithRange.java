package KWSModel;

public class StringWithRange {
    private String value;
    private int startPoint;
    private int endPoint;


    public StringWithRange(String string, int start, int end){
        value = string;
        this.startPoint = start;
        this.endPoint = end;
    }


    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public String getValue() {
        return value;
    }



    public void setStartPoint(int id) {
        this.startPoint = id;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    public void setValue(String main) {
        this.value = main;
    }
}
