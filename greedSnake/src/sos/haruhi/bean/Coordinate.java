package sos.haruhi.bean;

/**
 * 坐标
 */
public class Coordinate {
    private int col;
    private int row;

    public Coordinate(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Coordinate){
            Coordinate _coordinate = (Coordinate) obj;
            if(this.col == _coordinate.col && this.row == _coordinate.row){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.col) + String.valueOf(this.row)).hashCode();
    }
}
