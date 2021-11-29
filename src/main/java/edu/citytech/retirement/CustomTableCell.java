package edu.citytech.retirement;

import javafx.scene.control.TableCell;

import java.text.DecimalFormat;

public class CustomTableCell extends TableCell {

    private String format = "###,###.00";
    private DecimalFormat decimalFormat = new DecimalFormat(format);

    public CustomTableCell(){}
    public CustomTableCell(String format){
        this.format = format;
        this.decimalFormat = new DecimalFormat(format);
    }
    @Override
    protected void updateItem(Object item, boolean isEmpty) {
        super.updateItem(item, isEmpty);
        System.out.println("item: "+item+ " empty: "+isEmpty);
        setText(null);
        if (!isEmpty)
            setText(decimalFormat.format(item));
    }

    @Override
    public String toString() {
        return "CustomTableCell{" +
                "format='" + format + '\'' +
                ", decimalFormat=" + decimalFormat +
                '}';
    }
}