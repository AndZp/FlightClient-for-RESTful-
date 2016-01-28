package ua.com.ukrelektro.flight.models;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ua.com.ukrelektro.flight.rs.Flight;
import ua.com.ukrelektro.flight.rs.Place;


public class FlightModel extends AbstractTableModel {

    public static final int COLUMN_COUNT = 6;
    private List<Flight> list;
    private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

    public FlightModel(List<Flight> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    private int getFreeCount(Flight flight) {
        int count = 0;
        for (Place place : flight.getAircraft().getPlaceList()) {
            if (!place.isBusy()) {
                count++;
            }
        }

        return count;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Flight flight = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return flight.getCode();
            case 1:
                return formatDate.format(flight.getDateDepart().toGregorianCalendar().getTime());
            case 2:
                return formatDate.format(flight.getDateCome().toGregorianCalendar().getTime());
            case 3:
                return flight.getAircraft().getName();
            case 4:
                return flight.getDuration();
            case 5:
                return getFreeCount(flight);
        }
        return "";
    }


    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Code";
            case 1:
                return "Depart";
            case 2:
                return "Arrivel";
            case 3:
                return "Aircraft";
            case 4:
                return "Duration";
            case 5:
                return "Free places";

        }

        return "";
    }
}
