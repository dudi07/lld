package restaurentReservationSystem.src.main.java.model;


public class Table {
    private String tableId;
    private String capacity;

    public Table(String tableId, String capacity) {
        this.tableId = tableId;
        this.capacity = capacity;
    }

    
    public Table() {
    }

    
    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableId='" + tableId + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
