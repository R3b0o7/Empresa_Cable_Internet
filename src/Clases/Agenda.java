package Clases;

import Excepciones.GenericException;

import java.util.*;

public class Agenda {

    //El calendario es una matriz de enteros de 365X25 (8:00 hs a 20:00 hs son 25 horarios)
    private int[][] calendario;
    private Map<String, Integer> equivalenciaHoraFila;
    private Map<Integer, String> equivalenciaFilaHora;

    public Agenda() {
        this.calendario = new int[365][25];
        this.equivalenciaHoraFila = new HashMap<String, Integer>();
        this.equivalenciaFilaHora = new HashMap<Integer, String>();
        //construyo claves y valores de las equivalencias fila-hora
        int hora = 8;
        String minuto = "00";
        for(int i = 0; i < 25; i++){
            String horaStr = hora + ":" + minuto;
            equivalenciaHoraFila.put(horaStr, i);
            if(minuto.equals("30")){
                hora++;
                minuto = "00";
            } else {
                minuto = "30";
            }
        }
        hora = 8;
        minuto = "00";
        for(int i = 0; i < 25; i++){
            String horaStr = hora + ":" + minuto;
            equivalenciaFilaHora.put(i, horaStr);
            if(minuto.equals("30")){
                hora++;
                minuto = "00";
            } else {
                minuto = "30";
            }
        }
    }

    public void agendarServicio(int idServicio, Date fecha, String horario, int unidadesTiempo ) throws GenericException {
        // TODO implementar
        int i = this.dateToColumn(fecha);
        int j = this.equivalenciaHoraFila.get(horario);

        if(j+unidadesTiempo > 24)
            throw new GenericException("Excede el horario de trabajo.");

        for(int k = 0; k < unidadesTiempo; k++){
            calendario[i][j] = idServicio;
            j++;
        }
    }

    public boolean esDisponible(Date fecha, String horario, int unidadesTiempo) throws GenericException{
        int i = this.dateToColumn(fecha);
        int j = this.equivalenciaHoraFila.get(horario);

        if(j+unidadesTiempo > 24)
            throw new GenericException("Excede el horario de trabajo.");

        for(int k = 0; k < unidadesTiempo; k++){
            if(calendario[i][j] != 0) {return false;};
            j++;
        }

        return true;
    }

    private int dateToColumn(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public Map<Integer, String> getEquivalenciaFilaHora() {
        return equivalenciaFilaHora;
    }
}