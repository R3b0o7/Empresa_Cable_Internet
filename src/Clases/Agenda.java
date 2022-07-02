package Clases;

import java.util.*;

public class Agenda {

    //El calendario es una matriz de enteros de 365X25 (8:30 hs a 20:30 hs son 25 horarios)
    private int[][] calendario;
    private Map<String, Integer> equivalenciaHoraFila;
    private Map<Integer, String> equivalenciaFilaHora;

    public Agenda() {
        this.calendario = new int[365][25];
        this.equivalenciaHoraFila = new HashMap<String, Integer>();
        this.equivalenciaFilaHora = new HashMap<Integer, String>();
        //construyo claves y valores de las equivalencias fila-hora
        int hora = 8;
        String minuto = "30";
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
        minuto = "30";
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

    public void agendarServicio(int idServicio, Date fecha, String horario ) {
        // TODO implementar
        int i = this.dateToColumn(fecha);
        int j = this.equivalenciaHoraFila.get(horario);
        calendario[i][j] = idServicio;
    }

    public boolean esDisponible(Date fecha, String horario){
        int i = this.dateToColumn(fecha);
        int j = this.equivalenciaHoraFila.get(horario);
        return calendario[i][j] == 0;
    }

    private int dateToColumn(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

}