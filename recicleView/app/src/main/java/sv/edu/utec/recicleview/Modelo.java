package sv.edu.utec.recicleview;

import android.graphics.drawable.Drawable;

public class Modelo {

    private String NombrePersona;
    private String Cargo;
    private String Compania;

    private int ImgPersona;

    public String getNombrePersona() {
        return NombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        NombrePersona = nombrePersona;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getCompania() {
        return Compania;
    }

    public void setCompania(String compania) {
        Compania = compania;
    }

    public int getImgPersona() {
        return ImgPersona;
    }

    public void setImgPersona(int imgPersona) {
        ImgPersona = imgPersona;
    }


}

