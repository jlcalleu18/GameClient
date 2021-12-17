package edu.citytech.states.customTableCell;

import javafx.scene.control.TableCell;

import java.text.DecimalFormat;

public class CustomTableCellState extends TableCell {

    private String format = "###,###.00";
    private DecimalFormat decimalFormat = new DecimalFormat(format);

    public CustomTableCellState(){}
    public CustomTableCellState(String format){
        this.format = format;
        this.decimalFormat = new DecimalFormat(format);
    }
    @Override
    protected void updateItem(Object item, boolean isEmpty) {
        super.updateItem(item, isEmpty);
//        System.out.println("item: "+item+ " empty: "+isEmpty);
        setText(null);
        if (!isEmpty)
            setText(decimalFormat.format(item));
    }

    @Override
    public String toString() {
        return "CustomTableCellState{" +
                "format='" + format + '\'' +
                ", decimalFormat=" + decimalFormat +
                '}';
    }
}