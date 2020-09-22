/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

/**
 *
 * @author hp
 */
public class splashhh {
    
    public static void main(String[] args){
        splashScreen Splash=new splashScreen();
        RegisterAndLogin r=new RegisterAndLogin();
        //Homepage h=new Homepage();
        Splash.setVisible(true);
        
        try{
            
               for(int i=0;i<=100;i++)
                { 
                    Thread.sleep(40);
                  Splash.loadingNumber.setText(Integer.toString(i)+"%");
                  Splash.ProgressBar.setValue(i);
                  if(i==100)
                  {   
                      Splash.setVisible(false);
                      r.setVisible(true);
                      
                  
                  }
                  else
                  {}
                
                }
               }
               catch(Exception e){
               }
        
        
    }
    
}
