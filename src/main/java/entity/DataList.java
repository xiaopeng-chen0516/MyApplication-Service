package entity;

/**
 * @author jinpeng_chen
 * @create 2020-03-01 下午 5:55
 **/

public class DataList {
    public int id;
    public double O2;
    public double CO2;

    public DataList(int id, double o2, double CO2) {
        this.id = id;
        O2 = o2;
        this.CO2 = CO2;
    }

    public DataList() {
    }

    @Override
    public String toString() {
        return "dataList{" +
                "id=" + id +
                ", O2=" + O2 +
                ", CO2=" + CO2 +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getO2() {
        return O2;
    }

    public void setO2(double o2) {
        O2 = o2;
    }

    public double getCO2() {
        return CO2;
    }

    public void setCO2(double CO2) {
        this.CO2 = CO2;
    }


}
