/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Capsules.CapAgenda;
import Model.modAgenda;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class CTRlAgenda implements ActionListener {//que escuche

    private final CapAgenda agenda;//datos que voy acapturar
    private final Menu frm;//vista
    private final modAgenda moda; //BD

    /**
     *
     * @param agenda
     * @param fr
     */
    public CTRlAgenda(CapAgenda agenda, Menu frm, modAgenda moda) {
        this.agenda = agenda;
        this.frm = frm;
        this.moda = moda;
        this.frm.btnEditar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btncancelar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btncancelar.addActionListener(this);
        this.frm.btncancelar1.addActionListener(this);
        this.frm.btnSalir.addActionListener(this);
        this.frm.btnLimpiar1.addActionListener(this);
        this.frm.btnContactos.addActionListener(this);
        this.frm.btnInicio.addActionListener(this);
        this.frm.btnAgregarAmigo.addActionListener(this);
        this.frm.txtDoc.addActionListener(this);
        this.frm.f8.addActionListener(this);

        this.frm.tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
    }

//funcione que voy a utiliza :o
//inici
    public void inicio() {
        try {

            frm.panelbt2.setVisible(false);

            frm.panelbt3.setVisible(false);

            frm.panel.setVisible(true);
            cancelar();
            frm.setTitle("Agenda");
            Modificartabla("");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CTRlAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cancelar() {
        this.frm.txtCorreo.setEnabled(false);
        this.frm.txtDireccion.setEnabled(false);
        this.frm.txtNombre.setEnabled(false);
        this.frm.txtTelefono.setEnabled(false);
        this.frm.btnGuardar.setEnabled(false);
        this.frm.btnLimpiar.setEnabled(true);
        this.frm.btncancelar.setEnabled(false);
        this.frm.btnEliminar.setEnabled(false);
        this.frm.btnEditar.setEnabled(false);
        this.frm.f2.setEnabled(false);
        this.frm.f1.setEnabled(false);
        this.frm.f3.setEnabled(false);
        this.frm.f4.setEnabled(false);
        this.frm.f8.setEnabled(false);
        this.frm.txtbuscar.setEnabled(true);
        this.frm.btnLimpiar1.setEnabled(true);
        this.frm.btncancelar.setEnabled(false);
        this.frm.txtDoc.setEnabled(false);
    }

    public void limpiar() {

        this.frm.btnGuardar.setEnabled(true);
        this.frm.btncancelar.setEnabled(true);
        this.frm.btnLimpiar.setEnabled(false);
        this.frm.btncancelar.setEnabled(true);
        this.frm.txtCorreo.setEnabled(true);
        this.frm.txtDireccion.setEnabled(true);
        this.frm.txtNombre.setEnabled(true);
        this.frm.txtTelefono.setEnabled(true);
        this.frm.txtbuscar.setEnabled(true);
        this.frm.btnBuscar.setEnabled(true);
        this.frm.txtCorreo.setText("");
        this.frm.txtDireccion.setText("");
        this.frm.txtNombre.setText("");
        this.frm.txtTelefono.setText("");
        this.frm.txtbuscar.setText("");
        this.frm.txtDoc.setEnabled(true);
        this.frm.txtDoc.setText("");
    }

    public void limpiarpaneldos() {
        this.frm.txtbuscar.setEnabled(true);
        this.frm.btncancelar1.setEnabled(true);
        this.frm.btnEliminar.setEnabled(true);
        this.frm.btnLimpiar1.setEnabled(false);
        this.frm.btnEditar.setEnabled(true);
        this.frm.btnBuscar.setEnabled(true);
        this.frm.f1.setEnabled(true);
        this.frm.f2.setEnabled(true);
        this.frm.f3.setEnabled(true);
        this.frm.f3.setEnabled(true);
        this.frm.f4.setEnabled(true);
        this.frm.f8.setEnabled(false);
        this.frm.f1.setText("");
        this.frm.f2.setText("");
        this.frm.f3.setText("");
        this.frm.f4.setText("");
        this.frm.f8.setText("");
        this.frm.f8.setEnabled(false);
        this.frm.txtbuscar.setText("");
    }

    public void buscar() {
        this.frm.btnGuardar.setEnabled(true);

        this.frm.btncancelar1.setEnabled(true);
        this.frm.btnLimpiar.setEnabled(false);
        this.frm.btnLimpiar1.setEnabled(false);
        this.frm.btnBuscar.setEnabled(true);
        this.frm.btnEliminar.setEnabled(true);
        this.frm.btnEditar.setEnabled(true);
        this.frm.txtCorreo.setEnabled(false);
        this.frm.txtDireccion.setEnabled(false);
        this.frm.txtNombre.setEnabled(false);
        this.frm.txtTelefono.setEnabled(false);
        this.frm.txtbuscar.setEnabled(false);
        this.frm.f1.setEnabled(false);
        this.frm.f2.setEnabled(false);
        this.frm.f3.setEnabled(false);
        this.frm.f3.setEnabled(false);
        this.frm.f4.setEnabled(false);
        this.frm.f8.setEnabled(false);
    }

    void Modificartabla(String atributo) throws ClassNotFoundException {

        frm.tabla.setModel(moda.MostrarAmigos(atributo));

    }

    void tablaMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = frm.tabla.rowAtPoint(evt.getPoint());
        limpiarpaneldos();
        frm.f1.setText(frm.tabla.getValueAt(fila, 1).toString());
        frm.f2.setText(frm.tabla.getValueAt(fila, 2).toString());
        frm.f3.setText(frm.tabla.getValueAt(fila, 3).toString());
        frm.f4.setText(frm.tabla.getValueAt(fila, 4).toString());
        frm.f8.setText(frm.tabla.getValueAt(fila, 0).toString());
    }

    @Override//no borar clase abstracta
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(frm.btnSalir)) {
            frm.dispose();

        }
        if (e.getSource().equals(frm.btnLimpiar)) {

            limpiar();

        }
        if (e.getSource().equals(frm.btnInicio)) {

            frm.panelbt2.setVisible(false);
            frm.panelbt3.setVisible(false);
            cancelar();
            frm.panel.setVisible(true);

        }
        if (e.getSource().equals(frm.btnAgregarAmigo)) {
            cancelar();

            frm.panelbt2.setVisible(true);
            frm.panelbt3.setVisible(false);
            frm.panel.setVisible(false);

        }
        if (e.getSource().equals(frm.btnContactos)) {
            cancelar();

            frm.panelbt2.setVisible(false);
            frm.panelbt3.setVisible(true);

            frm.panel.setVisible(false);

        }
        if (e.getSource().equals(frm.btnLimpiar1)) {

            limpiarpaneldos();

        }
        if (e.getSource().equals(frm.btncancelar)) {

            cancelar();
        }
        if (e.getSource().equals(frm.btncancelar1)) {

            cancelar();

        }

        if (e.getSource().equals(frm.btnBuscar)) {

            try {
                Modificartabla(frm.txtbuscar.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CTRlAgenda.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource().equals(frm.btnGuardar)) {

            agenda.setTELEFONO(Long.parseLong(frm.txtTelefono.getText()));
            agenda.setNOMBRE(frm.txtNombre.getText());
            agenda.setCORREO(frm.txtCorreo.getText());
            agenda.setDIRECCION(frm.txtDireccion.getText());
            agenda.setDOCUEMTO(Long.parseLong(frm.txtDoc.getText()));

            if (moda.RegistrarAmigo(agenda)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
                try {
                    Modificartabla("");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CTRlAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
               
            }
        }
        if (e.getSource().equals(frm.btnEditar)) {
            agenda.setTELEFONO(Long.parseLong(frm.f1.getText()));
            agenda.setNOMBRE(frm.f2.getText());
            agenda.setCORREO(frm.f3.getText());
            agenda.setDIRECCION(frm.f4.getText());
            agenda.setDOCUEMTO(Long.parseLong(frm.f8.getText()));

            if (moda.Modificar(agenda)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiarpaneldos();
                try {
                    Modificartabla("");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CTRlAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiarpaneldos();
            }
        }
        if (e.getSource().equals(frm.btnEliminar)) {
            agenda.setDOCUEMTO(Long.parseLong(frm.f8.getText()));

            if (moda.borrarAmigo(agenda)) {
                JOptionPane.showMessageDialog(null, "Amigo eliminado de agenda ");
                limpiarpaneldos();
                try {
                    Modificartabla("");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CTRlAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                JOptionPane.showMessageDialog(null, "Amigo eliminado de agenda ");
                limpiarpaneldos();
            }
        }

    }

}
