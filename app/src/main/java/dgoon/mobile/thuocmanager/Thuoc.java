package dgoon.mobile.thuocmanager;

public class Thuoc {
    String ten, tenkhoahoc, dactinh, maula, congdung, duoctinh, chuy, img;

    Thuoc() {

    }

    public Thuoc(String ten, String tenkhoahoc, String dactinh, String maula, String congdung, String duoctinh, String chuy, String img) {
        this.ten = ten;
        this.tenkhoahoc = tenkhoahoc;
        this.dactinh = dactinh;
        this.maula = maula;
        this.congdung = congdung;
        this.duoctinh = duoctinh;
        this.chuy = chuy;
        this.img = img;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public String getMaula() {
        return maula;
    }

    public void setMaula(String maula) {
        this.maula = maula;
    }

    public String getCongdung() {
        return congdung;
    }

    public void setCongdung(String congdung) {
        this.congdung = congdung;
    }

    public String getDuoctinh() {
        return duoctinh;
    }

    public void setDuoctinh(String duoctinh) {
        this.duoctinh = duoctinh;
    }

    public String getChuy() {
        return chuy;
    }

    public void setChuy(String chuy) {
        this.chuy = chuy;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
