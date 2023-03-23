package sv.edu.utec.recicleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Elementos extends RecyclerView.ViewHolder {//ViewHolder permite poner una clase sobre otra
    static ImageView imgPersona;
    static TextView tvPersona, tvCompa,  tvCargo;


    public Elementos(@NonNull View itemView) {
        super(itemView);

        imgPersona = itemView.findViewById(R.id.imgPersona);
        tvPersona = itemView.findViewById(R.id.txvN);
        tvCompa = itemView.findViewById(R.id.txvCom);
        tvCargo = itemView.findViewById(R.id.txvC);
    }

}

