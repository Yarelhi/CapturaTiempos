package Beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@SessionScoped
public class FileUploadControl_1 {
    
    private String destination="C:\\Users\\ÁNGEL\\Documents\\NetBeansProjects\\CapturaTiempos\\Plan de trabajo";
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    /**
     * Creates a new instance of FileUploadControl
     */
    public FileUploadControl_1() {
    }
    
    public void TransferFile(String fileName, InputStream in){
        try{
            try (OutputStream out = new FileOutputStream(new File(destination = fileName))) {
                int reader = 0;
                byte[] bytes = new byte [(int)getFile().getSize()];
                while ((reader = in.read(bytes)) != -1){
                    out.write(bytes, 0, reader);
                }
                in.close();
                out.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void upload(){
        String extValidate;
        //Valida que se haya recibido
        if(getFile() != null){
            //Se captura la extension del archivo
            String ext=getFile().getFileName();
            if(ext != null){
                extValidate=ext.substring(ext.indexOf(".")+1);
            } else {
                extValidate="null";
            }
            
            //Se compara para que iguale a pdf
            if(extValidate.equals("pdf")){
                  
                //msj de exito
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Realizado", getFile().getFileName()+ " Archivo subido "+ getFile().getContentType()+"tamaño"+getFile().getSize()));
            }
            //Si no es pdf
            else{
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Error con la extensión","sólo extensiónn .pdf"));
            }
        }
        //De lo contrario
        else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Alerta", "selecciona un archivo!!!"));
        }
    }
}
