/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import Capsules.CapAgenda;
import Model.modAgenda;
import Vista.Menu;
import controllers.CTRlAgenda;

/**
 *
 * @author USUARIO
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException  {
 
            CapAgenda cap =new CapAgenda();
            Menu frm = new Menu();
            modAgenda moda =new modAgenda();
            CTRlAgenda ctrl=new CTRlAgenda(cap,frm,moda);
            ctrl.inicio();
            
            frm.setVisible(true);
      
    }
    
}
