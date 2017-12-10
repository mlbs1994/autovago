/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Matheus Levi
 */
public class FileUploadBean 
{
    
    String imgSrc="";
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
    
    public void uploadAction(FileUploadEvent event)
    {
        this.imgSrc = event.getFile().getFileName();
    }
    
    public void testar()
    {
        System.out.println("ImgSrc = "+imgSrc);
    }
}
