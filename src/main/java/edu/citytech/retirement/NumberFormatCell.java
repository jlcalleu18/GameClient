package edu.citytech.retirement;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class NumberFormatCell<S,T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {


    private String format = "##,###.00";

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public TableCell<S, T> call(TableColumn<S, T> stTableColumn) {
        var cell = new CustomTableCell(format);
        return cell;
    }
}
