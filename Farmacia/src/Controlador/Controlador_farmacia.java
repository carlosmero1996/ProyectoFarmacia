/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Vista_Farmacia;
import Modelo.Clase_Farmacia;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.Validaciones;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author carlos
 */
public class Controlador_farmacia {
    
    private Vista_Farmacia vis_farmacia;
    private Clase_Farmacia class_farmacia;
    DefaultTableModel modelotabla;
    private Validaciones validar;
    int count = 0;
    
    public Controlador_farmacia() {
    }
    
    public Controlador_farmacia(Vista_Farmacia vis_farmacia) {
        this.vis_farmacia = vis_farmacia;
        vis_farmacia.setVisible(true);
        vis_farmacia.getText_pedido().disable();
    }
    
    public void iniciar_control() {
        vis_farmacia.setLocationRelativeTo(null);
        vis_farmacia.getBtn_guardar().addActionListener(l -> abrirdialogo());
        vis_farmacia.getBtn_confirmar().addActionListener(l -> confirmar());
        vis_farmacia.getBtn_cancelar().addActionListener(l -> cancelar());
        
        vis_farmacia.getTxt_nomb_medi().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (vis_farmacia.getTxt_nomb_medi().getText().length() == 20 || ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))) {
                    e.consume();
                }
            }
        });
        vis_farmacia.getTxt_cantidad().addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (vis_farmacia.getTxt_cantidad().getText().length() == 5 || (caracter < '0') || (caracter > '9')) {
                    e.consume();
                }
                
            }
            
        });
        
    }
    
    public void abrirdialogo() {
        if (vis_farmacia.getTxt_nomb_medi().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vis_farmacia, "El nombre del medicamento esta vacio");
        } else {
            if (vis_farmacia.getCombo_medicamento().getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(vis_farmacia, "seleccione un tipo de medicamento");
                
            } else {
                if (vis_farmacia.getTxt_cantidad().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vis_farmacia, "la cantidad del medicamento esta vacia");
                } else {
                    if (vis_farmacia.getRadio_cmefar().isSelected() == false && vis_farmacia.getRadio_cofarma().isSelected() == false && vis_farmacia.getRadio_empsephar().isSelected() == false) {
                        JOptionPane.showMessageDialog(vis_farmacia, "Seleccione una distribuidora");
                        
                    } else {
                        if (vis_farmacia.getCheack_principal().isSelected() == false && vis_farmacia.getCheck_sucursal().isSelected() == false) {
                            JOptionPane.showMessageDialog(vis_farmacia, "Seleccione una"
                                    + " farmacia");
                        } else {
                            if (vis_farmacia.getCheack_principal().isSelected() && vis_farmacia.getCheck_sucursal().isSelected()) {
                                JOptionPane.showMessageDialog(vis_farmacia, "Solo puede seleccionar una farmacia");
                            } else {
                                String titulo;
                                if (vis_farmacia.getRadio_cmefar().isSelected()) {
                                    
                                    titulo = "CEMEFAR";
                                    vis_farmacia.getLabe_titulo().setText(titulo);
                                    vis_farmacia.getDialog_informacion().setVisible(true);
                                    vis_farmacia.getDialog_informacion().setSize(500, 400);
                                    vis_farmacia.getDialog_informacion().setLocationRelativeTo(vis_farmacia);
                                    llenardatos();
                                    
                                } else {
                                    if (vis_farmacia.getRadio_cofarma().isSelected()) {
                                        titulo = "COFARMA";
                                        vis_farmacia.getLabe_titulo().setText(titulo);
                                        vis_farmacia.getDialog_informacion().setVisible(true);
                                        vis_farmacia.getDialog_informacion().setSize(500, 400);
                                        vis_farmacia.getDialog_informacion().setLocationRelativeTo(vis_farmacia);
                                        llenardatos();
                                        
                                    } else {
                                        if (vis_farmacia.getRadio_empsephar().isSelected()) {
                                            titulo = "EMPSEPHAR ";
                                            vis_farmacia.getLabe_titulo().setText(titulo);
                                            vis_farmacia.getDialog_informacion().setVisible(true);
                                            vis_farmacia.getDialog_informacion().setSize(500, 400);
                                            vis_farmacia.getDialog_informacion().setLocationRelativeTo(vis_farmacia);
                                            llenardatos();
                                            
                                        }
                                    }
                                    
                                }
                                
                            }
                        }
                    }
                }
            }
            
        }
    }
    
    public void llenardatos() {
        
        String distribuidora = "";
        String nomb = vis_farmacia.getTxt_nomb_medi().getText();
        String cant = vis_farmacia.getTxt_cantidad().getText();
        String tipo = vis_farmacia.getCombo_medicamento().getSelectedItem().toString();
        
        String direccion;
        if (vis_farmacia.getCheack_principal().isSelected()) {
            direccion = "Calle de la Rosa n. 28";
        } else {
            direccion = "Calle Alcazabilla n. 3";
        }
        
        vis_farmacia.getText_pedido().setText("se realiza un pedido de " + nomb + " \n"
                + "se requieren " + cant + " unidades,\n las medicinas corresponden "
                + "al tipo \n de medicamento " + tipo + " ");
        vis_farmacia.getLabel_direccion().setText(direccion);
        
    }
    
    public void llenartabla() {
        
        String distribuidora1 = "";
        String direccion1;
        String nomb1 = vis_farmacia.getTxt_nomb_medi().getText();
        String cant1 = vis_farmacia.getTxt_cantidad().getText();
        String tipo1 = vis_farmacia.getCombo_medicamento().getSelectedItem().toString();
        if (vis_farmacia.getRadio_cmefar().isSelected()) {
            distribuidora1 = "CEMEFAR";
        } else {
            if (vis_farmacia.getRadio_cofarma().isSelected()) {
                distribuidora1 = "COFARMA";
            } else {
                if (vis_farmacia.getRadio_empsephar().isSelected()) {
                    distribuidora1 = "EMPSEPHAR ";
                }
            }
        }
        if (vis_farmacia.getCheack_principal().isSelected()) {
            direccion1 = "Calle de la Rosa n. 28";
        } else {
            direccion1 = "Calle Alcazabilla n. 3";
        }
        
        modelotabla = (DefaultTableModel) vis_farmacia.getTabla_farmacia().getModel();
        Object[] fila = new Object[5];
        fila[0] = nomb1;
        fila[1] = tipo1;
        fila[2] = cant1;
        fila[3] = distribuidora1;
        fila[4] = direccion1;
        
        modelotabla.addRow(fila);
        vis_farmacia.getTabla_farmacia().setModel(modelotabla);
        
        count = count + Integer.valueOf(cant1);
        vis_farmacia.getLblcount().setText(String.valueOf(count));
        
    }
    
    public void limpiar() {
        vis_farmacia.getTxt_nomb_medi().setText("");
        vis_farmacia.getTxt_cantidad().setText("");
        vis_farmacia.getCombo_medicamento().setSelectedIndex(0);
        vis_farmacia.getGrupo_distribuidora().clearSelection();
        vis_farmacia.getCheack_principal().setSelected(false);
        vis_farmacia.getCheck_sucursal().setSelected(false);
    }
    
    public void confirmar() {
        int respuesta = JOptionPane.showConfirmDialog(vis_farmacia, "Seguro Desea enviar el pedido?");
        if (respuesta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(vis_farmacia, "Pedido Enviado");
            vis_farmacia.getDialog_informacion().dispose();
            llenartabla();
            limpiar();
        }
        
    }
    
    public void cancelar() {
        int respuesta = JOptionPane.showConfirmDialog(vis_farmacia, "Seguro Desea cancelar el pedido?");
        if (respuesta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(vis_farmacia, "Pedido cancelado");
            vis_farmacia.getDialog_informacion().dispose();
        }
        
    }
    
}
