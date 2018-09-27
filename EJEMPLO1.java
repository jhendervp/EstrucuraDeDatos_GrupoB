package ejemplo1;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class EJEMPLO1 {
    public static boolean EsMUltiploDeSiete(int p_nEdadEstudiante){
        boolean bValorRetorno=false;
        if (p_nEdadEstudiante==0) {
            bValorRetorno=false;
        }else{
            if (p_nEdadEstudiante % 7 ==0) {
                bValorRetorno=true; 
            }   
        }
       return bValorRetorno;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        int nNumeroEstudiante=0;
       nNumeroEstudiante= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de estudiante: "));
       int nEdadMayor=0;
       String sListaMensaje=null;
       int nEdadMenor=999;
       double nPromedio=0;
       int nSumaEdades=0;
       
               
       ///Iniiciar el arreglo de edades de estudiantes
       int[] edades = new int[nNumeroEstudiante];
       String[] nombres = new String[nNumeroEstudiante];
        int[] edadesMultiplodeSiete= new int [nNumeroEstudiante];
        int [] nPosicionMultiplodeSiete =new int[nNumeroEstudiante];
        int j=0;
        ///////// Si se pone <=, se aumentaria un ciclo por estar inicializado en 0
        for (int i = 0; i < edades.length; i++) {
            ///Almacenando edades y nombre
            edades[i]=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nota del estudiante: " +(i+1)+"\n"));
            nombres[i] =JOptionPane.showInputDialog("Ingrese el nombre del estudiante: " +(i+1)+"\n");

            //Evaluacion mayor
            if(edades[i]<=nEdadMenor){
                nEdadMenor=edades[i]; 
            }
            //Evaluacion Menor  
            if(edades[i]>=nEdadMayor) {
                nEdadMayor=edades[i];
            }
            //Evaluamos si el valor del arreglo es multiplo de 7
            
                if ( EsMUltiploDeSiete(edades[i]) ) {
                    //////////////////  0----1       1----3    // 0---14   1----21
                    nPosicionMultiplodeSiete[j]= i;
                    edadesMultiplodeSiete[j]=edades[i];
                    j++;
                    /////////////
                }
            nSumaEdades=nSumaEdades+edades[i];   
        }
            // convertimos a double 
             nPromedio= Double.valueOf(nSumaEdades) / Double.valueOf(nNumeroEstudiante);
             
            sListaMensaje="La lista de Estudiante es : \n"; 
             //Impresion
            for (int i = 0; i < nombres.length; i++) {
                sListaMensaje=sListaMensaje+""+(i+1)+" ° ===> "+nombres[i]+"  Nota: " +edades[i]+" \n";
        }
            sListaMensaje=sListaMensaje+"La nota Mayor del Estudiante es : "+nEdadMayor+"\n ";
            sListaMensaje=sListaMensaje+"La nota Menor del Estudiante es: " +nEdadMenor+"\n ";
            sListaMensaje=sListaMensaje+"El promedio del Estudiante es: "+nPromedio+"\n";
            sListaMensaje=sListaMensaje+"\tLas Notas multiplo de 7:  \n";
            
            for (int i = 0; i < edadesMultiplodeSiete.length; i++) {
                if(edadesMultiplodeSiete[i]>0){
                    ////////////
                 sListaMensaje+=""+(i+1)+"° ===> "+nombres[nPosicionMultiplodeSiete[i]]+"  Nota: " +edades[nPosicionMultiplodeSiete[i]]+"\n " ;
                }
                
            }
             JOptionPane.showMessageDialog(null,sListaMensaje);
             //------------------------------------------
             
             /*Object ordenamiento = JOptionPane.showInputDialog(null,"Seleccione un tipo de ordenamiento",
             "TIPO", JOptionPane.QUESTION_MESSAGE, null,
            new Object[] { "Seleccione","Burbuja", "Shell", "Hashing" },"Seleccione");*/
             //JCheckBox chec=new JCheckBox("Prueba");
       
            int seleccion = JOptionPane.showOptionDialog( null,"Seleccione un tipo de Ordenamiento",
            "Ordenamiento",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,
            new Object[] { "Burbuja", "Shell", "Hashing"},"Burbuja");
            if (seleccion == 0){
                      System.out.println("Seleccionada opcion " + (seleccion + 1));
                      String mensaje= burbuja (edades);
                      JOptionPane.showMessageDialog(null,mensaje);
            }
            if(seleccion==1){
                System.out.println("Seleccionada opcion " + (seleccion + 1));
                String mensaje= shell(edades);
                JOptionPane.showMessageDialog(null,mensaje);
            }
             
    }
        public static String burbuja( int arreglo[]){
            int aux;
            String mensaje="Notas Ordenadas con Burbuja \n";
            for(int i=0;i<arreglo.length;i++){
                for(int j=0;j<arreglo.length-1;j++){
                    if(arreglo[j]>arreglo[j+1]){
                        aux=arreglo[j];
                        arreglo[j]=arreglo[j+1];
                        arreglo[j+1]=aux;
                    }
                }
                
            }
            //IMMPRIME
            for (int i = 0; i < arreglo.length; i++) {
                 mensaje=mensaje +arreglo[i] +" -";
            }
            
            return mensaje;
        }
        public static String shell(int arreglo[]){
            int salto, aux;
            boolean cambio;
            String mensaje="Notas Ordenadas con Shell\n";
            for(salto=(arreglo.length)/2 ; salto != 0 ; salto /=2){
                cambio=true;
                while(cambio){
                    cambio=false;
                    for(int i=salto;i<arreglo.length;i++){
                        if(arreglo[i-salto]>arreglo[i]){
                            aux=arreglo[i];
                            arreglo[i]=arreglo[i-salto];
                            arreglo[i-salto]=aux;
                            cambio=true;
                        }
                    }
                }
            }
            for (int i = 0; i < arreglo.length; i++) {
                 mensaje=mensaje +arreglo[i] +" -";
            }
            return mensaje;
        }
    }
    

