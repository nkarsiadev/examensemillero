package com.example.demo.functions;
import java.util.ArrayList;
import com.example.demo.models.UserModel;

public class CompararCredenciales {
    private int aux=0;
    public int getAux() {
        return aux;
    }
    public void setAux(int aux) {
        this.aux = aux;
    }

    public boolean Comparar (UserModel user,ArrayList<UserModel> Lista){
        
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).getPassword() == user.getPassword()) {
                aux++;
            }else if (user.getUser()==null){
                aux++;
            }
        }
        if (aux==0) {
            return true;
        }else{
            return false;
        }
    }
    
    
}
