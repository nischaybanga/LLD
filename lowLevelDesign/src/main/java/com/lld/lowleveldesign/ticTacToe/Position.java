package com.lld.lowleveldesign.ticTacToe;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class Position {
    public int row;
    public int column;
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public boolean isEqual(Position position) {
        return this.row == position.row && this.column == position.column;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
